package com.example.demo.domain.repository;

import com.example.demo.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<Purchase> getPurchase(int purchaseId);
    Purchase save(Purchase purchase);
    void delete(int purchaseId);
}
