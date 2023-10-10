package com.example.demo.User.service;

import com.example.demo.User.dto.requests.UserCreateDto;
import com.example.demo.User.dto.requests.UserUpdateDto;
import com.example.demo.User.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 9:29 AM
 */
public interface UserService {
    UserEntity insertUser(UserCreateDto dto);

    void updateUser(UUID id, UserUpdateDto dto);

    Boolean updatePass(UUID id, String oldpass, String pass);

    Optional<UserEntity> findById(UUID id);

    Boolean login(String userName, String pass);

    Boolean checklogin(String user, String pass);
}
