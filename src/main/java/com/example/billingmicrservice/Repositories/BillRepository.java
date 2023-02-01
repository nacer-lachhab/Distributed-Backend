package com.example.billingmicrservice.Repositories;

import com.example.billingmicrservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
