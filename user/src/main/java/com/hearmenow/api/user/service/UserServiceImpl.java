package com.hearmenow.api.user.service;

import com.hearmenow.api.user.dao.MockUserDaoImpl;
import com.hearmenow.api.user.dto.UserDto;
import com.hearmenow.api.user.exception.ResourceNotFoundException;
import com.hearmenow.api.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
public class UserServiceImpl implements UserService {
    private final MockUserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(MockUserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(UUID id) {
        return userDao
                .getUser(id)
                .orElseThrow(() -> new ResourceNotFoundException(format("User with id %s not found", id.toString())));
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UUID createUser(UserDto userDto) {
        return userDao.createUser(userDto);
    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {
        userDao.updateUser(id, userDto);
    }

    @Override
    public void deleteUser(UUID id) {
        userDao.deleteUser(id);
    }
}
