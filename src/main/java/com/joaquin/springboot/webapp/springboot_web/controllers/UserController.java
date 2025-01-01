package com.joaquin.springboot.webapp.springboot_web.controllers;

import java.util.List;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import com.joaquin.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Joaquin", "Fernandez");
        user.setEmail("joaquin@correo.com");
        model.addAttribute("title", "User Details");
        model.addAttribute("name", "Joaquin");
        model.addAttribute("lastname", "Fernandez");
        model.addAttribute("currentDate", new java.util.Date());
        model.addAttribute("user", user);
        //model.addAttribute("currentDate", new java.util.Date());

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
       List<User> users = new ArrayList<>(); 

       model.addAttribute("users", users);
       model.addAttribute("title", "Listado de usuarios");
        return "list";
    }
}
