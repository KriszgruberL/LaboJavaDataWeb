package com.example.labojavadataweb.services;

import com.example.labojavadataweb.models.entities.Product;
import com.example.labojavadataweb.models.forms.ProductForm;

import java.util.List;

public interface ProductService {

    List<Product> getMany();
    Product add(ProductForm productForm);
    void delete(Long id);
    void update(Product product);
}
