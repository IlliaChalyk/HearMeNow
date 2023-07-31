package com.hearmenow.api.user.dao;

import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MockUserDaoImpl implements UserDao {
    private static final List<User> USERS = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        if (USERS.isEmpty()) {
            return List.of(
                    new User(UUID.randomUUID(), "Empty User1"),
                    new User(UUID.randomUUID(), "Empty User2"),
                    new User(UUID.randomUUID(), "Empty User3"),
                    new User(UUID.randomUUID(), "Latest User4"),
                    new User(UUID.randomUUID(), "Test Jenkins Job")
            );
        }
        return USERS;
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }

    @Override
    public UUID createUser(UserDto userDto) {
        var user = new User(UUID.randomUUID(), userDto.name());
        USERS.add(user);
        return user.getId();
    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {
        throw new UnsupportedOperationException("Method is not implemented yet.");
    }

    @Override
    public void deleteUser(UUID id) {
        throw new UnsupportedOperationException("Method is not implemented yet.");
    }
}
