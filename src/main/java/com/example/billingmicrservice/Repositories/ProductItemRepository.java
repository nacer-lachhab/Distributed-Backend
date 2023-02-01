package com.example.billingmicrservice.Repositories;

import com.example.billingmicrservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
