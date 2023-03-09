package com.example.auth.service;

import com.example.auth.domain.AuthRole;
import com.example.auth.domain.AuthUser;
import com.example.auth.repo.RoleRepo;
import com.example.auth.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public AuthUser saveUser(AuthUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public AuthRole saveRole(AuthRole role) {
        return roleRepo.save(role);
    }

    @Override
    @Transactional
    public void addRoleToUser(String username, String rolename) {
        AuthUser user = userRepo.findByUsername(username);
        AuthRole role = roleRepo.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public AuthUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AuthUser> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(authRole -> {
            authorities.add(new SimpleGrantedAuthority(authRole.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
