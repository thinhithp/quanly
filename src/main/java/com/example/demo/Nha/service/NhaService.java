package com.example.demo.Nha.service;

import com.example.demo.Nha.dto.request.NhaCreaterDto;
import com.example.demo.Nha.dto.request.NhaUpdateDto;
import com.example.demo.Nha.entity.NhaEntity;
import com.example.demo.config.dto.ResultDtos;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NhaService {

    NhaEntity insertNha(NhaCreaterDto createrDto) throws IOException;

    void updateNha(Long id, NhaUpdateDto nhaUpdateDto);

    Optional<NhaEntity> findById(Long aLong);

    ResultDtos updateImage(Long id, List<MultipartFile> imageFiles) throws IOException;

    List<String> readFolderRenderLinkFile(Long id) throws IOException;

    Boolean deleteNha(Long id);
}
