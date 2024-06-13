package com.example.demo.persistence.mapper;

import com.example.demo.domain.dto.PurchaseProduct;
import com.example.demo.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, PurchaseMapper.class})
public interface PurchaseProductMapper {
    @Mappings({
            @Mapping(source = "id.idCompra", target = "purchaseId"),
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseProduct toPurchaseProduct(ComprasProducto comprasProducto);
    List<PurchaseProduct> toPurchaseProducts(List<ComprasProducto> comprasProductos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseProduct purchaseProduct);
}
