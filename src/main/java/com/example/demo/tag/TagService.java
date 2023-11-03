package com.example.demo.tag;

import com.example.demo.global.Utils.exception.BadRequestException;
import com.example.demo.global.constants.message.Messages;
import com.example.demo.global.services.MessageService;
import com.example.demo.tag.dto.request.TagCreateDto;
import com.example.demo.tag.dto.request.TagUpdateDto;
import com.example.demo.tag.entity.TagEntity;
import com.example.demo.tag.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;
    private final MessageService messageService;

    public Optional<TagEntity> getAllSanPhamIds(Long id) {
        return Optional.ofNullable(this.repository.findById(id).orElseThrow(() -> new BadRequestException(this.messageService.getMessage(Messages.ID_NOT_EXISTS))));
    }

    public TagEntity insert(TagCreateDto objInput) {
        TagEntity objOutput = TagMapper.getInstance().toEntity(objInput);
        return repository.save(objOutput);
    }

    public TagEntity update(TagUpdateDto objInput) {
        Optional<TagEntity> tagEntity = this.repository.findById(objInput.getId());
        if (!tagEntity.isPresent()) {
            throw new BadRequestException(this.messageService.getMessage(Messages.ID_NOT_EXISTS));
        }
        TagEntity objOutput = TagMapper.getInstance().toEntity(objInput);
        return repository.save(objOutput);
    }
}
