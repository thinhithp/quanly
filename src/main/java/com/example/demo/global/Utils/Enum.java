package com.example.demo.global.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author: THINHNQ
 * @since : 10/6/2023 8:14 AM
 */

/**
 * Ordinal của enum bắt đầu từ 0
 */
public class Enum {

    private Enum() {
        throw new UnsupportedOperationException();
    }

    @Getter
    @AllArgsConstructor
    public enum UserRole {
        USER("Người dùng"),
        ADMIN("Người quản trị cấp 1"),
        SUPERADMIN("Người quản trị cấp cao");

        private String name;

        public static UserRole of(int ordinal) {
            for (UserRole role : UserRole.values()) {
                if (Objects.equals(role.ordinal(), ordinal)) {
                    return role;
                }
            }
            return null;
        }
    }

}
