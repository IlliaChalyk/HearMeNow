package com.hearmenow.api.user.service;

import com.hearmenow.api.user.dao.UserDao;
import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.exception.ResourceNotFoundException;
import com.hearmenow.api.user.mapper.UserDtoMapper;
import com.hearmenow.api.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserDtoMapper userDtoMapper;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserDtoMapper userDtoMapper) {
        this.userDao = userDao;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public UserDto getUser(UUID id) {
        return userDao
                .getUser(id)
                .map(userDtoMapper)
                .orElseThrow(
                        () -> new ResourceNotFoundException(format("User with id %s not found", id.toString()))
                );
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao
                .getAllUsers()
                .stream()
                .map(userDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public UUID createUser(UserDto userDto) {
        return userDao.createUser(userDto);
    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {
        if (!userDao.isUserExist(id)) {
            throw new ResourceNotFoundException(format("User with id %s not found", id.toString()));
        }

        userDao.updateUser(id, userDto);
    }

    @Override
    public void deleteUser(UUID id) {


        userDao.deleteUser(id);
    }
}
