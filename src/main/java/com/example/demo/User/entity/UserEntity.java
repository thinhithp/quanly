package com.example.demo.User.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 8:08 AM
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "role")
    private Integer role;

    @Column(name = "created_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time")
    private Date createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

//    @PrePersist
//    public void generateUserId() {
//        this.userId = UUID.randomUUID();
//    }

//    public void setRole(String value){
//        this.role = Enum.UserRole.ofOdinal(value);
//    }

}
