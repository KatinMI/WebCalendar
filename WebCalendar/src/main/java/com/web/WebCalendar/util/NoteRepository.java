package com.web.WebCalendar.util;

import com.web.WebCalendar.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByDate(Date date);
}
