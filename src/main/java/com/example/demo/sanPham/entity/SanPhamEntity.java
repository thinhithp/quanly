package com.example.demo.sanPham.entity;

import com.example.demo.giaSanPham.entity.GiaSanPhamEntity;
import com.example.demo.soLuong.entity.SoLuongEntity;
import com.example.demo.tag.entity.TagEntity;
import com.example.demo.thongTinSanPham.entity.ThongTinSanPhamEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SAN_PHAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamEntity implements Serializable {
    private static final Long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MA_SAN_PHAM", nullable = false, unique = true, length = 20)
    private String maSanPham;

    @Column(name = "MO_TA_CHI_TIET")
    private String moTaChiTiet;

    @Column(name = "MO_TA_NHANH")
    private String moTaNhanh;

    @Column(name = "TRANG_THAI")
    private Integer trangThai;

    @Column(name = "NGUOI_NM")
    private String nguoiNm;

    @Column(name = "NGAY_NM")
    private Date ngayNm;

    @Column(name = "NGAY_CN")
    private Date ngayCn;


    @OneToOne(mappedBy = "sanPham", cascade = CascadeType.ALL)
    private SoLuongEntity soLuong;

    @OneToOne(mappedBy = "sanPham",cascade = CascadeType.ALL)
    private GiaSanPhamEntity gia;

    @OneToOne(mappedBy = "sanPham",cascade = CascadeType.ALL)
    private ThongTinSanPhamEntity thongTinSanPham;

    @ManyToMany
    @JoinTable(
            name = "tag_san_pham",
            joinColumns = @JoinColumn(name = "san_pham_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagEntity> tag;

}
