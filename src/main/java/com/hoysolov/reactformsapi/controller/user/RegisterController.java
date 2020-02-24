package com.hoysolov.reactformsapi.controller.user;

import com.hoysolov.reactformsapi.payload.RegisterRequest;
import com.hoysolov.reactformsapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<HttpStatus> registerUser(@Valid @RequestBody final RegisterRequest registerRequest) {
        userService.save(registerRequest);
        return ResponseEntity.ok().build();
    }

}
