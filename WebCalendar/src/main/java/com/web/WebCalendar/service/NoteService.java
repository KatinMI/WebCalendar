package com.web.WebCalendar.service;

import com.web.WebCalendar.model.Note;
import com.web.WebCalendar.model.User;

import java.util.Date;
import java.util.List;

public interface NoteService {
    void create(Note note);
    List<Note> getAllNote();
    Note getNote(Long id);
    List<Note> getNoteByDate(Date date);
    boolean update(Note note, Long id);
    boolean delete(Long id);
}
