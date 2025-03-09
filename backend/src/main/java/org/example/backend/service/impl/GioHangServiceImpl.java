package org.example.backend.service.impl;

import org.example.backend.model.GioHang;
import org.example.backend.repository.GioHangRepository;
import org.example.backend.service.GioHangService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioHangServiceImpl implements GioHangService {
    private final GioHangRepository gioHangRepository;

    public GioHangServiceImpl(GioHangRepository gioHangRepository) {
        this.gioHangRepository = gioHangRepository;
    }

    @Override
    public List<GioHang> getAllGioHang() {
        return gioHangRepository.findAll();
    }

    @Override
    public Optional<GioHang> getGioHangById(Integer id) {
        return gioHangRepository.findById(id);
    }

    @Override
    public GioHang addToGioHang(GioHang gioHang) {
        return gioHangRepository.save(gioHang);
    }

    @Override
    public GioHang updateGioHang(Integer id, GioHang gioHangDetails) {
        return gioHangRepository.findById(id).map(gioHang -> {
            gioHang.setId(gioHangDetails.getId());
            gioHang.setSoLuong(gioHangDetails.getSoLuong());
            return gioHangRepository.save(gioHang);
        }).orElse(null);
    }

    @Override
    public void removeFromGioHang(Integer id) {
        gioHangRepository.deleteById(id);
    }
}
