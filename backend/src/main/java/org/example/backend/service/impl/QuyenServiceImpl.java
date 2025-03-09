package org.example.backend.service.impl;

import org.example.backend.model.Quyen;
import org.example.backend.repository.QuyenRepository;
import org.example.backend.service.QuyenService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuyenServiceImpl implements QuyenService {
    private final QuyenRepository quyenRepository;

    public QuyenServiceImpl(QuyenRepository quyenRepository) {
        this.quyenRepository = quyenRepository;
    }

    @Override
    public List<Quyen> getAllQuyen() {
        return quyenRepository.findAll();
    }

    @Override
    public Optional<Quyen> getQuyenById(Integer id) {
        return quyenRepository.findById(id);
    }

    @Override
    public Quyen createQuyen(Quyen quyen) {
        return quyenRepository.save(quyen);
    }

    @Override
    public Quyen updateQuyen(Integer id, Quyen quyenDetails) {
        return quyenRepository.findById(id).map(quyen -> {
            if (quyenDetails.getTenQuyen() != null && !quyenDetails.getTenQuyen().trim().isEmpty()) {
                quyen.setTenQuyen(quyenDetails.getTenQuyen());
            } else {
                throw new IllegalArgumentException("Tên quyền không được để trống");
            }
            return quyenRepository.save(quyen);
        }).orElseThrow(() -> new RuntimeException("Quyền không tồn tại"));
    }

    @Override
    public void deleteQuyen(Integer id) {
        quyenRepository.deleteById(id);
    }
}
