package org.example.backend.service;

import org.example.backend.model.DanhGia;
import java.util.List;
import java.util.Optional;

public interface DanhGiaService {
    List<DanhGia> getAllDanhGia();
    Optional<DanhGia> getDanhGiaById(Integer id);
    DanhGia createDanhGia(DanhGia danhGia);
    DanhGia updateDanhGia(Integer id, DanhGia danhGia);
    void deleteDanhGia(Integer id);
}
