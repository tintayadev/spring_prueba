package com.example.demo.persistence.crud;

import com.example.demo.persistence.entity.ComprasProducto;
import com.example.demo.persistence.entity.ComprasProductoPK;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseProductCrudRepository extends CrudRepository<ComprasProducto, ComprasProductoPK> {
}
