package com.example.demo.sanPham;

import com.example.demo.sanPham.entity.SanPhamEntity;
import com.example.demo.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Long> {


}
