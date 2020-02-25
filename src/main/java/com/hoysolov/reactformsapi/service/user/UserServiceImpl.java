package com.hoysolov.reactformsapi.service.user;

import com.hoysolov.reactformsapi.exception.AppException;
import com.hoysolov.reactformsapi.model.Role;
import com.hoysolov.reactformsapi.model.RoleName;
import com.hoysolov.reactformsapi.model.Gender;
import com.hoysolov.reactformsapi.model.User;
import com.hoysolov.reactformsapi.payload.RegisterRequest;
import com.hoysolov.reactformsapi.repository.UserRepository;
import com.hoysolov.reactformsapi.security.UserPrincipal;
import com.hoysolov.reactformsapi.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));

        return UserPrincipal.create(user);
    }

    @Override
    public User save(User user) {
        if (existsByUsername(user.getUsername())) {
            throw new AppException("Username is already taken!");
        }

        if (existsByEmail(user.getEmail())) {
            throw new AppException("Email is already in use!");
        }

        return userRepository.save(user);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new AppException("Does not exist user with id: " + id));
        return user;
    }
}
