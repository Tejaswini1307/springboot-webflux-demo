package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;
    // In a real app, you would also inject a PasswordEncoder here
    // private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository /*, PasswordEncoder passwordEncoder */) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
    }

    public Mono<User> createUser(User user) {
        // In a real application, you would hash the password before saving
        // For example:
        // user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Additional business logic can be added here, e.g., checking if username or email already exists
        // For example, to check if a user with the same username already exists:
        // return userRepository.findByUsername(user.getUsername())
        // .hasElement()
        // .flatMap(exists -> {
        // if (exists) {
        // return Mono.error(new RuntimeException("Username already exists")); // Or a custom exception
        // }
        // return userRepository.save(user);
        // });

        return userRepository.save(user);
    }
}
