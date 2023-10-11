CREATE TABLE THONG_TIN_CHI_TIET
(
    ID                  SERIAL PRIMARY KEY,
    THUONG_HIEU         varchar(100),
    XUAT_XU_THUONG_HIEU varchar(100),
    NOI_SAN_XUAT        varchar(100),
    DO_TUOI_SU_DUNG     int4,
    TRONG_LUONG         varchar(10),
    HUONG_VI            varchar(20),
    MAU_SAC             varchar(20),
    CONG_XUAT           varchar(20),
    BAO_HANH            int4,
    DUNG_TICH           varchar(20),
    KICH_CO             varchar(30),
    CAN_NANG_THICH_HOP  varchar(10),
    MODEL               int4,
    CHAT_LIEU           varchar(20),
    CHAT_LIEU_MAY       varchar(20),
    CHAT_LIEU_LUOI_DAO  varchar(20),
    CHAT_LIEU_COC       varchar(20),
    HEN_GIO             bool DEFAULT FALSE,
    LOAI                varchar(50),
    AM_THANH            bool DEFAULT FALSE,
    PIN                 bool DEFAULT FALSE,
    KICH_THUOC_HOP      varchar(30),
    kICH_THUOC_SAN_PHAM varchar(30),
    GIOI_TINH_SU_DUNG   varchar(5)
);
COMMENT ON COLUMN THONG_TIN_CHI_TIET.ID IS 'Id thông tin sản phẩm, tự tăng';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.THUONG_HIEU IS 'Thương hiệu của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.XUAT_XU_THUONG_HIEU IS 'Xuất xứ của thương hiệu';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.NOI_SAN_XUAT IS 'Nơi sản xuất';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.DO_TUOI_SU_DUNG IS 'Độ tuổi sử dụng';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.TRONG_LUONG IS 'Trọng lượng';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.HUONG_VI IS 'Hương vị';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.MAU_SAC IS 'Màu sắc';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.CHAT_LIEU IS 'Chất liệu của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.CONG_XUAT IS 'Công xuất của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.BAO_HANH IS 'Bảo hành của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.DUNG_TICH IS 'Dung tích của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.KICH_CO IS 'Kích cỡ của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.CAN_NANG_THICH_HOP IS 'Cân nặng thích hợp sử dụng';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.MODEL IS 'Model của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.CHAT_LIEU IS 'Chất liệu của sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.CHAT_LIEU_MAY IS 'Chất liệu máy';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.CHAT_LIEU_LUOI_DAO IS 'Chất liệu lưỡi dao';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.CHAT_LIEU_COC IS 'Chất liệu cốc';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.HEN_GIO IS 'Có hẹn giờ hay không';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.LOAI IS 'Loại sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.AM_THANH IS 'Có âm thanh hay không';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.PIN IS 'Có pin hay không';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.KICH_THUOC_HOP IS 'Kích thước hộp';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.kICH_THUOC_SAN_PHAM IS 'Kích thước sản phẩm';
COMMENT ON COLUMN THONG_TIN_CHI_TIET.GIOI_TINH_SU_DUNG IS 'Giới tính sử dụng';