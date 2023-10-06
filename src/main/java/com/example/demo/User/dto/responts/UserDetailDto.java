package com.example.demo.User.dto.responts;

import com.example.demo.global.Utils.Enum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 8:20 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDetailDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Comment("Tên đăng nhập")
    private String userName;

    @Comment("Địa chỉ hòm thư")
    private String email;

    @Comment("Tên đầy đủ")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Comment("Quyền người dùng")
    private Integer role;

    @Temporal(TemporalType.TIMESTAMP)
    @Comment("Ngày tạo")
    private Date createTime;

    @Comment("Số điện thoại")
    private String soDienThoai;




}
