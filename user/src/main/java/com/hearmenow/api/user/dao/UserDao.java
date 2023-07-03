package com.hearmenow.api.user.dao;

import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    List<User> getAllUsers();

    Optional<User> getUser(UUID id);

    UUID createUser(UserDto userDto);

    void updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);
}
