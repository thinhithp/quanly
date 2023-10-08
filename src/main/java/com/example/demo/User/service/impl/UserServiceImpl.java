package com.example.demo.User.service.impl;

import com.example.demo.User.dto.requests.UserCreateDto;
import com.example.demo.User.dto.requests.UserUpdateDto;
import com.example.demo.User.entity.UserEntity;
import com.example.demo.User.repository.UserRepository;
import com.example.demo.User.service.UserService;
import com.example.demo.config.PasswordConfig.PasswordEncodeConfig;
import com.example.demo.config.PasswordConfig.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 9:29 AM
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final PasswordEncodeConfig passwordEncodeConfig;

    private final PasswordService passwordService;

    private final BCryptPasswordEncoder encoder;

    @Override
    public UserEntity insertUser(UserCreateDto dto) {
        UserEntity userEntity = this.repository.insertUser(dto);
        this.passwordService.updateAndStorePassword(userEntity.getUserId(), userEntity.getPassword());
        return userEntity;
    }

    @Override
    public void updateUser(UUID id, UserUpdateDto dto) {
        this.repository.updateUser(id, dto);
    }

    @Override
    public Boolean updatePass(UUID id, String oldPass, String newPass) {
        this.comparePass(id, oldPass);
        this.repository.updatePassWord(id, encoder.encode(newPass));
        return true;
    }

    private boolean comparePass(UUID id, String enteredPass) {
        String storedPassword;
        storedPassword = this.repository.searchPass(id);
        if (this.passwordEncodeConfig.bCryptPasswordEncoder().matches(enteredPass, storedPassword)) {
            return true;
        }
        throw new RuntimeException("Mật khẩu không chính xác, Xin vui lòng thử lại");
    }

    public Optional<UserEntity> findById(UUID id) {
        return this.repository.findById(id);
    }

    //TODO:
    @Override
    public Boolean login(String userName, String pass) {
        int count = 0;
        if (this.repository.checkUser(userName).isEmpty()) {
            throw new RuntimeException("Tài khoản không tồn tại");
        }
        while (count >= 3) {
            if (this.repository.login(userName, pass).isEmpty()) {
                throw new RuntimeException("Mật khẩu không chính xác, xin vui lòng thử lại");
            }
        }
        return true;
    }
}
