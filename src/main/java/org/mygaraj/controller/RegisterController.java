package org.mygaraj.controller;

import lombok.RequiredArgsConstructor;
import org.mygaraj.dto.User;
import org.mygaraj.exceptions.ResponseMessage;
import org.mygaraj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin
public class RegisterController {

    @Autowired
    final RegisterService registerService;

    @PostMapping("/addUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            // Register the user
            registerService.registerUser(user);

            // Respond with success message
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(null, "User successfully registered"));
        } catch (Exception e) {
            // Handle any errors, such as user already exists
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(), null));
        }
    }

    @GetMapping("/login/{username}")
    public ResponseEntity<User> isLogin(@PathVariable String username) {
        try {
            User user = registerService.isLogin(username);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
