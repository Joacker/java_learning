package com.joaquin.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
//import org.springframework.web.bind.annotation.RequestMethod;
import com.joaquin.springboot.webapp.springboot_web.models.User;
import com.joaquin.springboot.webapp.springboot_web.models.dto.UserDto;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class UserRestController {

    //@RequestMapping(path="/details", method=RequestMethod.GET)
    @GetMapping("/details")
    public UserDto details() {
        UserDto userDto = new UserDto();
        User user = new User("Joaquin", "Fernandez");
        
        //userDto.setUser(user);
        //userDto.setUser(user.getLastname());
        //userDto.setLastname(user.getLastname());
        //userDto.setName(user.getName().concat(" ").concat(user.getLastname()));
        userDto.setUser(user);
        userDto.setTitle("User Details");
        
        return userDto;
    }

    public List<User> list() {
        User user = new User("Joaquin", "Fernandez");
        User user2 = new User("Pepe", "Doe");
        User user3 = new User("Jhon", "Doe");

        List<User> users = new ArrayList<>();
        
        users.add(user);
        users.add(user2);
        users.add(user3);
        
        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> details2() {
        User user = new User("Joaquin", "Fernandez");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "User Details");      
        body.put("name", "Joaquin");
        body.put("lastname", "Fernandez");
        body.put("user", user);
        return body;
    }

}
