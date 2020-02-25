package com.hoysolov.reactformsapi.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class LoginRequest {

    @NotBlank
    @Size(min = 3, max = 40)
    private String usernameOrEmail;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

}
