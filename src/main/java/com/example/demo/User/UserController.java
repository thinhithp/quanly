package com.example.demo.User;

import com.example.demo.User.dto.requests.UserCreateDto;
import com.example.demo.User.dto.requests.UserUpdateDto;
import com.example.demo.User.service.UserService;
import com.example.demo.global.constansts.ApiConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 9:31 AM
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping(ApiConstants.Users.BASE + ApiConstants.CREATE)
    public void insertUser(@RequestBody UserCreateDto dto) {
        this.service.insertUser(dto);
    }

    @PutMapping(ApiConstants.Users.BASE + ApiConstants.UDPATE)
    public void updateUser(@PathVariable UUID id, @RequestBody UserUpdateDto dto) {
        this.service.updateUser(id, dto);
    }

    @PutMapping(ApiConstants.Users.BASE + ApiConstants.CHANGE_PASS)
    public Boolean changePass(@PathVariable UUID id, @RequestParam String oldPass, @RequestParam String newPass) {
        return this.service.updatePass(id, oldPass, newPass);
    }
}
