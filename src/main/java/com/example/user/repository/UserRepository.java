package com.example.user.repository;

import com.example.user.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
    // You can add custom query methods here if needed, for example:
    // Mono<User> findByUsername(String username);
}
