package com.example.demo.KhachThue.entity;

import com.example.demo.DichVu.entity.LichSuDichVuEntity;
import com.example.demo.HopDong.entity.HopDongEntity;
import com.example.demo.global.Common;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KHACH_THUE")
public class KhachThueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_KHACH_THUE")
    private Long id;

    @Column(name = "MA_KHACH_THUE")
    private String maKhachThue;

    @Column(name = "HO", length = 30)
    private String ho;

    @Column(name = "TEN", length = 20)
    private String ten;

    @Column(name = "SO_DIEN_THOAI", length = 20)
    private String sdt;

    @Column(name = "EMAIL", length = 20)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email address.")
    private String email;

    @Column(name = "DIA_CHI_THUONG_TRU", length = 500)
    private String diaChiThuongTru;

    @Column(name = "DIA_CHI_TAM_CHU", length = 500)
    private String diachiTamChu;

    @Column(name = "NGAY_BAT_DAU_THUE")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDauThue;

    @Column(name = "NGAY_KET_THUC_THUE")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThucThue;

    @Column(name = "MA_PHONG")
    private String maPhong;

    @Column(name = "CMND", length = 20)
    private String cmnd;

    @Column(name = "NGAY_SINH")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "GIOI_TINH")
    private Common.GioiTinhEnum gioiTinh;

    @Column(name = "HINH_ANH")
    private String hinhAnh;

    @Column(name = "NGUOI_TAO", length = 4000)
    private String nguoiTao;

    @Column(name = "NGAY_TAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "NGUOI_SUA", length = 4000)
    private String nguoiSua;

    @Column(name = "NGAY_SUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySua;

    @Column(name = "IS_DELETE")
    private Boolean isDelete = false;

    @OneToMany(mappedBy = "khachThue", fetch = FetchType.LAZY)
    private List<LichSuDichVuEntity> lichSuDichVus;

    @OneToMany(mappedBy = "khachThue", fetch = FetchType.LAZY)
    private List<HopDongEntity> hopDong;

    // Được gọi trước khi một entity được cập nhật
    @PrePersist
    public void generateMaKhachThue() {
        this.maKhachThue = "KH" + id;
    }

}
