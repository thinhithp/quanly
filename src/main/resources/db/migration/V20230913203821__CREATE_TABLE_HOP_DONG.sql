CREATE TABLE HOP_DONG
(
    ID                    SERIAL PRIMARY KEY,
    ID_KHACH_THUE         INT,
    MA_HOP_DONG           VARCHAR(10),
    NGAY_BAT_DAU          TIMESTAMP,
    NGAY_KET_THUC         TIMESTAMP,
    TIEN_DAT_COC          DECIMAL,
    CHU_KY_THANH_TOAN     VARCHAR(50),
    TINH_TRANG_THANH_TOAN VARCHAR(50),
    NGUOI_TAO             VARCHAR(4000),
    NGAY_TAO              TIMESTAMP,
    NGUOI_SUA             VARCHAR(4000),
    NGAY_SUA              TIMESTAMP,
    IS_DELETE             SMALLINT
);