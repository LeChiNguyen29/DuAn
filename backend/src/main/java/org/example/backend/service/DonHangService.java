package org.example.backend.service;

import org.example.backend.model.DonHang;
import java.util.List;
import java.util.Optional;

public interface DonHangService {
    List<DonHang> getAllDonHang();
    Optional<DonHang> getDonHangById(Integer id);
    DonHang createDonHang(DonHang donHang);
    DonHang updateDonHang(Integer id, DonHang donHangDetails);
    void deleteDonHang(Integer id);
}
