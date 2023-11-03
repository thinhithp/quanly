package com.example.demo.sanPham;

import com.example.demo.global.constants.ApiConstants;
import com.example.demo.sanPham.entity.SanPhamEntity;
import com.example.demo.sanPham.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE + ApiConstants.SanPham.BASE)
@RequiredArgsConstructor
public class SanPhamController {

    private final SanPhamService service;

    @PostMapping(ApiConstants.Action.INSERT)
    public SanPhamEntity insert(@ModelAttribute SanPhamEntity sanPham, @RequestParam Long id) {
        return this.service.insertWithTags(sanPham, id);
    }

    @PutMapping(ApiConstants.Action.UPDATE + "/{id}")
    public SanPhamEntity update(@RequestParam Long id, @RequestBody SanPhamEntity sanPham, @RequestParam Long idTag) {
        return this.service.update(id, sanPham, idTag);
    }

}
