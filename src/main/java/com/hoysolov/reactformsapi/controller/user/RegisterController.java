package com.hoysolov.reactformsapi.controller.user;

import com.hoysolov.reactformsapi.converter.user.UserConverter;
import com.hoysolov.reactformsapi.model.User;
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
    private final UserConverter userConverter;

    @Autowired
    public RegisterController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<HttpStatus> registerUser(@Valid @RequestBody final RegisterRequest registerRequest) {
        User user = userConverter.registerRequestToUser(registerRequest);
        userService.save(user);
        return ResponseEntity.ok().build();
    }

}
