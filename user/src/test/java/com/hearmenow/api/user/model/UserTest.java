package com.hearmenow.api.user.model;

import com.hearmenow.api.user.model.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {
    @Test
    public void UserGettersTest() {
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, "John Doe");

        assertEquals("John Doe", user.getFullName());
        assertEquals(uuid, user.getId());
    }
}