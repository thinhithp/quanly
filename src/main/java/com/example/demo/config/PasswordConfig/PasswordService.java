package com.example.demo.config.PasswordConfig;

import com.example.demo.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PasswordService {

    @Autowired
    private UserRepository repository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public void updateAndStorePassword(UUID id, String newPass) {
        // Ma hoa mat khau moi
        String newPassHard = encoder.encode(newPass);
        repository.updatePassWord(id, newPassHard);
    }
}
