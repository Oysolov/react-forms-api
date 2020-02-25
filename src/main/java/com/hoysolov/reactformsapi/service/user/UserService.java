package com.hoysolov.reactformsapi.service.user;

import com.hoysolov.reactformsapi.model.User;
import com.hoysolov.reactformsapi.payload.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(User user);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User findById(Long currentUserId);
}
