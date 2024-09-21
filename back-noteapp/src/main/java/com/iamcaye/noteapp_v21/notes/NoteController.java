package com.iamcaye.noteapp_v21.notes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public List<Note> getNotes() {
        return this.noteService.getNotes();
    }

    @GetMapping("/{id}")
    public Note getNote(@PathVariable Integer id) {
        return this.noteService.getNote(id);
    }

    @PostMapping("")
    public Note createNote(@RequestBody Note note) {
        return this.noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Integer id, @RequestBody Note note) {
        return this.noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id) {
      this.noteService.deleteNote(id);
    }
}
