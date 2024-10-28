package com.example.NotesApp.dto;

public class UserDTO {
    private Long id;
    private String username;

    // Constructor
    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}