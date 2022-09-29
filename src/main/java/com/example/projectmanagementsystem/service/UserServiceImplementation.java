package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.entity.User;
import com.example.projectmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public User updateUser(int id, User user) {
        Optional<User> userFromDb = userRepo.findById(id);

        userFromDb.map(u -> {
           u.setFirstName(user.getFirstName());
           u.setLastName(user.getLastName());
           u.setEmail(user.getEmail());
           u.setBillingAddress(user.getBillingAddress());
           u.setMailingAddress(user.getMailingAddress());
           u.setRole(user.getRole());
           return userRepo.save(u);

        }).orElseGet(() ->  { return userRepo.save(user); }
        );

        return user;
    }

    @Override
    public void deleteUser(int id) {
       userRepo.deleteById(id);
    }
}
