package com.example.labojavadataweb.repositories.impl;

import com.example.labojavadataweb.models.entities.Product;
import com.example.labojavadataweb.repositories.ProductRepository;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Long, Product> implements ProductRepository {


    @Override
    public Class<Product> getClassName() {
        return Product.class;
    }

    @Override
    public List<Product> getMany() {
        TypedQuery<Product> query = em.createQuery("Select p from Product p", Product.class);
        return getList(query);
    }
}
