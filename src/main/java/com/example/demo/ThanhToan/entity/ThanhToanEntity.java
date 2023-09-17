package com.example.demo.ThanhToan.entity;

import com.example.demo.DichVu.entity.DichVuEntity;
import com.example.demo.DichVu.entity.LichSuDichVuEntity;
import com.example.demo.HopDong.entity.HopDongEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dich_vu", referencedColumnName = "id")
    private DichVuEntity dichVu;

    @OneToOne(mappedBy = "thanhToan")
    private LichSuDichVuEntity lichSuDichVu;

    @ManyToOne
    @JoinColumn(name = "id_hop_dong", referencedColumnName = "id")
    private HopDongEntity hopDong;

}
