package com.example.user.mapper;

import com.example.user.entity.User;
import com.example.user.model.UserResponse; // This import assumes UserResponse is generated here

public class UserResponseMapper {

    public static UserResponse toDto(User user) {
        if (user == null) {
            return null;
        }

        UserResponse userResponse = new UserResponse();
        if (user.getId() != null) {
            userResponse.setId(user.getId().toString());
        }
        userResponse.setUsername(user.getUsername());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        // Note: Password is not included in the response

        return userResponse;
    }
}
