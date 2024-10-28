package com.example.NotesApp.service;

import com.example.NotesApp.dto.NoteDTO; // Importa el DTO
import com.example.NotesApp.model.Note;
import com.example.NotesApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    // CREATE -----------------------------------------------------------------------------------
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    // READ -------------------------------------------------------------------------------------
    public Optional<NoteDTO> findById(Long id) {
        return noteRepository.findById(id)
                .map(note -> new NoteDTO(note.getId(), note.getTitle(), note.getContent(), note.getUser().getId()));
    }

    public List<NoteDTO> findAllNotes() {
        return noteRepository.findAll().stream()
                .map(note -> new NoteDTO(note.getId(), note.getTitle(), note.getContent(), note.getUser().getId()))
                .collect(Collectors.toList());
    }

    // UPDATE -----------------------------------------------------------------------------------
    public Note updateNote(Long id, Note note) {
        Note existingNote = noteRepository.findById(id).orElseThrow();
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        return noteRepository.save(existingNote);
    }

    // DELETE -----------------------------------------------------------------------------------
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
