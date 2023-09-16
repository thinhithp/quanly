CREATE TABLE KHACH_THUE
(
    ID                  SERIAL PRIMARY KEY,
    MA_KHACH_THUE      VARCHAR,
    HO                 VARCHAR(30),
    TEN                VARCHAR(20),
    SO_DIEN_THOAI      VARCHAR(20),
    EMAIL              VARCHAR(20),
    DIA_CHI_THUONG_TRU VARCHAR(500),
    DIA_CHI_TAM_CHU    VARCHAR(500),
    NGAY_BAT_DAU_THUE  TIMESTAMP,
    NGAY_KET_THUC_THUE TIMESTAMP,
    MA_PHONG           VARCHAR,
    CMND               VARCHAR(20),
    NGAY_SINH          DATE,
    GIOI_TINH          VARCHAR(10),
    HINH_ANH           VARCHAR,
    NGUOI_TAO          VARCHAR(4000),
    NGAY_TAO           TIMESTAMP,
    NGUOI_SUA          VARCHAR(4000),
    NGAY_SUA           TIMESTAMP,
    IS_DELETE          SMALLINT

);