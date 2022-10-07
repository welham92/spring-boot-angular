package com.baeldung.ecommerce.service;

import com.baeldung.ecommerce.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.StreamSupport;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

    default Double getMean() {
        Iterable<Product> products = getAllProducts();
        double total = 0.0;
        int size = 0;
        for (Product product : products) {
            total += product.getPrice();
            size++;
        }
        if (size > 0) {
            return total / size;
        } else {
            return null;
        }
    }

    default Double getMedian() {
        Iterable<Product> products = getAllProducts();
        List<Product> sortedProducts = StreamSupport.stream(products.spliterator(), false)
                .sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
        DoubleStream sortedPrices = sortedProducts.stream().mapToDouble(Product::getPrice);
        if (sortedProducts.size() > 0) {
            // Maths dictates that the below warnings can be ignored (hopefully)...
            return sortedProducts.size() % 2 == 0 ?
                    sortedPrices.skip(sortedProducts.size() / 2 - 1).limit(2).average().getAsDouble() :
                    sortedPrices.skip(sortedProducts.size() / 2).findFirst().getAsDouble();
        } else {
            return null;
        }
    }

    default Double getMode() {
        Iterable<Product> products = getAllProducts();
        double mode = 0.0;
        int modeCount = 0;
        Map<Double, Integer> counts = new HashMap<>();
        int processed = 0;
        for (Product product : products) {
            processed++;
            int count = counts.merge(product.getPrice(), 1, Integer::sum);
            if (count > modeCount) {
                mode = product.getPrice();
                modeCount = count;
            }
        }
        if (processed > 0) {
            return mode;
        } else {
            return null;
        }
    }
}
