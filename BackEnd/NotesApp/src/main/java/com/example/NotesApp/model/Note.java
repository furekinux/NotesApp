package com.example.NotesApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonManagedReference
    private User user;

    @Column(name = "title", nullable = false,length = 60)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
    }

    public Note() {
    }

    public Note(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

}
