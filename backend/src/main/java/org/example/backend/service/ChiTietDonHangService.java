package org.example.backend.service;

import org.example.backend.model.ChiTietDonHang;
import java.util.List;
import java.util.Optional;

public interface ChiTietDonHangService {
    List<ChiTietDonHang> getAllChiTietDonHang();
    Optional<ChiTietDonHang> getChiTietDonHangById(Integer id);
    ChiTietDonHang createChiTietDonHang(ChiTietDonHang chiTietDonHang);
    ChiTietDonHang updateChiTietDonHang(Integer id, ChiTietDonHang chiTietDonHang);
    void deleteChiTietDonHang(Integer id);
}
