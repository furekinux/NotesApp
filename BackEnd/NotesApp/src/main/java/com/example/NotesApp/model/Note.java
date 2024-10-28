package com.example.NotesApp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_history", nullable = false)
    private History history;

    @Column(name = "title", nullable = false,length = 60)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "creationDate")
    private Date creationDate;

    public Note(History history, String title, String content) {
        this.history = history;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
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

    public Date getCreationDate() {
        return creationDate;
    }

}
