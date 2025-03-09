package org.example.backend.repository;

import org.example.backend.model.NguoiDungQuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NguoiDungQuyenRepository extends JpaRepository<NguoiDungQuyen, Integer> {
    List<NguoiDungQuyen> findByNguoiDung_Id(Integer nguoiDungId);
}
