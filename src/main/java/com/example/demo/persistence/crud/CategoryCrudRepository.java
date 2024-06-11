package com.example.demo.persistence.crud;

import com.example.demo.domain.dto.Category;
import com.example.demo.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Categoria, Integer> {

}
