package com.example.NotesApp.dto;

public class NoteDTO {
    private Long id;
    private String title;
    private String content;
    private Long id_user; // Agregar el ID del usuario

    public NoteDTO(Long id, String title, String content, Long id_user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.id_user = id_user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return id_user;
    }
}
