package org.example.backend.controller;

import org.example.backend.model.Quyen;
import org.example.backend.service.QuyenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quyen")
@CrossOrigin(origins = "http://localhost:3000")
public class QuyenController {
    private final QuyenService quyenService;

    public QuyenController(QuyenService quyenService) {
        this.quyenService = quyenService;
    }

    @GetMapping
    public List<Quyen> getAllQuyen() {
        return quyenService.getAllQuyen();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quyen> getQuyenById(@PathVariable Integer id) {
        Optional<Quyen> quyen = quyenService.getQuyenById(id);
        return quyen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quyen createQuyen(@RequestBody Quyen quyen) {
        return quyenService.createQuyen(quyen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quyen> updateQuyen(@PathVariable Integer id, @RequestBody Quyen quyen) {
        Quyen updated = quyenService.updateQuyen(id, quyen);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuyen(@PathVariable Integer id) {
        quyenService.deleteQuyen(id);
        return ResponseEntity.noContent().build();
    }
}
