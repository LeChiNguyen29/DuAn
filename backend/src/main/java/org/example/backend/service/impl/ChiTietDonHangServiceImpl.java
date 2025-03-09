package org.example.backend.service.impl;

import org.example.backend.model.ChiTietDonHang;
import org.example.backend.repository.ChiTietDonHangRepository;
import org.example.backend.service.ChiTietDonHangService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService {
    private final ChiTietDonHangRepository chiTietDonHangRepository;

    public ChiTietDonHangServiceImpl(ChiTietDonHangRepository chiTietDonHangRepository) {
        this.chiTietDonHangRepository = chiTietDonHangRepository;
    }

    @Override
    public List<ChiTietDonHang> getAllChiTietDonHang() {
        return chiTietDonHangRepository.findAll();
    }

    @Override
    public Optional<ChiTietDonHang> getChiTietDonHangById(Integer id) {
        return chiTietDonHangRepository.findById(id);
    }

    @Override
    public ChiTietDonHang createChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        return chiTietDonHangRepository.save(chiTietDonHang);
    }

    @Override
    public ChiTietDonHang updateChiTietDonHang(Integer id, ChiTietDonHang chiTietDonHang) {
        if (chiTietDonHangRepository.existsById(id)) {
            chiTietDonHang.setId(id);
            return chiTietDonHangRepository.save(chiTietDonHang);
        }
        return null;
    }

    @Override
    public void deleteChiTietDonHang(Integer id) {
        chiTietDonHangRepository.deleteById(id);
    }
}
