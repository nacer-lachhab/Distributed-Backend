package com.example.billingmicrservice.web;

import com.example.billingmicrservice.Repositories.BillRepository;
import com.example.billingmicrservice.Repositories.ProductItemRepository;
import com.example.billingmicrservice.entities.Bill;
import com.example.billingmicrservice.sevices.CostumerRestClient;
import com.example.billingmicrservice.sevices.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private ProductRestClient productRestClient;
    private CostumerRestClient costumerRestClient;

    public BillRestController(BillRepository billRepository,
                              ProductItemRepository productItemRepository,
                              ProductRestClient productRestClient,
                              CostumerRestClient costumerRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productRestClient = productRestClient;
        this.costumerRestClient = costumerRestClient;
    }

    @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        bill.setCostumer(costumerRestClient.findCostumerById(bill.getCostumerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
        });
        return null;
    }
}
