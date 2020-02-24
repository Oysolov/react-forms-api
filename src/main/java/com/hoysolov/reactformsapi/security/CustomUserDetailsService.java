//package com.hoysolov.reactformsapi.security;
//
//import com.hoysolov.reactformsapi.model.User;
//import com.hoysolov.reactformsapi.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
//
//        return UserPrincipal.create(user);
//    }
//
//    public UserDetails loadUserById(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with id: " + id));
//        return UserPrincipal.create(user);
//    }
//}
