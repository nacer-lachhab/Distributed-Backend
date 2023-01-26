package com.example.gatewaymicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMicroServiceApplication.class, args);
    }

    //static config
//    @Bean
//    public RouteLocator routesLocator(RouteLocatorBuilder routeBuilder){
//        return routeBuilder.routes()
//                .route(r->r.path("/costumers/**").uri("lb://COSTUMER-SERVICE"/*"http://localhost:8081/"*/))
//                .route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE"/*"http://localhost:8082/"*/))
//                .build();
//    }

    //config dynamic
    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamicRoutesLocator(
            ReactiveDiscoveryClient rdc,
            DiscoveryLocatorProperties dlp)
    {
        //http://localhost:8888/INVENTORY-SERVICE/products
        //http://localhost:8888/COSTUMER-SERVICE/costumers
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }

    @Bean
    CommandLineRunner run(){
        return args -> System.out.println("Gateway started with success...");
    }
}
