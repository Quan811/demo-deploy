package com.sahur.tung_tung_tung_sahur.controller;

import com.sahur.tung_tung_tung_sahur.entity.User;
import com.sahur.tung_tung_tung_sahur.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    private User user;

    @GetMapping("")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable String userID, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(userID, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userID) {
        userService.deleteUser(userID);
        return ResponseEntity.ok().build();
    }
    
}
