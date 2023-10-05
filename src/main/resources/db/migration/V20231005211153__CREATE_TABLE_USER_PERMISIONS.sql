CREATE TABLE User_Permissions
(
    user_id       UUID REFERENCES Users (user_id),
    permission_id UUID REFERENCES Permission (permission_id),
    PRIMARY KEY (user_id, permission_id)
);