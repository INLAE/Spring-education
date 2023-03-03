package com.example.notes.facade;

import com.example.notes.DTO.NoteDTO;
import com.example.notes.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteFacade {
    public NoteDTO noteToNoteDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setNoteId(note.getNoteId());
        noteDTO.setNoteTitle(note.getNoteTitle());
        noteDTO.setDescription(note.getDescription());
        noteDTO.setCreatedDate(note.getCreatedDate());
        return noteDTO;
    }
}
