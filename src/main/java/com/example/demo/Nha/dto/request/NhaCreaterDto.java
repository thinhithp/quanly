package com.example.demo.Nha.dto.request;

import com.example.demo.global.Common;
import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PostPersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhaCreaterDto {

    @Comment("Tình trạng nhà")
    // Chỗ này làm sao truyền Enum để không bị lỗi nhỉ ?
    private String tinhTrangNha;

    @Comment("Địa chỉ")
    private String diaChi;

    @Comment("Diện tích")
    private BigDecimal dienTich;

}
