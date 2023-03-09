package com.example.purchases.api;

import com.example.purchases.domain.Purchase;
import com.example.purchases.service.PurchaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/purchase")
public class PurchaseAPI {

    @Autowired
    private final PurchaseServiceImpl purchaseService;

    @PostMapping("/add_purchase")
    public HttpStatus addNewPurchase(@RequestBody Purchase purchase) {
        if (purchaseService.addPurchase(purchase)) {
            return HttpStatus.CREATED;
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/get_purchases")
    public List<Purchase> AllPurchases() {
        try {
            return purchaseService.getAllPurchases();
        }
        catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/remove_purchase")
    public HttpStatus removePurchase(@RequestBody Purchase purchase) {
        if (purchaseService.deletePurchase(purchase)) {
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
