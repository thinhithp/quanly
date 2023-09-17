package com.example.demo.DichVu.entity;

import com.example.demo.Nha.entity.NhaEntity;
import com.example.demo.ThanhToan.entity.ThanhToanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "DICH_VU")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DichVuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MA_DICH_VU", nullable = false, unique = true, length = 50)
    private String maDichVu;

    @Column(name = "TEN_DICH_VU", length = 100)
    private String tenDichVu;

    @Column(name = "GIA")
    private Float gia;

    @Column(name = "MO_TA", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "DVT", length = 10)
    private String dvt;

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

    @ManyToOne
    @JoinColumn(name = "id_nha", referencedColumnName = "id")
    private NhaEntity nha;

    @OneToOne(mappedBy = "dichVu")
    private ThanhToanEntity thanhToan;


    @PrePersist
    public void generateMaDichVu() {
        this.maDichVu = "D  V".concat(String.valueOf(id));
    }

}

