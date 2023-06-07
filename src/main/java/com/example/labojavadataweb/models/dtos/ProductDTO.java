package com.example.labojavadataweb.models.dtos;

import com.example.labojavadataweb.models.entities.Era;
import com.example.labojavadataweb.models.entities.Product;
import com.example.labojavadataweb.models.entities.Type;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private Era era;
    private Type type;
    private String imageUrl;


    public ProductDTO(String productName, String productDescription, BigDecimal productPrice, Era era, Type type) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.era = era;
        this.type = type;
    }

    public static ProductDTO fromEntity(Product product){

        String productDescription;



        if (product.getProductDescription().length() < 20){
            productDescription = product.getProductDescription();
        } else {
            productDescription = product.getProductDescription().substring(0,20) + "...";
        }

        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .era(product.getEra())
                .type(product.getType())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
