package com.example.notes.repository;

import com.example.notes.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * NoteRepository – acts as an in-memory "database".
 *
 * Data is stored in a plain ArrayList; it resets every time the
 * application restarts.  This is intentional for this project.
 */
@Repository
public class NoteRepository {

    private final List<Note> noteList  = new ArrayList<>();
    private       long       idCounter = 1;

    /**
     * Persist a new note.
     * Assigns a unique ID before saving and returns the saved entity.
     */
    public Note save(Note note) {
        note.setId(idCounter++);
        noteList.add(note);
        return note;
    }

    /**
     * Return a defensive copy of all stored notes so callers
     * cannot accidentally mutate the internal list.
     */
    public List<Note> findAll() {
        return new ArrayList<>(noteList);
    }

    /**
     * Update an existing note's title and content.
     *
     * @return the updated Note, or {@code null} if not found.
     */
    public Note update(Long id, String title, String content) {
        for (Note note : noteList) {
            if (note.getId().equals(id)) {
                note.setTitle(title);
                note.setContent(content);
                return note;
            }
        }
        return null;
    }

    /**
     * Remove a note by ID.
     *
     * @return {@code true} if a note was removed, {@code false} otherwise.
     */
    public boolean deleteById(Long id) {
        return noteList.removeIf(note -> note.getId().equals(id));
    }
}
