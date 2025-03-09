package org.example.backend.service.impl;

import org.example.backend.model.DanhGia;
import org.example.backend.repository.DanhGiaRepository;
import org.example.backend.service.DanhGiaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DanhGiaServiceImpl implements DanhGiaService {
    private final DanhGiaRepository danhGiaRepository;

    public DanhGiaServiceImpl(DanhGiaRepository danhGiaRepository) {
        this.danhGiaRepository = danhGiaRepository;
    }

    @Override
    public List<DanhGia> getAllDanhGia() {
        return danhGiaRepository.findAll();
    }

    @Override
    public Optional<DanhGia> getDanhGiaById(Integer id) {
        return danhGiaRepository.findById(id);
    }

    @Override
    public DanhGia createDanhGia(DanhGia danhGia) {
        return danhGiaRepository.save(danhGia);
    }

    @Override
    public DanhGia updateDanhGia(Integer id, DanhGia danhGia) {
        if (danhGiaRepository.existsById(id)) {
            danhGia.setId(id);
            return danhGiaRepository.save(danhGia);
        }
        return null;
    }

    @Override
    public void deleteDanhGia(Integer id) {
        danhGiaRepository.deleteById(id);
    }
}
