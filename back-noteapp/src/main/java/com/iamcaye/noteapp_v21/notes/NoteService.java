package com.iamcaye.noteapp_v21.notes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iamcaye.noteapp_v21.user.UserRepository;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public Note createNote (Note note) {
        if(this.userRepository.findById(note.getUserId()).isEmpty()) {
            throw new IllegalArgumentException("User does not exist");
        }
        return noteRepository.save(note);
    }

    public Note getNote (Integer id) {
        return noteRepository.findById(id).orElseThrow();
    }

    public List<Note> getNotes () {
        return noteRepository.findAll();
    }

    public List<Note> getNotesByUserId (Integer userId) {
        if(this.userRepository.findById(userId).isEmpty()) {
            throw new IllegalArgumentException("User does not exist");
        }
        return noteRepository.findAllByUserId(userId);
    }

    public void deleteNote (Integer id) {
        noteRepository.deleteById(id);
    }

    public Note updateNote (Integer id, Note note) {
        Note existingNote = noteRepository.findById(id).orElseThrow();

        if (!existingNote.getUserId().equals(note.getUserId())) {
            throw new IllegalArgumentException("User ID cannot be changed");
        }

        note.setId(id);
        return noteRepository.save(note);
    }
}