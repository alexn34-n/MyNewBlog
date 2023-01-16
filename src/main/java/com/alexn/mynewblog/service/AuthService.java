package com.alexn.mynewblog.service;

import com.alexn.mynewblog.dto.RegisterRequest;
import com.alexn.mynewblog.model.User;
import com.alexn.mynewblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword (registerRequest.getPassword()));

        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
