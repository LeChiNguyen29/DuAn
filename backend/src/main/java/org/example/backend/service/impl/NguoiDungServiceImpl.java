package org.example.backend.service.impl;

import org.example.backend.model.NguoiDung;
import org.example.backend.repository.NguoiDungRepository;
import org.example.backend.service.NguoiDungService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    private final NguoiDungRepository nguoiDungRepository;

    public NguoiDungServiceImpl(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    @Override
    public List<NguoiDung> getAllNguoiDung() {
        return nguoiDungRepository.findAll();
    }

    @Override
    public Optional<NguoiDung> getNguoiDungById(Integer id) {
        return nguoiDungRepository.findById(id);
    }

    @Override
    public NguoiDung createNguoiDung(NguoiDung nguoiDung) {
        return nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public NguoiDung updateNguoiDung(Integer id, NguoiDung nguoiDungDetails) {
        return nguoiDungRepository.findById(id).map(nguoiDung -> {
            nguoiDung.setTenDangNhap(nguoiDungDetails.getTenDangNhap());
            nguoiDung.setMatKhau(nguoiDungDetails.getMatKhau());
            nguoiDung.setEmail(nguoiDungDetails.getEmail());
            nguoiDung.setSoDienThoai(nguoiDungDetails.getSoDienThoai());
            nguoiDung.setDiaChi(nguoiDungDetails.getDiaChi());
            return nguoiDungRepository.save(nguoiDung);
        }).orElse(null);
    }

    @Override
    public void deleteNguoiDung(Integer id) {
        nguoiDungRepository.deleteById(id);
    }
}
