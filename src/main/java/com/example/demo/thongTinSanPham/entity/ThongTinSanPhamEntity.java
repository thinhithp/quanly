package com.example.demo.thongTinSanPham.entity;

import com.example.demo.sanPham.entity.SanPhamEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "THONG_TIN_CHI_TIET")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinSanPhamEntity implements Serializable {

    private static final Long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "THUONG_HIEU")
    private String thuongHieu;

    @Column(name = "XUAT_XU_THUONG_HIEU")
    private String xuatXu;

    @Column(name = "NOI_SAN_XUAT")
    private String noiSanXuat;

    @Column(name = "DO_TUOI_SU_DUNG")
    private Integer doTuoiSd;

    @Column(name = "TRONG_LUONG")
    private String trongLuong;

    @Column(name = "HUONG_VI")
    private String huongVi;

    @Column(name = "MAU_SAC")
    private String mauSac;

    @Column(name = "CONG_XUAT")
    private String congXuat;

    @Column(name = "BAO_HANH")
    private Integer baoHanh;

    @Column(name = "DUNG_TICH")
    private String dungTich;

    @Column(name = "KICH_CO")
    private String kichCo;

    @Column(name = "CAN_NANG_THICH_HOP")
    private String canNangThichHop;

    @Column(name = "MODEL")
    private Integer model;

    @Column(name = "CHAT_LIEU")
    private String chatLieu;

    @Column(name = "CHAT_LIEU_MAY")
    private String chatLieuMay;

    @Column(name = "CHAT_LIEU_LUOI_DAO")
    private String chatLieuLuoiDao;

    @Column(name = "CHAT_LIEU_COC")
    private String chatLieuCoc;

    @Column(name = "HEN_GIO")
    private Boolean henGio;

    @Column(name = "Loai")
    private Boolean loai;

    @Column(name = "AM_THANH")
    private Boolean amThanh;

    @Column(name = "PIN")
    private Boolean pin;

    @Column(name = "KICH_THUOC_HOP")
    private String kichThuocHop;

    @Column(name = "KICH_THUOC_SAN_PHAM")
    private String kichThuocSanPham;

    @Column(name = "GIOI_TINH_SU_DUNG")
    private String gioiTinhSuDung;

    @OneToOne(mappedBy = "thongTinSanPham")
    private SanPhamEntity sanPham;
}
