package com.example.labojavadataweb.models.dtos;

import com.example.labojavadataweb.models.entities.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConnectedUserDTO {

    private Integer id;

    private String username;

    private String email;

    public static ConnectedUserDTO fromEntity(User user){

        return ConnectedUserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}