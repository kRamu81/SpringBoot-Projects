package com.example.notes.model;

/**
 * Note – the core data model.
 *
 * Fields
 * ------
 * id      : unique identifier (auto-assigned by the repository)
 * title   : short heading for the note
 * content : the body text of the note
 */
public class Note {

    private Long   id;
    private String title;
    private String content;

    /** Required by Jackson for JSON deserialization. */
    public Note() {}

    public Note(Long id, String title, String content) {
        this.id      = id;
        this.title   = title;
        this.content = content;
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public Long getId()        { return id; }
    public String getTitle()   { return title; }
    public String getContent() { return content; }

    // ── Setters ──────────────────────────────────────────────────────────────

    public void setId(Long id)           { this.id      = id; }
    public void setTitle(String title)   { this.title   = title; }
    public void setContent(String content) { this.content = content; }
}
