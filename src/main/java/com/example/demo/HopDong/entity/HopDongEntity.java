package com.example.demo.HopDong.entity;

import com.example.demo.KhachThue.entity.KhachThueEntity;
import com.example.demo.PhongTro.entity.PhongTroEntity;
import com.example.demo.global.Common;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "HOP_DONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HopDongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "MA_HOP_DONG", nullable = false, unique = true, length = 10)
    private String maHopDong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KHACH_THUE", nullable = false)
    private KhachThueEntity khachThue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PHONG_TRO", nullable = false)
    private PhongTroEntity phong;

    @Column(name = "NGAY_BAT_DAU")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;

    @Column(name = "NGAY_KET_THUC")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;

    @Column(name = "TIEN_DAT_COC")
    private Float tienDatCoc;

    @Column(name = "ChuKyThanhToan", length = 50)
    private Common.ChuKyThanhToanEnum chuKyThanhToan;

    @Enumerated(EnumType.STRING)
    @Column(name = "TinhTrangThanhToan", length = 50)
    private Common.TinhTrangThanhToanEnum tinhTrangThanhToan;

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

    @PrePersist
    public void generateMaHopDong() {
        this.maHopDong = "HĐTN-No".concat(String.valueOf(id));
    }


}