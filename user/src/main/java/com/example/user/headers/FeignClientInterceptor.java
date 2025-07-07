package com.example.user.headers;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

// THis class make sure that all feign client request we make will have
//Authorization and custom header in it
// This class is dedicated for it

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer your-token");
        template.header("Custom-Header", "MyValue");
    }
}
