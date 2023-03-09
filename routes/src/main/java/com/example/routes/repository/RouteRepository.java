package com.example.routes.repository;

import com.example.routes.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    Route getRouteById(Route route);
}
