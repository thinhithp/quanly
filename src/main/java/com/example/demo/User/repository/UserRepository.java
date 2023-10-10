package com.example.demo.User.repository;

import com.example.demo.User.dto.requests.UserCreateDto;
import com.example.demo.User.dto.requests.UserUpdateDto;
import com.example.demo.User.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 9:20 AM
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Transactional
    @Query(value = "INSERT INTO USERS (user_name, email, password, full_name, so_dien_thoai, role, created_by, created_time) " +
            "VALUES (:#{#dto.userName}, :#{#dto.email}, :#{#dto.password}, :#{#dto.fullName}, :#{#dto.soDienThoai}, :#{#dto.role}, 'ADMIN', current_timestamp) RETURNING *",
            nativeQuery = true)
    UserEntity insertUser(UserCreateDto dto);


    @Transactional
    @Modifying
    @Query(value = "update users set " +
            "email = :#{#userUpdateDto.email}, " +
            "full_name = :#{#userUpdateDto.fullName}, " +
            "so_dien_thoai = :#{#userUpdateDto.soDienThoai}, " +
            "update_by = user_name, " +
            "update_time = current_timestamp " +
            "where user_id = :id",
            nativeQuery = true)
    void updateUser(@Param("id") UUID id, @Param("userUpdateDto") UserUpdateDto dto);

    @Modifying
    @Transactional
    @Query(value = "update users set password = :pass, " +
            "update_time = current_timestamp " +
            "where user_id = :id and " +
            "password = :oldPass", nativeQuery = true)
    void updatePassWordUser(@Param("id") UUID id, @Param("oldPass") String oldPass, @Param("pass") String pass);

    @Modifying
    @Transactional
    @Query(value = "update users set password = :pass, " +
            "update_time = current_timestamp " +
            "where user_id = :id " , nativeQuery = true)
    void updatePassWord(@Param("id") UUID id, @Param("pass") String pass);

    @Transactional
    @Query(value = "SELECT password FROM users where user_id = :id", nativeQuery = true)
    String searchPass(@Param("id") UUID id);


    // Check user
    @Transactional
    @Query(value = "SELECT user_name FROM users where user_name = :userName", nativeQuery = true)
    String checkUser(@Param("userName") String userName);

    //Check pass

    @Transactional
    @Query(value = "SELECT password FROM users where user_name = :user", nativeQuery = true)
    String checkPass(@Param("user") String user);

    @Transactional
    @Query(value = "SELECT password FROM users WHERE user_name = :user and password = :password ", nativeQuery = true)
    String checkPassOfUser(@Param("user") String user, @Param("password") String password);


    @Transactional
    @Query(value = "SELECT full_name from users  where lower(user_name) = :userName and lower(password) = :pass", nativeQuery = true)
    String login(@Param("userName") String userName, @Param("pass") String pass);
}