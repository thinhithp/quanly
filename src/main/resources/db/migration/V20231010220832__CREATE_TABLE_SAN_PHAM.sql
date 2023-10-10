CREATE TABLE SAN_PHAM(
    ID BIGINT primary key,
    MA_SAN_PHAM varchar(20) UNIQUE NOT NULL,
    MO_TA_CHI_TIET varchar(4000),
    MO_TA_NHANH varchar(2000),
    TRANG_THAI int4,
    NGUOI_CN varchar(20),
    NGAY_CN timestamp,
    NGUOI_NM varchar(20),
    NGAY_NM timestamp
);
COMMENT ON COLUMN SAN_PHAM.ID IS 'id bảng sản phẩm tự tăng';
COMMENT ON COLUMN SAN_PHAM.MA_SAN_PHAM IS 'Mã sản phẩm';
COMMENT ON COLUMN SAN_PHAM.MO_TA_CHI_TIET IS 'Mô tả chi tiết';
COMMENT ON COLUMN SAN_PHAM.MO_TA_NHANH IS 'Mô tả nhanh';
COMMENT ON COLUMN SAN_PHAM.TRANG_THAI IS 'Trạng thái sản phẩm';