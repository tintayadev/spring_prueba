package com.example.demo.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ComprasProductoId implements java.io.Serializable {
    private static final long serialVersionUID = 5944311666771971347L;
    @Column(name = "id_compra", nullable = false)
    private Integer idCompra;

    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ComprasProductoId entity = (ComprasProductoId) o;
        return Objects.equals(this.idCompra, entity.idCompra) &&
                Objects.equals(this.idProducto, entity.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompra, idProducto);
    }

}