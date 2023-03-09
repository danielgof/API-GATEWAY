package com.example.routes.service;

import com.example.routes.domain.AuthRole;
import com.example.routes.domain.AuthUser;

import java.util.List;

public interface UserService {
    AuthUser saveUser(AuthUser user);
    AuthRole saveRole(AuthRole role);
    void addRoleToUser(String username, String rolename);
    AuthUser getUser(String username);
    List<AuthUser> getUsers();
}
