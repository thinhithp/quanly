package com.example.demo.sanPham;

import com.example.demo.sanPham.entity.SanPhamEntity;
import com.example.demo.sanPham.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SanPhamController {

    private final SanPhamService service;

    @PostMapping("/insert")
    public SanPhamEntity insert(@ModelAttribute SanPhamEntity sanPham) {
        return this.service.insertWithTags(sanPham);
    }

}
