package com.example.demo.User.mapper;

import com.example.demo.User.dto.responts.UserDetailDto;
import com.example.demo.User.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserMapper {

    private static UserMapper instance;

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapper();
        }
        return instance;
    }

//    public UserDetailDto toDto(UserEntity entity) {
//        return UserDetailDto.builder()
//                .userName(entity.getUserName())
//                .email(entity.getEmail())
//                .fullName(entity.getFullName())
//                .role(entity.getRole())
//                .createTime(entity.getCreateTime())
//                .soDienThoai(entity.getSoDienThoai())
//                .build();
//    }

//    public UserEntity createEntity(UserCreateDto dto) {
//        return UserEntity.builder()
//                .userName(dto.getUserName())
//                .password(dto.getPassword())
//                .fullName(dto.getFullName())
//                .email(dto.getEmail())
//                .role(dto.getRole())
//                .soDienThoai(dto.getSoDienThoai())
//                .build();
//    }
}
