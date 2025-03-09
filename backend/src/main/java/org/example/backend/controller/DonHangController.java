package org.example.backend.controller;

import org.example.backend.model.DonHang;
import org.example.backend.service.DonHangService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/don-hang")
@CrossOrigin(origins = "http://localhost:3000")
public class DonHangController {
    private final DonHangService donHangService;

    public DonHangController(DonHangService donHangService) {
        this.donHangService = donHangService;
    }

    @GetMapping
    public List<DonHang> getAllDonHang() {
        return donHangService.getAllDonHang();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonHang> getDonHangById(@PathVariable Integer id) {
        Optional<DonHang> donHang = donHangService.getDonHangById(id);
        return donHang.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DonHang createDonHang(@RequestBody DonHang donHang) {
        return donHangService.createDonHang(donHang);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonHang> updateDonHang(@PathVariable Integer id, @RequestBody DonHang donHang) {
        DonHang updatedDonHang = donHangService.updateDonHang(id, donHang);
        return updatedDonHang != null ? ResponseEntity.ok(updatedDonHang) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonHang(@PathVariable Integer id) {
        donHangService.deleteDonHang(id);
        return ResponseEntity.noContent().build();
    }
}
