package org.example.backend.repository;

import org.example.backend.model.DanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia, Integer> {
    List<DanhGia> findBySanPhamId(Integer sanPhamId);
}
