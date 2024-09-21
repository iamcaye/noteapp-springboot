package com.iamcaye.noteapp_v21.notes;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends ListCrudRepository<Note, Integer> { 
    List<Note> findAllByUserId(Integer userId);
}
