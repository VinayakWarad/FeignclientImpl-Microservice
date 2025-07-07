package com.example.product.controller;

import com.example.product.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(
                new Product("1", "Laptop"),
                new Product("2", "Smartphone")
        );
    }
    private List<Product> products = new ArrayList<>();

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product; // echo back created product
    }


}