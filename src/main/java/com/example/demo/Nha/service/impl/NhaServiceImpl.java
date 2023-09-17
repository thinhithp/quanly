package com.example.demo.Nha.service.impl;

import com.example.demo.Nha.dto.request.NhaCreaterDto;
import com.example.demo.Nha.dto.request.NhaUpdateDto;
import com.example.demo.Nha.entity.NhaEntity;
import com.example.demo.Nha.repository.NhaRepository;
import com.example.demo.Nha.service.NhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NhaServiceImpl implements NhaService {

    private final NhaRepository nhaRepository;


    @Override
    public void insertNha(NhaCreaterDto createrDto) {
         this.nhaRepository.insertNha(createrDto);

    }

    @Override
    public void updateNha(Long id,NhaUpdateDto nhaUpdateDto) {
        this.nhaRepository.updateNha(id,nhaUpdateDto);
    }

    @Override
    public Optional<NhaEntity> findById(Long aLong) {
        Optional<NhaEntity> nha = nhaRepository.findById(aLong);
        if (!nha.isPresent()){
            throw new RuntimeException("không có id");
        }
        return nha;
    }


}
