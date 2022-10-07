package com.baeldung.ecommerce.controller;

import com.baeldung.ecommerce.model.Product;
import com.baeldung.ecommerce.service.ProductService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Cacheable("allProducts")
    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = {"", "/mean"})
    public @NotNull Double getMean() {
        return productService.getMean();
    }

    @GetMapping(value = {"", "/median"})
    public @NotNull Double getMedian() {
        return productService.getMedian();
    }

    @GetMapping(value = {"", "/mode"})
    public @NotNull Double getMode() {
        return productService.getMode();
    }
}
