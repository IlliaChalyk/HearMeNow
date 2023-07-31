package com.hearmenow.api.user.mapper;

import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.model.User;

import java.util.function.Function;

public class UserDtoMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getId(), user.getFullName());
    }
}
