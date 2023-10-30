package com.example.demo.sanPham.service;

import com.example.demo.sanPham.SanPhamRepository;
import com.example.demo.sanPham.entity.SanPhamEntity;
import com.example.demo.tag.TagRepository;
import com.example.demo.tag.entity.TagEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SanPhamService {

    private final SanPhamRepository sanPhamRepository;

    private final TagRepository tagRepository;

    @Transactional
    public SanPhamEntity insertWithTags(SanPhamEntity objInput, Long idTag) {
        // Bước 1: Tạo sản phẩm mới
        SanPhamEntity sanPham = objInput;

        // Bước 2: Tạo danh sách các tag bạn muốn gán cho sản phẩm
        Set<TagEntity> tags = new HashSet<>();

        // Tạo và lấy các TagEntity đã tồn tại từ cơ sở dữ liệu
        Optional<TagEntity> optionalTag1 = tagRepository.findById(idTag);
        optionalTag1.ifPresent(tag -> tags.add(tag));

        // Bước 3: Gán danh sách tag cho sản phẩm
        sanPham.setTag(tags);

        // Bước 4: Lưu sản phẩm vào cơ sở dữ liệu
        sanPham = sanPhamRepository.save(sanPham);

        return sanPham;
    }


        public static int generateRandomNumber(int limit) {
            Random random = new Random();
            return random.nextInt(limit) + 1;
        }

        public static void main(String[] args) {
            int limit = 100; // Giới hạn để tạo số ngẫu nhiên từ 1 đến 100
            int randomResult = generateRandomNumber(limit);
            System.out.println("Số ngẫu nhiên là: " + randomResult);
        }

}
