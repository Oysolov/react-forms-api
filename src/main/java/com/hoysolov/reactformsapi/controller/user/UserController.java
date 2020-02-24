package com.hoysolov.reactformsapi.controller.user;

import com.hoysolov.reactformsapi.model.User;
import com.hoysolov.reactformsapi.payload.UserProfileResponse;
import com.hoysolov.reactformsapi.security.CurrentUser;
import com.hoysolov.reactformsapi.security.UserPrincipal;
import com.hoysolov.reactformsapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public UserProfileResponse getProfile(@CurrentUser UserPrincipal currentUser) {
        Long currentUserId = currentUser.getId();
        User user = userService.findById(currentUserId);
        UserProfileResponse userProfile = new UserProfileResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getSex().name(),
                user.getDevSkills()
        );
        return userProfile;
    }

}