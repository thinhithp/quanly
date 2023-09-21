package com.example.demo.Nha.service.impl;

import com.example.demo.Nha.dto.request.NhaCreaterDto;
import com.example.demo.Nha.dto.request.NhaUpdateDto;
import com.example.demo.Nha.dto.responts.AnhNhaDtos;
import com.example.demo.Nha.dto.responts.NhaResponts;
import com.example.demo.Nha.entity.NhaEntity;
import com.example.demo.Nha.repository.NhaRepository;
import com.example.demo.Nha.service.NhaService;
import com.example.demo.config.GoogleApiConnectService;
import com.example.demo.config.dto.ResultDtos;
import com.example.demo.global.Utils.StringUtils;
import com.example.demo.global.constansts.Contants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NhaServiceImpl implements NhaService {

    private final NhaRepository nhaRepository;

    private final GoogleApiConnectService googleService;


    @Override
    public NhaEntity insertNha(NhaCreaterDto createrDto) throws IOException {
        //. Khi cập nhật dữ liệu, thì sẽ tạo ra 1 folder có tên theo mã nhà
        NhaEntity entity = this.nhaRepository.insertNha(createrDto);

        String path = this.googleService.createNewFolder(entity.getMaNha());
        entity.setHinhAnh(path);

        return this.nhaRepository.save(entity);
    }

    @Override
    public void updateNha(Long id, NhaUpdateDto nhaUpdateDto) {
        this.nhaRepository.updateNha(id, nhaUpdateDto);
    }

    @Override
    public NhaResponts findById(Long aLong)  {
        Optional<NhaEntity> nha = nhaRepository.findById(aLong);

        return nha.map(nhaEntity -> {
            List<String> listAnhNha = null;
            try {
                listAnhNha = this.readFolderRenderLinkFile(nhaEntity.getId());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            AnhNhaDtos anhNhaDtos = new AnhNhaDtos(listAnhNha);
            return new NhaResponts(nhaEntity, anhNhaDtos);
        }).orElseThrow(() -> new RuntimeException("không có id"));
    }


    @Override
    public ResultDtos updateImage(Long id, List<MultipartFile> imageFiles) {
        return nhaRepository.findById(id)
                .map(nhaEntity -> {
                    String folderLink = nhaEntity.getHinhAnh();
                    String folderId = StringUtils.extractFolderIdFromLink(folderLink);
                    try {
                        return googleService.uploadImagesV2(imageFiles, folderId);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new RuntimeException(Contants.ID_IS_NOT_EXISTS));
    }

    @Override
    public List<String> readFolderRenderLinkFile(Long id) throws IOException {
        NhaEntity nhaEntity = this.nhaRepository.findById(id).orElseThrow(() -> new RuntimeException(Contants.ID_IS_NOT_EXISTS));
        String folderLink = nhaEntity.getHinhAnh();
        String folderId = StringUtils.extractFolderIdFromLink(folderLink);
        return this.googleService.listFilesInFolder(folderId);
    }

    @Override
    public Boolean deleteNha(Long id) {
        NhaEntity nhaEntity = this.nhaRepository.findById(id).orElseThrow(() -> new RuntimeException(Contants.ID_IS_NOT_EXISTS));
        int affectedRows = nhaRepository.deleteNha(nhaEntity.getId());
        return affectedRows > 0;
    }


}
