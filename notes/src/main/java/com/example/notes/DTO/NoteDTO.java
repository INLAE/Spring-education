package com.example.notes.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteDTO {
    @NotEmpty
    private Long noteId;
    @NotEmpty
    private String noteTitle;
    @NotEmpty
    private String noteDescription;
    @NotEmpty
    private String description;
    @NotEmpty
    private LocalDateTime createdDate;
}
