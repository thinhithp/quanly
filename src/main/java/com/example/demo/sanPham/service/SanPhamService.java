package com.example.demo.sanPham.service;

import com.example.demo.global.Utils.exception.BadRequestException;
import com.example.demo.global.constants.message.Messages;
import com.example.demo.global.services.MessageService;
import com.example.demo.sanPham.SanPhamRepository;
import com.example.demo.sanPham.entity.SanPhamEntity;
import com.example.demo.tag.TagRepository;
import com.example.demo.tag.entity.TagEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SanPhamService {

    private final SanPhamRepository sanPhamRepository;

    private final TagRepository tagRepository;

    private final MessageService messageService;

    @Transactional
    public SanPhamEntity insertWithTags(SanPhamEntity objInput, Long idTag) {
        // Bước 1: Tạo sản phẩm mới
        SanPhamEntity sanPham = objInput;

        // Bước 2: Tạo danh sách các tag bạn muốn gán cho sản phẩm
        Set<TagEntity> tags = new HashSet<>();
        // Tạo và lấy các TagEntity đã tồn tại từ cơ sở dữ liệu
        Optional<TagEntity> optionalTag1 = tagRepository.findById(idTag);
        optionalTag1.ifPresent(tags::add);
        // Bước 3: Gán danh sách tag cho sản phẩm
        sanPham.setTag(tags);
        // Bước 4: Lưu sản phẩm vào cơ sở dữ liệu
        sanPham = sanPhamRepository.save(sanPham);
        return sanPham;
    }

    public SanPhamEntity update(Long id, SanPhamEntity objInput, Long idTag) {

        SanPhamEntity entity = this.sanPhamRepository.findById(id).orElse(null);
        if (entity != null) {
            Set<TagEntity> tags = new HashSet<>();
            // Tạo và lấy các TagEntity đã tồn tại từ cơ sở dữ liệu
            Optional<TagEntity> optionalTag1 = tagRepository.findById(idTag);
            optionalTag1.ifPresent(tags::add);
            entity.setId(id);
            entity.setTag(tags);
            entity = objInput;
            return this.sanPhamRepository.save(entity);
        } else {
            throw new BadRequestException(this.messageService.getMessage(Messages.ID_NOT_EXISTS));
        }


    }

}
