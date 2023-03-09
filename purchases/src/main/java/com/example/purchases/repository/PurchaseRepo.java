package com.example.purchases.repository;

import com.example.purchases.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
    Purchase getPurchaseById(Purchase purchase);
}
