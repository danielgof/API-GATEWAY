package com.example.routes.api;

import com.example.routes.domain.Route;
import com.example.routes.service.RouteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/route")
public class RouteAPI {
    @Autowired
    private final RouteServiceImpl routeService;

    @PostMapping("/add_route")
    public ResponseEntity addNewPurchase(@RequestBody Route route) {
        if (routeService.addRoute(route)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_routes")
    public HttpStatus AllPurchases() {
        try {
//            return routeService.getAllRoutes();
            return HttpStatus.CREATED;
        }
        catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/remove_route")
    public HttpStatus removePurchase(@RequestBody Route route) {
        if (routeService.deleteRoute(route)) {
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
