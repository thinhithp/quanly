package com.example.demo.User;

import com.example.demo.User.dto.requests.UserCreateDto;
import com.example.demo.User.dto.requests.UserUpdateDto;
import com.example.demo.User.entity.UserEntity;
import com.example.demo.User.service.UserService;
import com.example.demo.global.constansts.ApiConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 9:31 AM
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService service;

    @PostMapping(ApiConstants.Users.BASE + ApiConstants.CREATE)
    public UserEntity insertUser(@RequestBody UserCreateDto dto) {
        return this.service.insertUser(dto);
    }

    @PutMapping(ApiConstants.Users.BASE + ApiConstants.UDPATE)
    public void updateUser(@PathVariable UUID id, @RequestBody UserUpdateDto dto) {
        this.service.updateUser(id, dto);
    }

    @PutMapping(ApiConstants.Users.BASE + ApiConstants.CHANGE_PASS)
    public Boolean changePass(@PathVariable UUID id, @RequestParam String oldPass, @RequestParam String newPass) {
        return this.service.updatePass(id, oldPass, newPass);
    }

    @GetMapping(ApiConstants.Users.BASE + ApiConstants.DETAIL)
    public Optional<UserEntity> get(@PathVariable UUID id) {
        return this.service.findById(id);
    }

    @GetMapping(ApiConstants.Users.BASE + ApiConstants.LOGIN)
    public Boolean login(@RequestParam String userName, String pass){
        return this.service.login(userName, pass);
    }

}
