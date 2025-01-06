package com.trainWise.app.controller;

import com.trainWise.app.dto.UserDto;
import com.trainWise.app.model.User;
import com.trainWise.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registUser(@RequestBody UserDto user, @RequestParam String userType){
        User newUser = userService.registerUser(user, userType);
        return ResponseEntity.ok(newUser);
    }
}
