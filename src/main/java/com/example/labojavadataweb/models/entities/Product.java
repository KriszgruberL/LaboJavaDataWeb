package com.example.labojavadataweb.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String productName;

    @Column(length = 500)
    private String productDescription;

    @Column(length = 20)
    private String productPrice;

    @Enumerated(EnumType.STRING)
    private Era era;

    @Enumerated(EnumType.STRING)
    private Type type;

}
