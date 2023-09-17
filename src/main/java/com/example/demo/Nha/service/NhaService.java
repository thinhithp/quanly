package com.example.demo.Nha.service;

import com.example.demo.Nha.dto.request.NhaCreaterDto;
import com.example.demo.Nha.dto.request.NhaUpdateDto;
import com.example.demo.Nha.entity.NhaEntity;

import java.util.Optional;

public interface NhaService  {

    void insertNha(NhaCreaterDto createrDto);

    void updateNha(Long id,NhaUpdateDto nhaUpdateDto);

    Optional<NhaEntity> findById(Long aLong);
}
