package com.sample.springgraphql.mysql.controller;

import com.sample.springgraphql.mysql.model.User;
import com.sample.springgraphql.mysql.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Void> register(@RequestBody User user) throws LoginException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new LoginException("This email already taken");
        }

        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public void delete() {
        userRepository.deleteAll();
    }

}