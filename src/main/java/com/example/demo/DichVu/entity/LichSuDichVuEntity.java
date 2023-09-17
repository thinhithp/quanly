package com.example.demo.DichVu.entity;

import com.example.demo.ThanhToan.entity.ThanhToanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "LICH_SU_DICH_VU")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LichSuDichVuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NGAY_SU_DUNG")
    @Temporal(TemporalType.DATE)
    private Date ngaySuDung;

    @Column(name = "SO_LUONG")
    private Integer soLuong;

    @Column(name = "TONG_TIEN")
    private Float tongTien;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_thanh_toan", referencedColumnName = "id")
    private ThanhToanEntity thanhToan;

}