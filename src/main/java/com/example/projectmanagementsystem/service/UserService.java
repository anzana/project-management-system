package com.example.projectmanagementsystem.service;


import com.example.projectmanagementsystem.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();
    User updateUser(int id, User user);
    void deleteUser(int id);
}
