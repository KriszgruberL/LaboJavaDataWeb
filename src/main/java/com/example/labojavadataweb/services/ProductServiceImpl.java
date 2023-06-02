package com.example.labojavadataweb.services;

import com.example.labojavadataweb.models.entities.Product;
import com.example.labojavadataweb.repositories.ProductRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductServiceImpl implements ProductService, Serializable {

    @Inject
    ProductRepository productRepository;

    @Override
    public List<Product> getMany() {
        return productRepository.getMany();
    }

    @Override
    public Product add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
