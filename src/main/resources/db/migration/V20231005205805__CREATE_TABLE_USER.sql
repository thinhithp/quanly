CREATE TABLE Users
(
    user_id      UUID PRIMARY KEY,
    user_name    VARCHAR(255),
    password     VARCHAR(255),
    email        VARCHAR(255),
    full_name    VARCHAR(255),
    role         NUMERIC(1, 0),
    created_by   varchar(4000),
    created_time timestamp,
    update_by    varchar(4000),
    update_time  timestamp
);
COMMENT ON COLUMN Users.user_id IS 'Id của User';
COMMENT ON COLUMN Users.user_name IS 'Tên đăng nhập';
COMMENT ON COLUMN Users.password IS 'Mật khẩu';
COMMENT ON COLUMN Users.email IS 'Địa chỉ hòm thư';
COMMENT ON COLUMN Users.full_name IS 'Tên đầy đủ';
COMMENT ON COLUMN Users.role IS 'Quyền người dùng';
COMMENT ON COLUMN Users.created_by IS 'Người tạo';
COMMENT ON COLUMN Users.created_time IS 'Ngày tạo';
COMMENT ON COLUMN Users.update_by IS 'Người cập nhật';
COMMENT ON COLUMN Users.update_time IS 'Ngày cập nhật';
