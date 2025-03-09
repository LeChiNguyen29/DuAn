package org.example.backend.controller;

import org.example.backend.model.ThanhToan;
import org.example.backend.service.ThanhToanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/thanh-toan")
@CrossOrigin(origins = "http://localhost:3000")
public class ThanhToanController {
    private final ThanhToanService thanhToanService;

    public ThanhToanController(ThanhToanService thanhToanService) {
        this.thanhToanService = thanhToanService;
    }

    @GetMapping
    public List<ThanhToan> getAllThanhToan() {
        return thanhToanService.getAllThanhToan();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThanhToan> getThanhToanById(@PathVariable Integer id) {
        Optional<ThanhToan> thanhToan = thanhToanService.getThanhToanById(id);
        return thanhToan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ThanhToan createThanhToan(@RequestBody ThanhToan thanhToan) {
        return thanhToanService.createThanhToan(thanhToan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThanhToan> updateThanhToan(@PathVariable Integer id, @RequestBody ThanhToan thanhToan) {
        ThanhToan updated = thanhToanService.updateThanhToan(id, thanhToan);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThanhToan(@PathVariable Integer id) {
        thanhToanService.deleteThanhToan(id);
        return ResponseEntity.noContent().build();
    }
}
