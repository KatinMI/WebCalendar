package com.web.WebCalendar.controller;

import com.web.WebCalendar.model.User;
import com.web.WebCalendar.service.UserService;
import com.web.WebCalendar.util.Cripto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/WebCalendar")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Cripto cripto;
    @GetMapping("/Registration")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "RegPage";
    }
@GetMapping("/Entry")
    public String getEntPage(Model model){
    User user = new User();
    model.addAttribute("user",user);
        return "EntPage";
}
    @PostMapping("/Entry")
    public String getEnter(@ModelAttribute("user") User user, Model model,  RedirectAttributes redirectAttributes){
        User mainUser = userService.getUserByLogin(user.getLogin());
        if(mainUser != null && cripto.getPassHash(user.getPassword()).equals(mainUser.getPassword())){
            redirectAttributes.addFlashAttribute("user", mainUser);
            return "redirect:/WebCalendar/Calendar";
        } else return "redirect:/WebCalendar/Entry";
    }
@PostMapping("/Registration")
public String saveUser(@ModelAttribute User user){
        String pass = user.getPassword();
        user.setPassword(cripto.getPassHash(pass));
        userService.create(user);
        return "redirect:/WebCalendar/Entry";

    }

}
