package com.web.WebCalendar.controller;

import com.web.WebCalendar.model.User;
import com.web.WebCalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/WebCalendar")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/Registration")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "RegPage";
    }
@GetMapping("/Enter")
    public String getEntPage(){
        return "EntPage";
}
@PostMapping("/Enter")
public String saveUser(@PathVariable User user){
        userService.create(user);
        return "redirect:/Enter";

}
}
