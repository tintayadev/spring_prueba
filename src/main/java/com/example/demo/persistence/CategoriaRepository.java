package com.example.demo.persistence;

import com.example.demo.domain.dto.Category;
import com.example.demo.domain.repository.CategoryRepository;
import com.example.demo.persistence.crud.CategoryCrudRepository;
import com.example.demo.persistence.entity.Categoria;
import com.example.demo.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoriaRepository implements CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    @Autowired
    private CategoryMapper mapper;


    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoryCrudRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoryCrudRepository.findById(categoryId)
                .map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoryCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoryCrudRepository.deleteById(categoryId);
    }
    /*
    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoryCrudRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoryCrudRepository.findById(categoryId).map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategory(category);
        return mapper.toCategory(categoryCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoryCrudRepository.deleteById(categoryId);
    }
    */
}
