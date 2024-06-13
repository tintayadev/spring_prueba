package com.example.demo.domain.service;

import com.example.demo.domain.dto.PurchaseProduct;
import com.example.demo.domain.repository.PurchaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseProductService {
    @Autowired
    private PurchaseProductRepository purchaseProductRepository;

    public List<PurchaseProduct> getAll() {
        return purchaseProductRepository.getAll();
    }

    public Optional<PurchaseProduct> getPurchaseProduct(int purchaseId, int productId) {
        return purchaseProductRepository.getPurchaseProduct(purchaseId, productId);
    }

    public PurchaseProduct save(PurchaseProduct purchaseProduct) {
        return purchaseProductRepository.save(purchaseProduct);
    }

    public boolean delete(int purchaseId, int productId) {
        return getPurchaseProduct(purchaseId, productId).map(purchaseProduct -> {
            purchaseProductRepository.delete(purchaseId, productId);
            return true;
        }).orElse(false);
    }
}
