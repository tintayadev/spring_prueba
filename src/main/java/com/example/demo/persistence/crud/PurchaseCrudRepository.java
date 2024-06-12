package com.example.demo.persistence.crud;

import com.example.demo.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseCrudRepository extends CrudRepository<Compra, Integer> {
}
