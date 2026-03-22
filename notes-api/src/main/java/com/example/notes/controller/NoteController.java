package com.example.notes.controller;

import com.example.notes.model.Note;
import com.example.notes.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * NoteController – exposes the REST endpoints.
 *
 * Base path : /api/notes
 *
 * POST   /api/notes        – create a note
 * GET    /api/notes        – list all notes
 * PUT    /api/notes/{id}   – update a note
 * DELETE /api/notes/{id}   – delete a note
 */
@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")   // allows the frontend (any origin) to call this API
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // ── POST /api/notes ───────────────────────────────────────────────────────

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note created = noteService.createNote(note.getTitle(), note.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // ── GET /api/notes ────────────────────────────────────────────────────────

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    // ── PUT /api/notes/{id} ───────────────────────────────────────────────────

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id,
                                           @RequestBody  Note note) {
        Note updated = noteService.updateNote(id, note.getTitle(), note.getContent());
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // ── DELETE /api/notes/{id} ────────────────────────────────────────────────

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        boolean deleted = noteService.deleteNote(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Note with id " + id + " not found.");
        }
        return ResponseEntity.ok("Note deleted successfully.");
    }
}
