package com.example.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.domain.User;
import com.example.hotel.dto.UserDto;
import com.example.hotel.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
     @Autowired
    private UserService userService;

    @GetMapping
    public String userHome() {
        return "user";  // Tên view tương ứng với templates/user.html
    }
   
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }
}


