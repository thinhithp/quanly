package com.example.demo.Nha.dto.responts;

import com.example.demo.Nha.entity.NhaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaResponts {
    private NhaEntity nhaEntity;
    private AnhNhaDtos anhNhaDtos;
}
