package com.application.app.mapper;

import java.util.List;

import com.application.app.entity.User;

public interface UserMapper {
    User getId(Integer id);
    User getUsername(String Username);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    List<User> getAllUsers();

}
