package com.example.demo.persistence;

import com.example.demo.domain.dto.PurchaseProduct;
import com.example.demo.domain.repository.PurchaseProductRepository;
import com.example.demo.persistence.crud.PurchaseProductCrudRepository;
import com.example.demo.persistence.entity.ComprasProducto;
import com.example.demo.persistence.entity.ComprasProductoPK;
import com.example.demo.persistence.mapper.PurchaseProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComprasProductoRepository implements PurchaseProductRepository {
    @Autowired
    private PurchaseProductCrudRepository purchaseProductCrudRepository;
    @Autowired
    private PurchaseProductMapper mapper;

    @Override
    public List<PurchaseProduct> getAll() {
        List<ComprasProducto> comprasProductos = (List<ComprasProducto>) purchaseProductCrudRepository.findAll();
        return mapper.toPurchaseProducts(comprasProductos);
    }

    @Override
    public Optional<PurchaseProduct> getPurchaseProduct(int purchaseId, int productId) {
        ComprasProductoPK pk = new ComprasProductoPK();
        pk.setIdCompra(purchaseId);
        pk.setIdProducto(productId);
        return purchaseProductCrudRepository.findById(pk).map(comprasProducto -> mapper.toPurchaseProduct(comprasProducto));
    }

    @Override
    public PurchaseProduct save(PurchaseProduct purchaseProduct) {
        ComprasProducto comprasProducto = mapper.toComprasProducto(purchaseProduct);
        return mapper.toPurchaseProduct(purchaseProductCrudRepository.save(comprasProducto));
    }

    @Override
    public void delete(int purchaseId, int productId) {
        ComprasProductoPK pk = new ComprasProductoPK();
        pk.setIdCompra(purchaseId);
        pk.setIdProducto(productId);
        purchaseProductCrudRepository.deleteById(pk);
    }

}
