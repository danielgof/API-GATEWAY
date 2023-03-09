package com.example.auth;

import com.example.auth.domain.AuthRole;
import com.example.auth.domain.AuthUser;
import com.example.auth.service.UserService;
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
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
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

            userService.saveUser(new AuthUser("John", "john3", "1234", new ArrayList<>()));
            userService.saveUser(new AuthUser("David", "dv44", "1234",new ArrayList<>()));
            userService.saveUser(new AuthUser("Ross", "user", "1234", new ArrayList<>()));
            userService.saveUser(new AuthUser("Chandler", "chb", "1234",new ArrayList<>()));

            userService.addRoleToUser("john3", "ROLE_USER");
            userService.addRoleToUser("dv44", "ROLE_USER");
            userService.addRoleToUser("user", "ROLE_USER");
            userService.addRoleToUser("chb", "ROLE_ADMIN");
            userService.addRoleToUser("chb", "ROLE_USER");
        };
    }
}
