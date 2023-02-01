package com.example.billingmicrservice.entities;

import com.example.billingmicrservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne
    private Bill bill;
    private int quantity;
    private double price;
    private double discounnt;

    @Transient
    private Product product;
}
