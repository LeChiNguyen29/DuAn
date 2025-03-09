package org.example.backend.service;

import org.example.backend.model.NguoiDungQuyen;

import java.util.List;

public interface NguoiDungQuyenService {
    List<NguoiDungQuyen> getQuyenByNguoiDungId(Integer nguoiDungId);
    NguoiDungQuyen assignQuyenToUser(Integer nguoiDungId, Integer quyenId);
    void removeQuyenFromUser(Integer id);
}
