package com.m1.usersmanagement.services.imp;
import com.m1.usersmanagement.models.User;
import com.m1.usersmanagement.repositories.UserRepository;

import com.m1.usersmanagement.services.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
    @Transactional
    @Override
    public User updateUser(User user) {
        userRepository.findById(user.getId()).ifPresent(u -> {
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setCIN(user.getCIN());
        });
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
