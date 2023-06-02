package com.example.labojavadataweb.services;

import com.example.labojavadataweb.models.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getMany();
    Product add(Product product);
    void delete(Long id);
    void update(Product product);
}
