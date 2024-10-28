package com.example.NotesApp.service;

import com.example.NotesApp.model.User;
import com.example.NotesApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // CREATE -----------------------------------------------------------------------------------
    public User saveUser(User user){
        return userRepository.save(user);
    }


    // READ -------------------------------------------------------------------------------------
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


    // UPDATE -----------------------------------------------------------------------------------
    public User updateUser(Long id, User user){
        User user1 = userRepository.findById(id).orElseThrow();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return userRepository.save(user1);
    }
    public User updateUser(String username, User user){
        User user1 = userRepository.findByUsername(username).orElseThrow();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return userRepository.save(user1);
    }


    // DELETE -----------------------------------------------------------------------------------
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public void deleteUser(String username){
        userRepository.deleteByUsername(username);
    }
}
