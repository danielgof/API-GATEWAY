package com.example.routes.repository;

import com.example.routes.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}
