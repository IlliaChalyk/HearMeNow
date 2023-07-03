package com.hearmenow.api.user.model;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String fullName;

    public User(UUID id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && fullName.equals(user.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }
}

