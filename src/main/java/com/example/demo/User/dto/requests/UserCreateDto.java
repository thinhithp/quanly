package com.example.demo.User.dto.requests;

import com.example.demo.global.Utils.Enum;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    @Comment("Tên đăng nhập")
    private String userName;

    @Comment("Email")
    private String email;

    @Comment("Mật khẩu")
    private String password;

    @Comment("Tên đầy đủ")
    private String fullName;

    @Comment("Số điện thoại")
    private String soDienThoai;

    @Comment("Quyền người dùng")
    private Integer role;



}
