ALTER TABLE users
    ADD CONSTRAINT unique_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT unique_user_name UNIQUE (user_name);