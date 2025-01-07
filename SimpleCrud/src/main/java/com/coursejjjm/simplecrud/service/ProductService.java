package com.coursejjjm.simplecrud.service;

import com.coursejjjm.simplecrud.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Product product);
    void delete(Product product);
}
