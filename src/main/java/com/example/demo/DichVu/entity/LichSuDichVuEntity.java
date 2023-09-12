package com.example.demo.DichVu.entity;

import com.example.demo.KhachThue.entity.KhachThueEntity;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_seq_gen4")
    @SequenceGenerator(name = "entity_seq_gen4", sequenceName = "entity_sequence_lich_su_dich_vu")
    @Column(name = "ID")
    private Long id;

    @Column(name = "maLichSu", nullable = false, unique = true, length = 10)
    private String maLichSu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MA_KHACH_THUE", nullable = false)
    private KhachThueEntity khachThue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDichVu", nullable = false)
    private DichVuEntity dichVu;

    @Column(name = "NGAY_SU_DUNG")
    @Temporal(TemporalType.DATE)
    private Date ngaySuDung;

    @Column(name = "SO_LUONG")
    private Integer soLuong;

    @Column(name = "TONG_TIEN")
    private Float tongTien;


}