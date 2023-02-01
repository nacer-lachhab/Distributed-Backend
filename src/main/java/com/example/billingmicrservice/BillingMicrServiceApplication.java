package com.example.billingmicrservice;

import com.example.billingmicrservice.Repositories.BillRepository;
import com.example.billingmicrservice.Repositories.ProductItemRepository;
import com.example.billingmicrservice.entities.Bill;
import com.example.billingmicrservice.entities.ProductItem;
import com.example.billingmicrservice.model.Costumer;
import com.example.billingmicrservice.model.Product;
import com.example.billingmicrservice.sevices.CostumerRestClient;
import com.example.billingmicrservice.sevices.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingMicrServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingMicrServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            CostumerRestClient costumerRestClient,
            ProductRestClient productRestClient){
        return args -> {
            Collection<Product> products = productRestClient.allProducts().getContent();
            Long costumerId = 1l;
            Costumer costumer = costumerRestClient.findCostumerById(costumerId);
            if(costumer == null) throw new RuntimeException("Costumer not Found!!!");
            Bill bill = new Bill();
            bill.setBillDate(new Date());
            bill.setCostumerId(costumerId );
            Bill savedBill = billRepository.save(bill);
            products.forEach(product->{
                ProductItem productItem = new ProductItem();
                productItem.setBill(savedBill);
                productItem.setProductId(product.getId());
                productItem.setQuantity(1 + new Random().nextInt(10));
                productItem.setPrice(product.getPrice());
                productItem.setDiscounnt(Math.random());
                productItemRepository.save(productItem);
            });
            System.out.println("hhhhhhhhhh");
        };
    }
}
