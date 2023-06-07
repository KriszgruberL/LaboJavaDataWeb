package com.example.labojavadataweb.models.forms;

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
public class ProductForm {

    @Column(length = 100)
    private String productName;

    @Column(length = 500)
    private String productDescription;

    @Column(length = 20)
    private BigDecimal productPrice;

    private String era;
    private String type;
    private String imageUrl;

    public Product toEntity(){
        Era eraValue = (era != null) ? Era.fromString(this.getEra()) : null;
        Type typeValue = (type != null) ? Type.fromString(this.getType()) : null;

        return Product.builder()
                .productName(this.getProductName())
                .productDescription(this.getProductDescription())
                .productPrice(this.getProductPrice())
                .era(Era.fromString(this.getEra()))
                .type(Type.fromString(this.getType()))
                .imageUrl(this.getImageUrl())
                .build();
    }
}
