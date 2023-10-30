package com.example.demo.tag;

import com.example.demo.tag.entity.TagEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;
    public Optional<TagEntity> getAllSanPhamIds(Long id) {
        return repository.findById(id);
    }
}
