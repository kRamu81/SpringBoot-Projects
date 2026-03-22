package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NoteService – the business-logic layer.
 *
 * Sits between the controller and the repository.
 * All controller methods delegate here, keeping the controller thin.
 */
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    /** Spring injects the repository via the constructor. */
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /** Create and persist a new note. */
    public Note createNote(String title, String content) {
        return noteRepository.save(new Note(null, title, content));
    }

    /** Retrieve every stored note. */
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /** Update an existing note; returns null when the ID is not found. */
    public Note updateNote(Long id, String title, String content) {
        return noteRepository.update(id, title, content);
    }

    /** Delete a note; returns true on success. */
    public boolean deleteNote(Long id) {
        return noteRepository.deleteById(id);
    }
}
