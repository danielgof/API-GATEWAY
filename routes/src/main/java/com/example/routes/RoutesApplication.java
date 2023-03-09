package com.example.routes;

import com.example.routes.domain.AuthRole;
import com.example.routes.domain.AuthUser;
import com.example.routes.domain.Route;
import com.example.routes.service.RouteServiceImpl;
import com.example.routes.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
public class RoutesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoutesApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(RouteServiceImpl routeService) {
        return args -> {routeService.addRoute(
                new Route(1L, "ddd", "2022-09-05", "2022-09-25",
                        "Turkey", "Istanbul", "dddd",
                        "plane"));
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new AuthRole("ROLE_USER"));
            userService.saveRole(new AuthRole("ROLE_ADMIN"));

//            userService.saveUser(new AuthUser("John", "john3", "1234", new ArrayList<>()));
            userService.saveUser(new AuthUser("David", "dv44", "1234",new ArrayList<>()));
            userService.saveUser(new AuthUser("Ross", "user", "1234", new ArrayList<>()));
            userService.saveUser(new AuthUser("Chandler", "chb", "1234",new ArrayList<>()));

//            userService.addRoleToUser("john3", "ROLE_USER");
            userService.addRoleToUser("dv44", "ROLE_USER");
            userService.addRoleToUser("user", "ROLE_USER");
            userService.addRoleToUser("chb", "ROLE_ADMIN");
            userService.addRoleToUser("chb", "ROLE_USER");
        };
    }
}
