package com.example.notes.controller;

import com.example.notes.DTO.NoteDTO;
import com.example.notes.entity.Note;
import com.example.notes.facade.NoteFacade;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NoteController {
    // Внедрение зависимости для работы с заметками
    @Autowired
    private NoteService noteService;
    // Внедрение зависимости для преобразования заметок в DTO
    @Autowired
    private NoteFacade noteFacade;

// Обработка GET запроса для получения всех заметок
    @GetMapping("/note")
    public String getAllNotes(Model model) {
        try {
            // Получение списка всех заметок, преобразование их в DTO и добавление в модель
            List<NoteDTO> note = noteService.showAllNotes()
                    .stream()
                    .map(noteFacade::noteToNoteDTO)
                    .collect(Collectors.toList());
            model.addAttribute("note", note);
        } catch (Exception e) {
            // Обработка ошибки при получении списка заметок
            model.addAttribute("message", e.getMessage());
        }
        // Возвращение имени представления для отображения списка заметок
        return "note";
    }

    // Обработка GET запроса для создания новой заметки
    @GetMapping("/note/new")
    public String createNote(Model model) {
        // Добавление новой заметки в модель
        model.addAttribute("note", new Note());
        // Возвращение имени представления для отображения формы создания новой заметки
        return "new";
    }

    @PostMapping("/note/new")
    public String createNote(@ModelAttribute Note note) {
        noteService.createNote(note);
        // Перенаправление на страницу со списком заметок
        return "redirect:/note";
    }

    @GetMapping("/note/edit/{id}")
    public String editNote(@PathVariable Long id, Model model) {
        try {
            // Получение заметки по идентификатору и добавление ее в модель
            Note note = noteService.getNoteById(id);
            model.addAttribute("note", note);
        } catch (Exception e) {
            // Обработка ошибки при получении заметки
            model.addAttribute("message", e.getMessage());
        }
        // Возвращение имени представления для отображения формы редактирования заметки
        return "edit";
    }


    @PostMapping("/note/edit/{id}")
    public String editNote(@PathVariable Long id, @ModelAttribute NoteDTO noteDTO, Model model) {
        try {
            Note existingNote = noteService.editNote(id, noteDTO);
            noteFacade.noteToNoteDTO(existingNote);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "redirect:/note";
    }

    @GetMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable Long id, Model model) {
        try {
            noteService.deleteNoteById(id);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "redirect:/note";
    }
}
