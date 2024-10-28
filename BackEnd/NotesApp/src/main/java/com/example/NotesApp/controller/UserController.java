package com.example.NotesApp.controller;

import com.example.NotesApp.dto.UserDTO;
import com.example.NotesApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/by-username/{username}")
    public Optional<UserDTO> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
