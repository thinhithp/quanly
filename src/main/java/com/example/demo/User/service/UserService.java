package com.example.demo.User.service;

import com.example.demo.User.dto.requests.UserCreateDto;
import com.example.demo.User.dto.requests.UserUpdateDto;

import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 9:29 AM
 */
public interface UserService {
    void insertUser(UserCreateDto dto);

    void updateUser(UUID id, UserUpdateDto dto);

    Boolean updatePass(UUID id, String oldpass, String pass);

}
