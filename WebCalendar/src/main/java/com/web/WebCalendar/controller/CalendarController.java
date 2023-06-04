package com.web.WebCalendar.controller;

import com.web.WebCalendar.model.CalendarUnit;
import com.web.WebCalendar.model.User;
import com.web.WebCalendar.service.NoteService;
import com.web.WebCalendar.service.UserService;
import com.web.WebCalendar.util.UserRepository;
import com.web.WebCalendar.util.WebCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

    @GetMapping("/Calendar")
    public String getData(@ModelAttribute("user")  User user, Model model){
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

}
