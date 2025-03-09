package org.example.backend.controller;

import org.example.backend.model.DanhGia;
import org.example.backend.service.DanhGiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/danh-gia")
@CrossOrigin(origins = "http://localhost:3000")
public class DanhGiaController {
    private final DanhGiaService danhGiaService;

    public DanhGiaController(DanhGiaService danhGiaService) {
        this.danhGiaService = danhGiaService;
    }

    @GetMapping
    public List<DanhGia> getAllDanhGia() {
        return danhGiaService.getAllDanhGia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DanhGia> getDanhGiaById(@PathVariable Integer id) {
        Optional<DanhGia> danhGia = danhGiaService.getDanhGiaById(id);
        return danhGia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DanhGia createDanhGia(@RequestBody DanhGia danhGia) {
        return danhGiaService.createDanhGia(danhGia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DanhGia> updateDanhGia(@PathVariable Integer id, @RequestBody DanhGia danhGia) {
        DanhGia updated = danhGiaService.updateDanhGia(id, danhGia);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDanhGia(@PathVariable Integer id) {
        danhGiaService.deleteDanhGia(id);
        return ResponseEntity.noContent().build();
    }
}
