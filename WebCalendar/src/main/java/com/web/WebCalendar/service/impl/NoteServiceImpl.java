package com.web.WebCalendar.service.impl;

import com.web.WebCalendar.model.Note;
import com.web.WebCalendar.service.NoteService;
import com.web.WebCalendar.util.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public void create(Note note) {
    noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNote(Long id) {
        return noteRepository.getReferenceById(id);
    }

    @Override
    public Note getNoteByDate(Date date) {
        return noteRepository.findByDate(date);
    }

    @Override
    public boolean update(Note note, Long id) {
        if( noteRepository.existsById(id)){
            note.setId(id);
            noteRepository.save(note);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(noteRepository.existsById(id)){
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
