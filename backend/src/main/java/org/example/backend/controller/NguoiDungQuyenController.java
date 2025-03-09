package org.example.backend.controller;

import org.example.backend.model.NguoiDungQuyen;
import org.example.backend.service.NguoiDungQuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nguoi-dung-quyen")
@CrossOrigin(origins = "http://localhost:3000")
public class NguoiDungQuyenController {
    @Autowired
    private NguoiDungQuyenService nguoiDungQuyenService;

    @GetMapping("/{nguoiDungId}")
    public ResponseEntity<List<NguoiDungQuyen>> getQuyenByNguoiDung (@PathVariable Integer nguoiDungId) {
        return ResponseEntity.ok(nguoiDungQuyenService.getQuyenByNguoiDungId(nguoiDungId));
    }

    @PostMapping("/assign")
    public ResponseEntity<NguoiDungQuyen> assignQuyen (@RequestParam Integer nguoiDungId, @RequestParam Integer quyenId) {
        return ResponseEntity.ok(nguoiDungQuyenService.assignQuyenToUser(nguoiDungId, quyenId));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeQuyen(@PathVariable Integer id) {
        nguoiDungQuyenService.removeQuyenFromUser(id);
        return ResponseEntity.noContent().build();
    }
}
