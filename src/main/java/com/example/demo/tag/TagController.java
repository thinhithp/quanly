package com.example.demo.tag;

import com.example.demo.global.constants.ApiConstants;
import com.example.demo.tag.dto.request.TagCreateDto;
import com.example.demo.tag.dto.request.TagUpdateDto;
import com.example.demo.tag.entity.TagEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(ApiConstants.BASE + ApiConstants.Tag.BASE)
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @PostMapping(ApiConstants.Action.INSERT)
    public TagEntity insert(@RequestBody @Valid  TagCreateDto onjInput) {
        return this.service.insert(onjInput);
    }

    @PutMapping(ApiConstants.Action.UPDATE)
    public TagEntity update(@RequestBody @Valid TagUpdateDto onjInput) {
        return this.service.update(onjInput);
    }

    @GetMapping(ApiConstants.Action.DETAIL)
    public Optional<TagEntity> getAllSanPhamIds(@RequestParam Long id){
        return this.service.getAllSanPhamIds(id);
    }


}
