package com.sample.springgraphql.mysql.dataloader;

import com.sample.springgraphql.mysql.model.User;
import com.sample.springgraphql.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        loadUsers();
    }

    private void loadUsers() {
        if (userRepository.findAll().isEmpty()) {
            User sampleUser = new User();
            sampleUser.setEmail("admin");
            sampleUser.setPassword(passwordEncoder.encode("1234"));
            sampleUser.setRole("ADMIN");
            userRepository.save(sampleUser);
        }
    }
}