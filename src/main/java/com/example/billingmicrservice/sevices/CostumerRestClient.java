package com.example.billingmicrservice.sevices;

import com.example.billingmicrservice.model.Costumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COSTUMER-SERVICE")
public interface CostumerRestClient {
    @GetMapping(path="/costumers/{id}")
    public Costumer findCostumerById(@PathVariable Long id);
}
