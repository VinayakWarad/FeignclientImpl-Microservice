package com.example.user.client;

import com.example.user.model.Product;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
    @Headers({
            "Content-Type: application/json",
            "Custom-Header: MyValue"
    })
    Product addProduct(@RequestBody Product product);

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable("id") String id);
}