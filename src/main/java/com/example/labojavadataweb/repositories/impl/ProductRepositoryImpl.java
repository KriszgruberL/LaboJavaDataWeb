package com.example.labojavadataweb.repositories.impl;

import com.example.labojavadataweb.models.entities.Product;
import com.example.labojavadataweb.repositories.ProductRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductRepositoryImpl extends BaseRepositoryImpl<Long, Product> implements ProductRepository, Serializable {

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
