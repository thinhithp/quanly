package com.example.demo.tag;

import com.example.demo.global.constants.ApiConstants;
import com.example.demo.tag.dto.request.TagCreateDto;
import com.example.demo.tag.dto.request.TagUpdateDto;
import com.example.demo.tag.entity.TagEntity;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.BASE + ApiConstants.Tag.BASE)
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @PostMapping(ApiConstants.Action.INSERT)
    public TagEntity insert(@RequestBody @Valid TagCreateDto onjInput) {
        return this.service.insert(onjInput);
    }

    @PutMapping(ApiConstants.Action.UPDATE)
    public TagEntity update(@RequestBody @Valid TagUpdateDto onjInput) {
        return this.service.update(onjInput);
    }

    @GetMapping(ApiConstants.Action.DETAIL)
    public Optional<TagEntity> getAllSanPhamIds(@RequestParam Long id) {
        return this.service.getAllSanPhamIds(id);
    }


}
