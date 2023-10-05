CREATE TABLE PERMISSION
(
    permission_id uuid PRIMARY KEY,
    name          varchar(50)
);
COMMENT ON COLUMN PERMISSION.permission_id IS 'Id quyền';
COMMENT ON COLUMN PERMISSION.name IS 'Tên quyền';
