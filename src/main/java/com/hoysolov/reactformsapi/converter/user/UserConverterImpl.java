package com.hoysolov.reactformsapi.converter.user;

import com.hoysolov.reactformsapi.exception.AppException;
import com.hoysolov.reactformsapi.model.Gender;
import com.hoysolov.reactformsapi.model.Role;
import com.hoysolov.reactformsapi.model.RoleName;
import com.hoysolov.reactformsapi.model.User;
import com.hoysolov.reactformsapi.payload.RegisterRequest;
import com.hoysolov.reactformsapi.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserConverterImpl(RoleService roleService, BCryptPasswordEncoder encoder) {
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @Override
    public User registerRequestToUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        user.setDevSkills(registerRequest.getDevSkills());

        try {
            Gender gender = Gender.valueOf(registerRequest.getGender().toUpperCase());
            user.setGender(gender);
        } catch (IllegalArgumentException e) {
            throw new AppException("Invalid gender!");
        }

        Role userRole = roleService.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        user.setRole(userRole);

        return user;
    }
}
