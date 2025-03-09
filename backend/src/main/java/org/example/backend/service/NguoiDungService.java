package org.example.backend.service;

import org.example.backend.model.NguoiDung;
import java.util.List;
import java.util.Optional;

public interface NguoiDungService {
    List<NguoiDung> getAllNguoiDung();
    Optional<NguoiDung> getNguoiDungById(Integer id);
    NguoiDung createNguoiDung(NguoiDung nguoiDung);
    NguoiDung updateNguoiDung(Integer id, NguoiDung nguoiDungDetails);
    void deleteNguoiDung(Integer id);
}
