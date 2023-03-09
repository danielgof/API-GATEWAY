package com.example.auth.repo;

import com.example.auth.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}
