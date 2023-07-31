package com.hearmenow.api.user.service;

import com.hearmenow.api.user.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUser(UUID id);

    UUID createUser(UserDto user);

    void updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);
}
