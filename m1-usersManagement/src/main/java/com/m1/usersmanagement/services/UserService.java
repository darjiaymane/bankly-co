package com.m1.usersmanagement.services;

import com.m1.usersmanagement.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUsers();

    User getUserByEmail(String email);
}
