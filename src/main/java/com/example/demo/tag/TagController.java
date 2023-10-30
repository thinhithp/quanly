package com.example.demo.tag;

import com.example.demo.tag.entity.TagEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @GetMapping("/get-tag")
    public Optional<TagEntity> findIdTag(@RequestParam Long id) {
        return this.service.getAllSanPhamIds(id);

    }
}
