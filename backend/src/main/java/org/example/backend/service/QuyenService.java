package org.example.backend.service;

import org.example.backend.model.Quyen;
import java.util.List;
import java.util.Optional;

public interface QuyenService {
    List<Quyen> getAllQuyen();
    Optional<Quyen> getQuyenById(Integer id);
    Quyen createQuyen(Quyen quyen);
    Quyen updateQuyen(Integer id, Quyen quyen);
    void deleteQuyen(Integer id);
}
