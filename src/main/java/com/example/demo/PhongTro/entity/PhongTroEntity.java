package com.example.demo.PhongTro.entity;

import com.example.demo.HopDong.entity.HopDongEntity;
import com.example.demo.global.Common;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PHONG_TRO")
public class PhongTroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_seq_gen")
    @SequenceGenerator(name = "entity_seq_gen", sequenceName = "entity_sequence")
    @Column(name = "ID_PHONG_TRO")
    private Long id;

    @Column(name = "MA_PHONG",unique = true, updatable = false, nullable = false)
    private String maPhong;

    @Column(name = "TINH_TRANG_PHONG", length = 20)
    private Common.TinhTrangPhong tinhTrangPhong;

    @Column(name = "GIA_THUE")
    private Float giaThue;

    @Column(name = "DIEN_TICH")
    private Float dienTich;

    @Column(name = "MO_TA", length = 4000)
    private String moTa;

    @Column(name = "HINH_ANH", length = 4000)
    private String hinhAnh;

    @Column(name = "DIA_CHI", length = 500)
    private String diaChi;

    @Column(name = "SO_TANG")
    @Min(1)
    @Max(100)
    private Integer soTang;

    @Column(name = "LOAI_PHONG", length = 20)
    private Common.LoaiPhong loaiPhong;

    @Column(name = "SO_NGUOI_TOI_DA")
    @Min(0)
    @Max(10)
    private Integer soNguoiToiDa;

    @Column(name = "SO_NGUOI_HIEN_TAI")
    @Min(0)
    private Integer soNguoiHienTai;

    @Column(name = "NGAY_SAN_SANG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySanSang;

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

    @OneToMany(mappedBy = "phong", fetch = FetchType.LAZY)
    private List<HopDongEntity> lichSuDichVus;

    // Được gọi trước khi một entity được cập nhật
    @PrePersist
    public void generateMaPhong() {
        this.maPhong = "P" + id;
    }
}
