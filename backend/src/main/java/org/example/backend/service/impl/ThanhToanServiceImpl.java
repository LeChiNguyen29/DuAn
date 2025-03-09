package org.example.backend.service.impl;

import org.example.backend.model.ThanhToan;
import org.example.backend.repository.ThanhToanRepository;
import org.example.backend.service.ThanhToanService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ThanhToanServiceImpl implements ThanhToanService {
    private final ThanhToanRepository thanhToanRepository;

    public ThanhToanServiceImpl(ThanhToanRepository thanhToanRepository) {
        this.thanhToanRepository = thanhToanRepository;
    }

    @Override
    public List<ThanhToan> getAllThanhToan() {
        return thanhToanRepository.findAll();
    }

    @Override
    public Optional<ThanhToan> getThanhToanById(Integer id) {
        return thanhToanRepository.findById(id);
    }

    @Override
    public ThanhToan createThanhToan(ThanhToan thanhToan) {
        return thanhToanRepository.save(thanhToan);
    }

    @Override
    public ThanhToan updateThanhToan(Integer id, ThanhToan thanhToan) {
        if (thanhToanRepository.existsById(id)) {
            thanhToan.setId(id);
            return thanhToanRepository.save(thanhToan);
        }
        return null;
    }

    @Override
    public void deleteThanhToan(Integer id) {
        thanhToanRepository.deleteById(id);
    }
}
