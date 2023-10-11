package com.example.demo.tag.entity;

import com.example.demo.sanPham.entity.SanPhamEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "TAG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagEntity implements Serializable {

    private static final Long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TAG_NAME")
    private String tagName;

    @ManyToMany(mappedBy = "tag")
    private Set<SanPhamEntity> sanPhams;

}
