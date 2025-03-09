package org.example.backend.service.impl;

import org.example.backend.model.NguoiDung;
import org.example.backend.model.NguoiDungQuyen;
import org.example.backend.model.Quyen;
import org.example.backend.repository.NguoiDungQuyenRepository;
import org.example.backend.repository.NguoiDungRepository;
import org.example.backend.repository.QuyenRepository;
import org.example.backend.service.NguoiDungQuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiDungQuyenServiceImpl implements NguoiDungQuyenService {
    @Autowired
    private NguoiDungQuyenRepository nguoiDungQuyenRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private QuyenRepository quyenRepository;

    @Override
    public List<NguoiDungQuyen> getQuyenByNguoiDungId(Integer nguoiDungId) {
        return nguoiDungQuyenRepository.findByNguoiDung_Id(nguoiDungId);
    }

    @Override
    public NguoiDungQuyen assignQuyenToUser(Integer nguoiDungId, Integer quyenId) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(nguoiDungId)
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
        Quyen quyen = quyenRepository.findById(quyenId)
                .orElseThrow(() -> new RuntimeException("Quyền không tồn tại"));

        NguoiDungQuyen nguoiDungQuyen = new NguoiDungQuyen();
        nguoiDungQuyen.setNguoiDung(nguoiDung);
        nguoiDungQuyen.setQuyen(quyen);

        return nguoiDungQuyenRepository.save(nguoiDungQuyen);
    }

    @Override
    public void removeQuyenFromUser(Integer id) {
        nguoiDungQuyenRepository.deleteById(id);
    }
}
