package com.example.auth.repo;

import com.example.auth.domain.AuthRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<AuthRole, Long> {
    AuthRole findByName(String name);
}
