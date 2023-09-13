package com.example.demo.ThanhToan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "THANH_TOAN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThanhToanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    // Có mã hợp đồng foreign key với bảng hợp đồng
    // Có mã phòng fk với bảng Phòng trọ
    @Column(name = "SO_TIEN")
    private Float soTien;
    @Column(name = "GHI_CHU")
    private String ghiChu;

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
}
