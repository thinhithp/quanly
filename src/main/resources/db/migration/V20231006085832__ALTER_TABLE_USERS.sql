ALTER TABLE users
ADD COLUMN SO_DIEN_THOAI varchar(50);

COMMENT ON COLUMN users.SO_DIEN_THOAI IS 'Id của User';