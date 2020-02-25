package com.hoysolov.reactformsapi.converter.user;

import com.hoysolov.reactformsapi.model.User;
import com.hoysolov.reactformsapi.payload.RegisterRequest;

public interface UserConverter {

    User registerRequestToUser(RegisterRequest registerRequest);

}
