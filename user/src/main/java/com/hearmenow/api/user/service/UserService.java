package com.hearmenow.api.user.service;

import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsers();

    User getUser(UUID id);

    UUID createUser(UserDto user);

    void updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);
}
