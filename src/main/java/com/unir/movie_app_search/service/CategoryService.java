package com.unir.movie_app_search.service;

import com.unir.movie_app_search.persistence.entity.CategoryEntity;
import com.unir.movie_app_search.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getAll() {
        return null;//this.categoryRepository.findAll();
    }

    public Optional<CategoryEntity> get(String idCategory) {
        return this.categoryRepository.findById(idCategory);
    }

    public CategoryEntity save(CategoryEntity categoryEntity) {
        return this.categoryRepository.save(categoryEntity);
    }

    public void delete(String idCategory) {
        this.categoryRepository.deleteById(idCategory);
    }

    public boolean exists(String idCategory) {
        return this.categoryRepository.existsById(idCategory);
    }

}
