package com.example.demo.User.service.impl;

import com.example.demo.User.dto.requests.UserCreateDto;
import com.example.demo.User.dto.requests.UserUpdateDto;
import com.example.demo.User.repository.UserRepository;
import com.example.demo.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 9:29 AM
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public void insertUser(UserCreateDto dto) {
        this.repository.insertUser(dto);

    }

    @Override
    public void updateUser(UUID id, UserUpdateDto dto) {
        this.repository.updateUser(id, dto);
    }

    @Override
    public Boolean updatePass(UUID id, String oldPass, String newPass) {
        this.comparePass(id, oldPass);
        this.repository.updatePassWordUser(id, oldPass, newPass);
        return true;
    }

    private boolean comparePass(UUID id, String enteredPass) {
        String storedPassword;
        storedPassword = this.repository.searchPass(id);
        if (storedPassword.equals(enteredPass)) {
            return true;
        }
        throw new RuntimeException("Mật khẩu không chính xác, Xin vui lòng thử lại");


    }


}
