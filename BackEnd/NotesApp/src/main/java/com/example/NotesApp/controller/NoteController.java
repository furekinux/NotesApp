package com.example.NotesApp.controller;

import com.example.NotesApp.dto.NoteDTO; // Importa el DTO
import com.example.NotesApp.model.Note;
import com.example.NotesApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    // CREATE -----------------------------------------------------------------------------------
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    // READ -------------------------------------------------------------------------------------
    @GetMapping
    public List<NoteDTO> getAllNotes() { // Cambia a List<NoteDTO>
        return noteService.findAllNotes();
    }

    @GetMapping("/{id}")
    public Optional<NoteDTO> getNoteById(@PathVariable Long id) { // Cambia a Optional<NoteDTO>
        return noteService.findById(id);
    }

    // UPDATE -----------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }

    // DELETE -----------------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
