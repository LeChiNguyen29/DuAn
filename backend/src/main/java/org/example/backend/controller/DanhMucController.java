package org.example.backend.controller;

import org.example.backend.model.DanhMuc;
import org.example.backend.service.DanhMucService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/danh-muc")
@CrossOrigin(origins = "http://localhost:3000")
public class DanhMucController {
    private final DanhMucService danhMucService;

    public DanhMucController(DanhMucService danhMucService) {
        this.danhMucService = danhMucService;
    }

    @GetMapping
    public List<DanhMuc> getAllDanhMuc() {
        return danhMucService.getAllDanhMuc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DanhMuc> getDanhMucById(@PathVariable Integer id) {
        Optional<DanhMuc> danhMuc = danhMucService.getDanhMucById(id);
        return danhMuc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DanhMuc createDanhMuc(@RequestBody DanhMuc danhMuc) {
        return danhMucService.createDanhMuc(danhMuc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DanhMuc> updateDanhMuc(@PathVariable Integer id, @RequestBody DanhMuc danhMuc) {
        DanhMuc updated = danhMucService.updateDanhMuc(id, danhMuc);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDanhMuc(@PathVariable Integer id) {
        danhMucService.deleteDanhMuc(id);
        return ResponseEntity.noContent().build();
    }
}
