package com.example.demo.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @GetMapping("/get-tag")
    public List<Long> findIdTag() {
        return this.service.getAllSanPhamIds();

    }
}
