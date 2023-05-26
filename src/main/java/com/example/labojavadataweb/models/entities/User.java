package com.example.labojavadataweb.models.entities;


import com.example.labojavadataweb.validators.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Access(value = AccessType.FIELD)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "CUSTOMER",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_CUSTOMER_USERNAME", columnNames = "USERNAME"),
                @UniqueConstraint(name = "EMAIL", columnNames = "EMAIL")
        })

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", length = 50)
    private String username;

    @Column(name = "EMAIL", length = 100)
    private String email;

    private String password;


}
