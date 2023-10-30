package com.example.demo.tag;

import com.example.demo.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

    @Transactional
    @Query(value = "SELECT id FROM tag", nativeQuery = true)
    List<Long> findAllTagIds();

    @Transactional
    @Query(value = "SELECT * from tag WHERE id = :id", nativeQuery = true)
    Optional<TagEntity> findById(Long id);

}
