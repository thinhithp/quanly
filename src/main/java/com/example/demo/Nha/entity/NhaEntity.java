package com.example.demo.Nha.entity;

import com.example.demo.DichVu.entity.LichSuDichVuEntity;
import com.example.demo.KhachThue.entity.KhachThueEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NHA")
public class NhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DIA_CHI")
    private String diaChi;

    @Column(name = "DIEN_TICH")
    @Comment("Họ")
    private Float dienTich;

    @Column(name = "GHI_CHU")
    @Comment("Ghi chú")
    private String ghiChu;

    @Column(name = "GIA_THUE")
    @Comment("Giá thuê")
    private Float giaThue;

    @Column(name = "HINH_ANH")
    @Comment("Hình ảnh")
    private String hinhAnh;

    @OneToMany(mappedBy = "ID", fetch = FetchType.LAZY)
    private List<KhachThueEntity> khachThue;

    @Column(name = "LOAI_NHA")
    @Comment("Loại nhà")
    private String loaiNha;

    @Column(name = "MA_NHA")
    @Comment("Mã nhà")
    private String maNha;

    @Column(name = "NGUOI_TAO")
    @Comment("Người tạo")
    private String nguoiTao;

    @Column(name = "NGAY_TAO")
    @Comment("Ngày tạo")
    private Date ngayTao;

    @Column(name = "NGUOI_SUA")
    @Comment("Người sửa")
    private String nguoiSua;

    @Column(name = "NGAY_SUA")
    @Comment("Ngày sửa")
    private Date ngaySua;

    @Column(name = "TINH_TRANG_NHA")
    @Comment("Tình trạng nhà")
    private Date tinhTrangNha;

    @Column(name = "TONG_SO_TANG")
    @Comment("Tổng số tầng")
    private Date tongSoTang;

}
