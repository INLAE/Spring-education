package com.example.notes.service;

import com.example.notes.DTO.NoteDTO;
import com.example.notes.Exceptions.NoteNotFoundException;
import com.example.notes.entity.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> showAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
    }

    public Note editNote(Long id, NoteDTO noteDTO) {
        Note note = getNoteById(id);
        note.setNoteTitle(noteDTO.getNoteTitle());
        note.setDescription(noteDTO.getDescription());
        note.setCreatedDate(noteDTO.getCreatedDate());
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}

