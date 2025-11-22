package com.sixth.program.controller;

import com.sixth.program.model.User;
import com.sixth.program.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // for local frontend calls
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Registration endpoint
    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestParam String email,
                                           @RequestParam String password) {
        if (userService.getByEmail(email) != null) {
            return ResponseEntity.status(409).body("fail: email exists");
        }

        User user = new User();
        user.setEmail(email);
        // hash the password before saving
        user.setPassword(passwordEncoder.encode(password));
        userService.save(user);
        return ResponseEntity.ok("success");
    }

    // Login endpoint
    @PostMapping("/doLogin")
    public ResponseEntity<String> doLogin(@RequestParam String email,
                                          @RequestParam String password) {
        User user = userService.getByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(401).body("fail");
        }
    }
}

