package com.example.demo.Nha;

import com.example.demo.Nha.dto.request.NhaCreaterDto;
import com.example.demo.Nha.dto.request.NhaUpdateDto;
import com.example.demo.Nha.entity.NhaEntity;
import com.example.demo.Nha.service.NhaService;
import com.example.demo.config.dto.ResultDtos;
import com.example.demo.global.constansts.ApiConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NhaController {

    private final NhaService nhaService;

    @PostMapping(ApiConstants.Nha.NHA_CREATE)
    public NhaEntity insertNha(@RequestBody NhaCreaterDto nhaCreaterDto) throws IOException {
        return this.nhaService.insertNha(nhaCreaterDto);
    }

    @PutMapping(ApiConstants.Nha.NHA_UPDATE)
    public void updateNha(@PathVariable Long id, @RequestBody NhaUpdateDto nhaUpdateDto) {
        this.nhaService.updateNha(id, nhaUpdateDto);
    }

    @GetMapping(ApiConstants.Nha.DETAIL)
    public Optional<NhaEntity> detail(@PathVariable Long id) {
        return this.nhaService.findById(id);
    }

    @PutMapping(ApiConstants.Nha.NHA_UPDATE_IMAGE)
    public ResultDtos updateImageNha(@PathVariable Long id,
                                     @RequestBody List<MultipartFile> multipartFiles
    ) throws IOException {
        return this.nhaService.updateImage(id, multipartFiles);
    }

    @GetMapping(ApiConstants.Nha.GET_LINK_IMAGE)
    public List<String> getLinkImage(@PathVariable Long id
    ) throws IOException {
        return this.nhaService.readFolderRenderLinkFile(id);
    }

    @DeleteMapping(ApiConstants.Nha.DELETE)
    public Boolean deleteNha(@PathVariable Long id
    ) {
        return this.nhaService.deleteNha(id);
    }
}
