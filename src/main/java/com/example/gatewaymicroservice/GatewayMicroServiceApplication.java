package com.example.gatewaymicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMicroServiceApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeBuilder){
        return routeBuilder.routes()
                .route(r->r.path("/costumers/**").uri("http://localhost:8081/"))
                .route(r->r.path("/products/**").uri("http://localhost:8082/"))
                .build();
    }

    @Bean
    CommandLineRunner run(){
        return args -> System.out.println("Gateway started with success...");
    }
}
