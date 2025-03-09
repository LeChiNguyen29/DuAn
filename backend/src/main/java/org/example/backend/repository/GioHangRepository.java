package org.example.backend.repository;

import org.example.backend.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
    List<GioHang> findByNguoiDungId(Integer nguoiDungId);
}
