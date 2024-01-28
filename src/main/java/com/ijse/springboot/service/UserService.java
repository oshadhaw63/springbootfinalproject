package com.ijse.springboot.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.springboot.entity.User;

@Service
public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}