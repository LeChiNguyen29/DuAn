package org.example.backend.service;

import org.example.backend.model.DanhMuc;
import java.util.List;
import java.util.Optional;

public interface DanhMucService {
    List<DanhMuc> getAllDanhMuc();
    Optional<DanhMuc> getDanhMucById(Integer id);
    DanhMuc createDanhMuc(DanhMuc danhMuc);
    DanhMuc updateDanhMuc(Integer id, DanhMuc danhMucDetails);
    void deleteDanhMuc(Integer id);
}
