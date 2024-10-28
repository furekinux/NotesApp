package com.example.NotesApp.service;

import com.example.NotesApp.dto.UserDTO; // Importa el DTO
import com.example.NotesApp.model.User;
import com.example.NotesApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // READ -------------------------------------------------------------------------------------
    public List<UserDTO> findAllUsers() {
        // Convierte la lista de usuarios a una lista de UserDTO
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getUsername())) // Mapea a UserDTO
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> findById(Long id) {
        // Convierte el usuario encontrado a UserDTO
        return userRepository.findById(id)
                .map(user -> new UserDTO(user.getId(), user.getUsername())); // Mapea a UserDTO
    }

    public Optional<UserDTO> findByUsername(String username) {
        // Convierte el usuario encontrado a UserDTO
        return userRepository.findByUsername(username)
                .map(user -> new UserDTO(user.getId(), user.getUsername())); // Mapea a UserDTO
    }

    // CREATE -----------------------------------------------------------------------------------
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // UPDATE -----------------------------------------------------------------------------------
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    // DELETE -----------------------------------------------------------------------------------
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}