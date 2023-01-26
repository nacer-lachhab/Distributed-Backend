package com.nacer.inventorymicroservice;

import com.nacer.inventorymicroservice.entities.Product;
import com.nacer.inventorymicroservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryMicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository pr, RepositoryRestConfiguration restConfig){
        return t->{
            restConfig.exposeIdsFor(Product.class);
            pr.saveAll(
                    List.of(
                            Product.builder().nom("computer").qte(12).price(5200).build(),
                            Product.builder().nom("smartphone").qte(10).price(1200).build(),
                            Product.builder().nom("printer").qte(30).price(3000).build(),
                            Product.builder().nom("radio").qte(10).price(700).build()
                    )
            );
        };
    }
}
