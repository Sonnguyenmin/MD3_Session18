package com.ra.springorm_hibernate.repository;

import com.ra.springorm_hibernate.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product getProductById(Integer productId);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Integer productId);
    List<Product> findByName(String productName);
}
