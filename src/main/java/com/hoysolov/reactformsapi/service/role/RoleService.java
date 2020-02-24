package com.hoysolov.reactformsapi.service.role;

import com.hoysolov.reactformsapi.model.Role;
import com.hoysolov.reactformsapi.model.RoleName;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(RoleName roleName);

}
