package org.example.backend.service.impl;

import org.example.backend.model.DonHang;
import org.example.backend.repository.DonHangRepository;
import org.example.backend.service.DonHangService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonHangServiceImpl implements DonHangService {
    private final DonHangRepository donHangRepository;

    public DonHangServiceImpl(DonHangRepository donHangRepository) {
        this.donHangRepository = donHangRepository;
    }

    @Override
    public List<DonHang> getAllDonHang() {
        return donHangRepository.findAll();
    }

    @Override
    public Optional<DonHang> getDonHangById(Integer id) {
        return donHangRepository.findById(id);
    }

    @Override
    public DonHang createDonHang(DonHang donHang) {
        return donHangRepository.save(donHang);
    }

    @Override
    public DonHang updateDonHang(Integer id, DonHang donHangDetails) {
        return donHangRepository.findById(id).map(donHang -> {
            donHang.setTongTien(donHangDetails.getTongTien());
            donHang.setTrangThai(donHangDetails.getTrangThai());
            return donHangRepository.save(donHang);
        }).orElse(null);
    }

    @Override
    public void deleteDonHang(Integer id) {
        donHangRepository.deleteById(id);
    }
}
