package com.example.notes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "note_id", nullable = false)
    private Long noteId;
    @Column(name = "note_title", length = 128, nullable = false)
    private String noteTitle;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createdDate;
    public Note() {}
}
