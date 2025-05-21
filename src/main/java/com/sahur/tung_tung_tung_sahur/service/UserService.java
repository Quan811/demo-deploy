package com.sahur.tung_tung_tung_sahur.service;

import com.sahur.tung_tung_tung_sahur.entity.User;
import com.sahur.tung_tung_tung_sahur.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String userID){
        return userRepository.findById(userID);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String userID, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setFirstname(userDetails.getFirstname());
            user.setLastname(userDetails.getLastname());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String userID) {
        userRepository.deleteById(userID);
    }
}
