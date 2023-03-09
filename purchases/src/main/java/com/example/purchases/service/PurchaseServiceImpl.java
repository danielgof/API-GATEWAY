package com.example.purchases.service;

import com.example.purchases.domain.Purchase;
import com.example.purchases.repository.PurchaseRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private final PurchaseRepo purchaseRepo;

    @Override
    public boolean addPurchase(Purchase purchase) {
        try {
            purchaseRepo.save(purchase);
            return true;
        }
        catch (Exception e) {
            log.error("error {} occured", e);
            return false;
        }
    }

    @Override
    public List<Purchase> getAllPurchases() {
        try {
            return purchaseRepo.findAll();
        }
        catch (Exception e) {
            log.error("error {} occured", e);
            return null;
        }
    }

    @Override
    public boolean deletePurchase(Purchase purchase) {
        try {
            purchaseRepo.deleteById(purchase.getId());
            return true;
        }
        catch (Exception e) {
            log.error("error {} occured", e);
            return false;
        }
    }
}
