package com.example.product.controller;

import com.example.product.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(
                new Product("1", "Laptop"),
                new Product("2", "Smartphone")
        );
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product; // echo back created product
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok("Product deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}