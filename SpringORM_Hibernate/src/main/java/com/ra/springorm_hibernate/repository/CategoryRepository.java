package com.ra.springorm_hibernate.repository;

import com.ra.springorm_hibernate.model.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    boolean save(Category category);
    boolean update(Category category);
    boolean delete(Integer categoryId);
    Category getCategoryById(Integer categoryId);
}
