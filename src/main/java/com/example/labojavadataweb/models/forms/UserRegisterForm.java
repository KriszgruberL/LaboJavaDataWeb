package com.example.labojavadataweb.models.forms;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.validators.Email;
import com.example.labojavadataweb.validators.Password;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterForm {

    @NotBlank
    @Size(min = 1)
    private String username;

    @Email
    private String email;

    @Password
    private String password;

    @Password
    private String confirmPassword;

    private boolean admin;

    public User toEntity(){

        return User.builder()
                .username(getUsername())
                .email(getEmail())
                .password(getPassword())
                .admin(isAdmin())
                .build();
    }
}
