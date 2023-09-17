package com.example.demo.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

public class Common {

    /**
     * @UnsupportedOperationException là một
     * loại ngoại lệ (exception) không kiểm tra
     * (unchecked) trong Java, thường được sử dụng để chỉ ra rằng
     * một phương thức cụ thể chưa được hỗ trợ hoặc không được thực hiện.
     */
    private Common() {
        throw new UnsupportedOperationException();
    }

    @Getter
    @AllArgsConstructor
    public enum TinhTrang {
        TRONG( "Phòng trống"),
        DA_THUE( "Đã thuê"),
        DA_DAT_COC("Đã đặt cọc"),
        DANG_SUA_CHUA( "Đang sửa chữa"),
        CON_PHONG_TRONG("Còn phòng trống");

        private final String name;


        public static TinhTrang of(int ordinal) {
            for (TinhTrang tinhTrang : TinhTrang.values()) {
                if (Objects.equals(tinhTrang.ordinal(), ordinal)) {
                    return tinhTrang;
                }
            }
            return CON_PHONG_TRONG;
        }

        public static TinhTrang fromValue(String value) {
            for (TinhTrang tinhTrang : TinhTrang.values()) {
                if (tinhTrang.name.equals(value)) {
                    return tinhTrang;
                }
            }
            return CON_PHONG_TRONG;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum Loai {
        DON("D", "Đơn"),
        DOI("D2", "Đôi"),
        LON_HON_2("LH2", "Lớn hơn 2 phòng"),
        O_GHEP("G", "Phòng ở ghép người"),

        NHA_NGUYEN_CAN("NC", "Nhà nguyên căn"),
        CHUNG_CU_MINI("CCMN", "Chung cư mini");


        private final String value;
        private final String name;

        public static Loai of(int ordinal) {
            for (Loai loai : Loai.values()) {
                if (Objects.equals(loai.ordinal(), ordinal)) {
                    return loai;
                }
            }
            return CHUNG_CU_MINI;
        }

        public static Loai fromValue(String value) {
            for (Loai loai : Loai.values()) {
                if (loai.value.equals(value)) {
                    return loai;
                }
            }
            return CHUNG_CU_MINI;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum GioiTinhEnum {
        NAM("M", "Nam"),
        NU("F", "Nữ"),
        UNKNOWN("U", "Chưa xác định");

        private final String value;
        private final String name;

        public static GioiTinhEnum of(int ordinal) {
            for (GioiTinhEnum gioiTinhEnum : GioiTinhEnum.values()) {
                if (Objects.equals(gioiTinhEnum.ordinal(), ordinal)) {
                    return gioiTinhEnum;
                }
            }
            return null;
        }

        public static GioiTinhEnum fromValue(String value) {
            for (GioiTinhEnum gioiTinh : GioiTinhEnum.values()) {
                if (gioiTinh.value.equals(value)) {
                    return gioiTinh;
                }
            }
            return UNKNOWN;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum ChuKyThanhToanEnum {
        HANG_THANG("HT", "Hàng tháng"),
        HANG_QUY("HQ", "Hàng quý"),
        TREN_6_THANG("6T", "Trên 6 tháng"),
        NAM("N", "Cả năm");

        private final String value;
        private final String name;

        public static ChuKyThanhToanEnum of(int ordinal) {
            for (ChuKyThanhToanEnum chuKyThanhToanEnum : ChuKyThanhToanEnum.values()) {
                if (Objects.equals(chuKyThanhToanEnum.ordinal(), ordinal)) {
                    return chuKyThanhToanEnum;
                }
            }
            return HANG_THANG;
        }

        public static ChuKyThanhToanEnum fromValue(String value) {
            for (ChuKyThanhToanEnum chuKyThanhToanEnum : ChuKyThanhToanEnum.values()) {
                if (chuKyThanhToanEnum.value.equals(value)) {
                    return chuKyThanhToanEnum;
                }
            }
            return HANG_THANG;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum TinhTrangThanhToanEnum {
        DA_THANH_TOAN("DTT", "Đã thanh toán"),
        CHUA_THANH_TOAN("CTT", "Chưa thanh toán"),
        QUA_HAN("QH", "Quá hạn");

        private final String value;
        private final String name;

        public static TinhTrangThanhToanEnum of(int ordinal) {
            for (TinhTrangThanhToanEnum tinhTrangThanhToanEnum : TinhTrangThanhToanEnum.values()) {
                if (Objects.equals(tinhTrangThanhToanEnum.ordinal(), ordinal)) {
                    return tinhTrangThanhToanEnum;
                }
            }
            return CHUA_THANH_TOAN;
        }

        public static TinhTrangThanhToanEnum fromValue(String value) {
            for (TinhTrangThanhToanEnum tinhTrangThanhToanEnum : TinhTrangThanhToanEnum.values()) {
                if (tinhTrangThanhToanEnum.value.equals(value)) {
                    return tinhTrangThanhToanEnum;
                }
            }
            return CHUA_THANH_TOAN;
        }
    }
}
