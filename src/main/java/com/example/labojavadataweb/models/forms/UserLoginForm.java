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
    private String login;


    @Password
    private String password;

    public User toEntity(){
        return User.builder()
                .username(this.getLogin())
                .password(this.password)
                .build();
    }

}
