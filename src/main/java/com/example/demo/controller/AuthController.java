package com.example.demo.controller;

import com.example.demo.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>>
    register(@RequestBody User user) {

        userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message",
                "User registered successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>>
    login(@RequestBody User user) {

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        return ResponseEntity.ok(response);
    }
}