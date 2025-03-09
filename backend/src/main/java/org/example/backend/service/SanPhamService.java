package org.example.backend.service;

import org.example.backend.model.SanPham;
import java.util.List;
import java.util.Optional;

public interface SanPhamService {
    List<SanPham> getAllSanPham();
    Optional<SanPham> getSanPhamById(Integer id);
    SanPham createSanPham(SanPham sanPham);
    SanPham updateSanPham(Integer id, SanPham sanPhamDetails);
    void deleteSanPham(Integer id);
}
