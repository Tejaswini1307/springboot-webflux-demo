package com.example.user.mapper;

import com.example.user.entity.User;
import com.example.user.model.UserRequest; // This import assumes UserRequest is generated here

public class UserRequestMapper {

    public static User toEntity(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword()); // Remember to handle password hashing in the service layer

        return user;
    }
}
