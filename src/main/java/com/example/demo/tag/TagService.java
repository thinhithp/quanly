package com.example.demo.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;
    public List<Long> getAllSanPhamIds() {
        return repository.findAllTagIds();
    }
}
