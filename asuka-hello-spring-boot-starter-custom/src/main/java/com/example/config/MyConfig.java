package com.example.config;

import com.example.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        return helloService;
    }
}
