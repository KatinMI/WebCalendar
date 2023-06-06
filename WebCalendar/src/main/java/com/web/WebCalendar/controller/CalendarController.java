package com.web.WebCalendar.controller;

import com.web.WebCalendar.model.CalendarUnit;
import com.web.WebCalendar.model.Note;
import com.web.WebCalendar.model.User;
import com.web.WebCalendar.service.NoteService;
import com.web.WebCalendar.service.UserService;
import com.web.WebCalendar.util.UserRepository;
import com.web.WebCalendar.util.WebCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/WebCalendar")
@SessionAttributes("usersCalendar")
public class CalendarController {
    @Autowired
private UserService userService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private WebCalendar webCalendar;
    private User sessionUser;
    private Note sessionNote = new Note();
    @GetMapping("/Calendar")
    public String getData(@ModelAttribute("user")  User user, Model model){
        sessionUser = user;
        model.addAttribute("usersCalendar", user);
    return "redirect:/WebCalendar/Selection";
}
@GetMapping("/Selection")
    public String selectCalendar(Model model){
        User user = new User();
        model.addAttribute("userCalendar",user);
        CalendarUnit calendarUnit = new CalendarUnit();
        model.addAttribute("calendarUnit", calendarUnit);
        return "SelectTime";
}
@PostMapping("/Selection")
    public String chooseMonth(@ModelAttribute CalendarUnit calendarUnit){
        webCalendar.setCalendar(new GregorianCalendar(calendarUnit.getYears(), calendarUnit.getMonths(), calendarUnit.getDay()));
        webCalendar.GenerateMonths(webCalendar.getCalendar());
   return "redirect:/WebCalendar/Month";
}
@GetMapping("/Month")
    public String getCalendar(Model model){
        model.addAttribute("calendar", webCalendar);
        return "Calendar";
}
@PostMapping("/Month")
    public String setDay(@ModelAttribute WebCalendar webCalendar) {
    sessionNote.setDate(webCalendar.getDateOfTime(webCalendar.getTime()));
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(sessionNote.getDate());
    String id = calendar.get(Calendar.DAY_OF_MONTH) + "." + (calendar.get(Calendar.MONTH)+1)  +"." + calendar.get(Calendar.YEAR);
        return "redirect:/WebCalendar/Day/" + id;
}
@GetMapping("/Day/{day}")
    public String getDay(@PathVariable("day") String data, Model model){
        List<Note> notes = noteService.getNoteByDate(sessionNote.getDate());
        webCalendar.setDate(sessionNote.getDate());
        model.addAttribute("noteOne", sessionNote);
        model.addAttribute("notes", notes);
        model.addAttribute("calendar", webCalendar);
        return "Day";
}
    @GetMapping("/Day/new")
    public String newNote(Model model){
        Note note = new Note();
        model.addAttribute("note1", note);
        model.addAttribute("calendar", webCalendar);
        return "NewDay";
    }
    @PostMapping("/Day/{day}")
    public String saveNote(@PathVariable String day,@ModelAttribute Note note){
        note.setUserId(sessionUser.getId());
        note.setDate(sessionNote.getDate());
        noteService.create(note);
    return "redirect:/WebCalendar/Day/" + day;
    }
}

