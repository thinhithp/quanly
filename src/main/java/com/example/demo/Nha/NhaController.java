package com.example.demo.Nha;

import com.example.demo.Nha.dto.request.NhaCreaterDto;
import com.example.demo.Nha.dto.request.NhaUpdateDto;
import com.example.demo.Nha.entity.NhaEntity;
import com.example.demo.Nha.service.NhaService;
import com.example.demo.global.constansts.ApiConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NhaController {

    private final NhaService nhaService;

    @PostMapping(ApiConstants.Nha.NHA_CREATE)
    public void insertNha(@RequestBody NhaCreaterDto nhaCreaterDto) {
         this.nhaService.insertNha(nhaCreaterDto);
    }
    @PutMapping(ApiConstants.Nha.NHA_UPDATE)
    public void updateNha(@PathVariable Long id,@RequestBody NhaUpdateDto nhaUpdateDto) {
         this.nhaService.updateNha(id,nhaUpdateDto);
    }

    @GetMapping(ApiConstants.Nha.DETAIL)
    public Optional<NhaEntity> detail(@PathVariable Long id) {
      return   this.nhaService.findById(id);
    }
}
