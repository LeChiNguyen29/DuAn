package org.example.backend.controller;

import org.example.backend.model.ChiTietDonHang;
import org.example.backend.service.ChiTietDonHangService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chi-tiet-don-hang")
@CrossOrigin(origins = "http://localhost:3000")
public class ChiTietDonHangController {
    private final ChiTietDonHangService chiTietDonHangService;

    public ChiTietDonHangController(ChiTietDonHangService chiTietDonHangService) {
        this.chiTietDonHangService = chiTietDonHangService;
    }

    @GetMapping
    public List<ChiTietDonHang> getAllChiTietDonHang() {
        return chiTietDonHangService.getAllChiTietDonHang();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiTietDonHang> getChiTietDonHangById(@PathVariable Integer id) {
        Optional<ChiTietDonHang> chiTiet = chiTietDonHangService.getChiTietDonHangById(id);
        return chiTiet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChiTietDonHang createChiTietDonHang(@RequestBody ChiTietDonHang chiTietDonHang) {
        return chiTietDonHangService.createChiTietDonHang(chiTietDonHang);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiTietDonHang> updateChiTietDonHang(@PathVariable Integer id, @RequestBody ChiTietDonHang chiTietDonHang) {
        ChiTietDonHang updated = chiTietDonHangService.updateChiTietDonHang(id, chiTietDonHang);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChiTietDonHang(@PathVariable Integer id) {
        chiTietDonHangService.deleteChiTietDonHang(id);
        return ResponseEntity.noContent().build();
    }
}
