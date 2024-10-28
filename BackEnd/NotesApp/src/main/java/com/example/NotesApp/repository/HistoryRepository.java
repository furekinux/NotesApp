package com.example.NotesApp.repository;

import com.example.NotesApp.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Long> {
}
