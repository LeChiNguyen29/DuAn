package org.example.backend.repository;

import org.example.backend.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    List<DonHang> findByNguoiDungId(Integer nguoiDungId);
}
