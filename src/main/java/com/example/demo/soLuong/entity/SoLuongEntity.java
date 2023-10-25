package com.example.demo.soLuong.entity;

import com.example.demo.sanPham.entity.SanPhamEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "SO_LUONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoLuongEntity implements Serializable {

    private static final Long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String inEvent;

    @Column(name = "SO_LUONG_TONG")
    private Integer soLuongTong;

    @Column(name = "SO_LUONG_TON")
    private Integer soLuongTon;

    @Column(name = "SO_LUONG_TREO")
    private Integer soLuongTreo;

    private Integer idGioHang;

    @Column(name = "TRANG_THAI")
    private Integer trangThai;

    @OneToOne()
    @JoinColumn(name = "id_san_pham")
    private SanPhamEntity sanPham;
}
