ALTER TABLE TAG
    ADD COLUMN ITEM_CODE varchar(100);
COMMENT ON COLUMN TAG.ITEM_CODE IS 'Mã';
COMMENT ON COLUMN TAG.TAG_NAME IS 'Tên';
-------------------

ALTER TABLE TAG
    ADD COLUMN GROUP_CODE varchar(100);

---------------------
COMMENT ON COLUMN TAG.GROUP_CODE IS 'Nhóm TAG';
---------------------
ALTER TABLE TAG
    ADD COLUMN PARENT_CODE varchar(100);

