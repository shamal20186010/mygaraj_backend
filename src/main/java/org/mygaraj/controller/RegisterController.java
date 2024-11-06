package org.mygaraj.controller;

import lombok.RequiredArgsConstructor;
import org.mygaraj.dto.User;
import org.mygaraj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin
public class RegisterController {

    @Autowired
    final RegisterService registerService;

    @PostMapping("/addUser")
    public void registerUser(@RequestBody User user) {
        registerService.registerUser(user);
    }

}
