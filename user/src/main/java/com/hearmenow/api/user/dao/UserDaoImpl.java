package com.hearmenow.api.user.dao;

import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of(
                new User(UUID.randomUUID(), "Illia Chalyk"),
                new User(UUID.randomUUID(), "Anna Chalyk")
        );
//        var sql = """
//                SELECT
//                    id,
//                    firstname,
//                    lastname
//                FROM
//                    user;
//                """;
//        jdbcTemplate.query(sql, (row, i) -> {
//            return new User(
//                    UUID.fromString(row.getString("id")),
//                    row.getString("fullname")
//                    );
//        });
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return Optional.empty();
    }

    @Override
    public UUID createUser(UserDto userDto) {
        return null;
    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {

    }

    @Override
    public void deleteUser(UUID id) {

    }
}
