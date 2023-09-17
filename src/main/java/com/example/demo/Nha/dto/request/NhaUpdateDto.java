package com.example.demo.Nha.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaUpdateDto {

    private String tinhTrangNha;
    private String diaChi;
    private Integer giaThue;
    private Integer dienTich;
    private String hinhAnh;
    private Integer tongSoTang;
    private String loaiNha;
    private String ghiChu;

}
