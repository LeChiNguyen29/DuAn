package org.example.backend.service.impl;

import org.example.backend.model.SanPham;
import org.example.backend.repository.SanPhamRepository;
import org.example.backend.service.SanPhamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository sanPhamRepository;

    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Optional<SanPham> getSanPhamById(Integer id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public SanPham createSanPham(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham updateSanPham(Integer id, SanPham sanPhamDetails) {
        return sanPhamRepository.findById(id).map(sanPham -> {
            sanPham.setTenSanPham(sanPhamDetails.getTenSanPham());
            sanPham.setMoTa(sanPhamDetails.getMoTa());
            sanPham.setGia(sanPhamDetails.getGia());
            sanPham.setSoLuong(sanPhamDetails.getSoLuong());
            sanPham.setAnhSanPham(sanPhamDetails.getAnhSanPham());
            return sanPhamRepository.save(sanPham);
        }).orElse(null);
    }

    @Override
    public void deleteSanPham(Integer id) {
        sanPhamRepository.deleteById(id);
    }
}
