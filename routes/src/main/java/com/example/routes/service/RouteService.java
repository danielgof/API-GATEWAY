package com.example.routes.service;

import com.example.routes.domain.Route;

import java.util.List;

public interface RouteService {
    boolean addRoute(Route route);
    List<Route> getAllRoutes();
    boolean deleteRoute(Route route);
}
