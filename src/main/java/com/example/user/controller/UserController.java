package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.mapper.UserRequestMapper;
import com.example.user.mapper.UserResponseMapper;
import com.example.user.model.UserRequest;
import com.example.user.model.UserResponse;
import com.example.user.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import jakarta.validation.Valid; // For request body validation

@RestController
@RequestMapping("/api/user") // Matches basePath + path from swagger.yaml (assuming /api is context path or app property)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        // 1. Map Request DTO to Entity
        User userEntity = UserRequestMapper.toEntity(userRequest);

        // 2. Call Service to create user
        return userService.createUser(userEntity)
                // 3. Map Entity to Response DTO
                .map(UserResponseMapper::toDto);
    }
}
