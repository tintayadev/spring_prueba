package com.example.demo.domain.repository;

import com.example.demo.domain.dto.PurchaseProduct;

import java.util.List;
import java.util.Optional;

public interface PurchaseProductRepository {
    List<PurchaseProduct> getAll();
    Optional<PurchaseProduct> getPurchaseProduct(int purchaseId, int productId);
    PurchaseProduct save(PurchaseProduct purchaseProduct);
    void delete(int purchaseId, int productId);
}
