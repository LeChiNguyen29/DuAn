package org.example.backend.controller;

import org.example.backend.model.GioHang;
import org.example.backend.service.GioHangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/gio-hang")
public class GioHangController {
    private final GioHangService gioHangService;

    public GioHangController(GioHangService gioHangService) {
        this.gioHangService = gioHangService;
    }

    @GetMapping
    public ResponseEntity<List<GioHang>> getAllGioHang() {
        return ResponseEntity.ok(gioHangService.getAllGioHang());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GioHang> getGioHangById(@PathVariable Integer id) {
        Optional<GioHang> gioHang = gioHangService.getGioHangById(id);
        return gioHang.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createGioHang(@RequestBody GioHang gioHang) {
        try {
            GioHang addedGioHang = gioHangService.addToGioHang(gioHang);
            return ResponseEntity.ok("Gio hang create successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GioHang> updateGioHang(@PathVariable Integer id, @RequestBody GioHang gioHang) {
        GioHang updated = gioHangService.updateGioHang(id, gioHang);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGioHang(@PathVariable Integer id) {
        gioHangService.removeFromGioHang(id);
        return ResponseEntity.noContent().build();
    }
}
