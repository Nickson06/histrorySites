package com.example.historicalsites.controller;

import com.example.historicalsites.model.User;
import com.example.historicalsites.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping
    public User updateUser(@RequestBody User newUser) {
        return userRepository.findById(newUser.getId())
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(null);
                    return userRepository.save(newUser);
                });
    }
}
