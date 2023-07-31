package com.hearmenow.api.user.dao;

import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.exception.ResourceNotFoundException;
import com.hearmenow.api.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@Repository
public class MockUserDaoImpl implements UserDao {
    private static final List<User> USERS = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return USERS;
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }

    @Override
    public Boolean isUserExist(UUID id) {
        return USERS.stream()
                .anyMatch(user -> user.getId() == id);
    }

    @Override
    public UUID createUser(UserDto userDto) {
        var user = new User(UUID.randomUUID(), userDto.name());
        USERS.add(user);
        return user.getId();
    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {
        USERS.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException(format("User with id %s not found", id.toString())))
                .setFullName(userDto.name());
    }

    @Override
    public void deleteUser(UUID id) {
        USERS.removeIf(user -> user.getId() == id);
    }
}
