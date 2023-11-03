package com.example.demo.tag.mapper;

import com.example.demo.tag.dto.request.TagCreateDto;
import com.example.demo.tag.dto.request.TagUpdateDto;
import com.example.demo.tag.entity.TagEntity;

import javax.validation.Valid;

public class TagMapper {
    private static TagMapper instance;

    public static TagMapper getInstance() {
        if (instance == null) {
            instance = new TagMapper();
        }
        return instance;
    }

    public TagEntity toEntity(@Valid  TagCreateDto data) {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setTagName(data.getTagName());
        tagEntity.setITemCode(data.getItemCode());
        tagEntity.setGroupCode(data.getGroupCode());
        tagEntity.setParentCode(data.getParentCode());
        return tagEntity;
    }

    public TagEntity toEntity(@Valid TagUpdateDto data) {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(data.getId());
        tagEntity.setTagName(data.getTagName());
        tagEntity.setITemCode(data.getItemCode());
        tagEntity.setGroupCode(data.getGroupCode());
        tagEntity.setParentCode(data.getParentCode());
        return tagEntity;
    }
}
