package com.example.demo.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.List;

@Data
@AllArgsConstructor
public class ResultDtos {
    @Comment( "Số tệp thành công")
    private List<String> success;
    @Comment("Số tệp thất bại")
    private List<ErrorResultDto> errors;
}
