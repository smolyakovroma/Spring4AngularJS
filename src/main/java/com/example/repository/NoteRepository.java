package com.example.repository;

import com.example.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Collection<Note> findByUserUsername(String username);
}
