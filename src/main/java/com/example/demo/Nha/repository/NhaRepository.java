package com.example.demo.Nha.repository;

import com.example.demo.Nha.dto.request.NhaCreaterDto;
import com.example.demo.Nha.dto.request.NhaUpdateDto;
import com.example.demo.Nha.entity.NhaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaRepository extends JpaRepository<NhaEntity, Long> {

    @Transactional
    // @Modifying
    @Query(value = "INSERT INTO NHA (TINH_TRANG_NHA, DIA_CHI, DIEN_TICH, NGUOI_TAO, NGAY_TAO, IS_DELETE) " +
            "VALUES (:#{#nhaCreaterDto.tinhTrangNha}, :#{#nhaCreaterDto.diaChi}, " +
            ":#{#nhaCreaterDto.dienTich}, 'thinhnq', CURRENT_DATE, 0) " +
            "RETURNING *", // Trả về tất cả các cột trong bảng NHA
            nativeQuery = true)
    NhaEntity insertNha(NhaCreaterDto nhaCreaterDto);

    @Transactional
    @Modifying
    @Query(value = "UPDATE NHA " +
            "SET " +
            "TINH_TRANG_NHA = COALESCE(:#{#nhaUpdateDto.tinhTrangNha}, TINH_TRANG_NHA), " +
            "DIA_CHI = :#{#nhaUpdateDto.diaChi}, " +
            "GIA_THUE = :#{#nhaUpdateDto.giaThue}, " +
            "DIEN_TICH = :#{#nhaUpdateDto.dienTich}, " +
            "HINH_ANH = :#{#nhaUpdateDto.hinhAnh}, " +
            "TONG_SO_TANG = :#{#nhaUpdateDto.tongSoTang}, " +
            "LOAI_NHA = :#{#nhaUpdateDto.loaiNha}, " +
            "GHI_CHU = :#{#nhaUpdateDto.ghiChu}, " +
            "NGUOI_SUA = 'thinhnq' " +
            "WHERE ID = :id ",
            nativeQuery = true)
    void updateNha(@Param("id") Long id, @Param("nhaUpdateDto") NhaUpdateDto nhaUpdateDto);

    @Transactional
    @Modifying
    @Query(value = "UPDATE NHA SET IS_DELETE = 1 WHERE ID =:id", nativeQuery = true)
    int deleteNha(@Param("id") Long id);

}
