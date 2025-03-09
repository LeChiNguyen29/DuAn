package org.example.backend.service;

import org.example.backend.model.ThanhToan;
import java.util.List;
import java.util.Optional;

public interface ThanhToanService {
    List<ThanhToan> getAllThanhToan();
    Optional<ThanhToan> getThanhToanById(Integer id);
    ThanhToan createThanhToan(ThanhToan thanhToan);
    ThanhToan updateThanhToan(Integer id, ThanhToan thanhToan);
    void deleteThanhToan(Integer id);
}
