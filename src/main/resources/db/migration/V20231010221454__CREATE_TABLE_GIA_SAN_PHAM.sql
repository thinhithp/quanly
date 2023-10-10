CREATE TABLE GIA(
    ID SERIAL PRIMARY KEY,
    ID_SAN_PHAM BIGINT,
    GIA_SALE int8,
    GIA_NIEM_YET int8,
    TRANG_THAI int4,
    NGUOI_CN varchar(20),
    NGAY_CN timestamp,
    NGUOI_NM varchar(20),
    NGAY_NM timestamp,
    ID_EVENT int8
);
COMMENT ON COLUMN GIA.ID IS 'id bảng sản phẩm tự tăng';
COMMENT ON COLUMN GIA.GIA_SALE IS 'Giá điều chỉnh';
COMMENT ON COLUMN GIA.GIA_NIEM_YET IS 'Giá niêm yết';
COMMENT ON COLUMN GIA.TRANG_THAI IS 'Trạng thái giá';
COMMENT ON COLUMN GIA.ID_EVENT IS 'Id của Event';