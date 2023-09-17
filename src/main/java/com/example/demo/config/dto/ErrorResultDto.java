package com.example.demo.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResultDto {
    @Comment( "Tên")
    private String ten;
    @Comment("Message")
    private String message;
}
