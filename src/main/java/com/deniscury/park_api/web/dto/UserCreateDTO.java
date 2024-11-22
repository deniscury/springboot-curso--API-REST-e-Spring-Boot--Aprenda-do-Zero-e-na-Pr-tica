package com.deniscury.park_api.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class UserCreateDTO {

    @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.+-]+\\.[a-z]{2,}$", message = "E-mail com formato inválido.")
    @NotBlank(message = "Por favor preencha o e-mail")
    private String username;

    @NotBlank(message = "Por favor preencha a senha")
    @Size(min = 6, max = 6)
    private String password;
}
