package com.example.NotesApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 35,unique = true)
    private String username;

    @Column(name = "password", nullable = false,length = 255)
    private String password;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<Note> noteList = new ArrayList<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Note> getNoteList(){
        return noteList;
    }

    public void addToHistoryList(Note note){
        noteList.add(note);
        note.setUser(this);
    }
}