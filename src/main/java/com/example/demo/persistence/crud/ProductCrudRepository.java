package com.example.demo.persistence.crud;

import com.example.demo.persistence.entity.Producto;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Producto, Integer> {
    /*@Query(value = "SELECT * FROM proudctos WHERE id_categoria=?", nativeQuery = true)
    List<Producto> findByIdCategoria(Integer idCategoria);
    */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int id);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
