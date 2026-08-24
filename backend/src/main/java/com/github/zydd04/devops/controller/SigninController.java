package com.github.zydd04.devops.controller;

import com.github.zydd04.devops.model.User;
import com.github.zydd04.devops.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SigninController {

    private final UserRepository userRepository;

    public SigninController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody User credentials) {
        return userRepository.findByEmail(credentials.getEmail())
            .filter(user -> user.getPassword().equals(credentials.getPassword()))
            .map(user -> ResponseEntity.ok(user))
            .orElse(ResponseEntity.status(401).build());
    }
}