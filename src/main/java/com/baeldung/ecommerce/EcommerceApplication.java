package com.baeldung.ecommerce;

import com.baeldung.ecommerce.model.Product;
import com.baeldung.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100"));
            productService.save(new Product(2L, "Game Console", 210.00, "http://placehold.it/200x100"));
            productService.save(new Product(3L, "Sofa", 100.00, "http://placehold.it/200x100"));
            productService.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100"));
            productService.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100"));
            productService.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100"));
            productService.save(new Product(7L, "Watch", 35.00, "https://images-na.ssl-images-amazon.com/images/I/81%2Bd6eSA0eL._UY445_.jpg"));
            productService.save(new Product(8L, "Shoes", 90.00, "http://placehold.it/200x100"));
            productService.save(new Product(9L, "Knife", 35.00, "http://placehold.it/200x100"));
            productService.save(new Product(10L, "Blanket", 15.00, "http://placehold.it/200x100"));
            productService.save(new Product(11L, "Chair", 30.00, "http://placehold.it/200x100"));
            productService.save(new Product(12L, "Keyboard", 25.00, "http://placehold.it/200x100"));
        };
    }
}
