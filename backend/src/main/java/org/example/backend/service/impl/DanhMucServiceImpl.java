package org.example.backend.service.impl;

import org.example.backend.model.DanhMuc;
import org.example.backend.repository.DanhMucRepository;
import org.example.backend.service.DanhMucService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    private final DanhMucRepository danhMucRepository;

    public DanhMucServiceImpl(DanhMucRepository danhMucRepository) {
        this.danhMucRepository = danhMucRepository;
    }

    @Override
    public List<DanhMuc> getAllDanhMuc() {
        return danhMucRepository.findAll();
    }

    @Override
    public Optional<DanhMuc> getDanhMucById(Integer id) {
        return danhMucRepository.findById(id);
    }

    @Override
    public DanhMuc createDanhMuc(DanhMuc danhMuc) {
        return danhMucRepository.save(danhMuc);
    }

    @Override
    public DanhMuc updateDanhMuc(Integer id, DanhMuc danhMucDetails) {
        return danhMucRepository.findById(id).map(danhMuc -> {
            danhMuc.setTenDanhMuc(danhMucDetails.getTenDanhMuc());
            danhMuc.setMoTa(danhMucDetails.getMoTa());
            return danhMucRepository.save(danhMuc);
        }).orElse(null);
    }

    @Override
    public void deleteDanhMuc(Integer id) {
        danhMucRepository.deleteById(id);
    }
}

