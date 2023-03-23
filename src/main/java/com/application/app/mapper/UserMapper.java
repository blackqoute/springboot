package com.application.app.mapper;

import java.util.List;

import com.application.app.entity.User;

public interface UserMapper {
    User getUserById(Long id);
    User getUserByUsername(String Username);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
