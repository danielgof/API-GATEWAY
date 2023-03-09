package com.example.purchases.service;

import com.example.purchases.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    boolean addPurchase(Purchase purchase);
    List<Purchase> getAllPurchases();
    boolean deletePurchase(Purchase purchase);
}
