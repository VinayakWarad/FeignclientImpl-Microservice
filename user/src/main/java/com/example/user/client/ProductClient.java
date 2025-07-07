package com.example.user.client;

import com.example.user.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/*
Without eureka you can makeuse of below with hardcoded url
@FeignClient(name = "product-service", url = "http://localhost:8083")
*/

//If you use discovery client / Eureka you don't need to specify url
//@FeignClient(name = "product-service")

@FeignClient(name = "product-service", url = "http://localhost:8083")
public interface ProductClient {
    @GetMapping("/products")
    List<Product> getAllProducts();

    @PostMapping("/products")
    Product addProduct(@RequestBody Product product);
}