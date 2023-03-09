package com.example.routes.service;

import com.example.routes.domain.Route;
import com.example.routes.repository.RouteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {
    @Autowired
    private final RouteRepository routeRepository;
    @Override
    public boolean addRoute(Route route) {
        try {
            routeRepository.save(route);
            return true;
        }
        catch (Exception e) {
            log.error("error {} occured", e);
            return false;
        }
    }

    @Override
    public List<Route> getAllRoutes() {
        try {
            return routeRepository.findAll();
        }
        catch (Exception e) {
            log.error("error {} occured", e);
            return null;
        }
    }

    @Override
    public boolean deleteRoute(Route route) {
        try {
            routeRepository.deleteById(route.getId());
            return true;
        }
        catch (Exception e) {
            log.error("error {} occured", e);
            return false;
        }
    }

//    @Override
//    public void updateRoute(Route route) {
//
//        if (Login != null && Login.length() > 0 && !Objects.equals(user.getLogin(), Login))
//        {
//            user.setLogin(Login);
//        }
//
//        if (Login != null && Login.length() > 0 && !Objects.equals(user.getLogin(), Login))
//        {
//            Optional<Users> userOptional = userRepository
//                    .findUsersById(user.getId());
//            if (userOptional.isPresent())
//            {
//                throw new IllegalStateException("login taken");
//            }
//            user.setPassword(Login);
//        }
//    }
}
