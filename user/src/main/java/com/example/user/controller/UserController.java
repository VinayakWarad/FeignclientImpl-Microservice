package com.example.user.controller;

import com.example.user.client.ProductClient;
import com.example.user.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final ProductClient productClient;

    public UserController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productClient.getAllProducts();
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productClient.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable String id) {
        productClient.deleteProduct(id);
        return ResponseEntity.ok("Product deleted through Feign");
    }
}