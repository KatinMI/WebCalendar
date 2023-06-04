package com.web.WebCalendar.util;

import com.web.WebCalendar.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface NoteRepository extends JpaRepository<Note,Long> {
    Note findByDate(Date date);
}
