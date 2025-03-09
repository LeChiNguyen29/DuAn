package org.example.backend.service;

import org.example.backend.model.GioHang;
import java.util.List;
import java.util.Optional;

public interface GioHangService {
    List<GioHang> getAllGioHang();
    Optional<GioHang> getGioHangById(Integer id);
    GioHang addToGioHang(GioHang gioHang);
    GioHang updateGioHang(Integer id, GioHang gioHangDetails);
    void removeFromGioHang(Integer id);
}
