package com.joaquin.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.joaquin.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Joaquin", "Fernandez");
        model.addAttribute("title", "User Details");
        model.addAttribute("name", "Joaquin");
        model.addAttribute("lastname", "Fernandez");
        model.addAttribute("currentDate", new java.util.Date());
        model.addAttribute("user", user);
        //model.addAttribute("currentDate", new java.util.Date());

        return "details";
    }

}
