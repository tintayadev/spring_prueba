package com.example.demo.persistence;

import com.example.demo.domain.dto.Purchase;
import com.example.demo.domain.repository.PurchaseRepository;
import com.example.demo.persistence.crud.PurchaseCrudRepository;
import com.example.demo.persistence.entity.Compra;
import com.example.demo.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll(){
        List<Compra> compras = (List<Compra>) purchaseCrudRepository.findAll();
        return mapper.toPurchases(compras);
    }

    @Override
    public Optional<Purchase> getPurchase(int purchaseId){
        return purchaseCrudRepository.findById(purchaseId).map(compra -> mapper.toPurchase(compra));
    }

    @Override
    public Purchase save(Purchase purchase){
        Compra compra = mapper.toCompra(purchase);
        return mapper.toPurchase(purchaseCrudRepository.save(compra));
    }

    @Override
    public void delete(int purchaseId){
        purchaseCrudRepository.deleteById(purchaseId);
        purchaseCrudRepository.deleteById(purchaseId);
    }
}
