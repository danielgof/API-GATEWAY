package com.example.routes.repository;

import com.example.routes.domain.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<AuthRole, Long> {
    AuthRole findByName(String name);
}
