package com.example.labojavadataweb.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Access(value = AccessType.FIELD)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String productName;

    @Column(length = 500)
    private String productDescription;

    @Column(length = 20)
    private BigDecimal productPrice;

    @Enumerated(EnumType.STRING)
    private Era era;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(length = 200)
    private String imageUrl;

}
