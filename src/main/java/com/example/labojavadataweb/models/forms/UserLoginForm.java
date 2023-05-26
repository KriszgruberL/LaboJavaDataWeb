package com.example.labojavadataweb.models.forms;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.validators.Email;
import com.example.labojavadataweb.validators.Password;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginForm {

    @NotBlank
    @Size(min = 1)
    private String username;

//    @Email
    private String email;

//    @Password
    private String password;

    public User toEntity(){
        return User.builder()
                .username(this.getUsername())
                .email(this.getEmail())
                .password(this.password)
                .build();
    }

}
