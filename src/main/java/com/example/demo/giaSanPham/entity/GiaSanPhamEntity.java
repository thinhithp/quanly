package com.example.demo.giaSanPham.entity;

import com.example.demo.sanPham.entity.SanPhamEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiaSanPhamEntity implements Serializable {
    private static final Long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GIA_SALE")
    private String giaSale;

    @Column(name = "GIA_NIEM_YET")
    private String giaNiemYet;

    @Column(name = "TRANG_THAI")
    @Enumerated(EnumType.ORDINAL)
    private Integer trangThai;

    @Column(name = "NGUOI_NM")
    private String nguoiNm;

    @Column(name = "NGAY_NM")
    private Date ngayNm;

    @Column(name = "NGAY_CN")
    private Date ngayCn;

    @OneToOne(mappedBy = "gia")
    private SanPhamEntity sanPham;
}
