package org.example.backend.controller;

import org.example.backend.model.NguoiDung;
import org.example.backend.service.NguoiDungService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nguoi-dung")
@CrossOrigin(origins = "http://localhost:3000")
public class NguoiDungController {
    private final NguoiDungService nguoiDungService;

    public NguoiDungController(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }

    @GetMapping
    public List<NguoiDung> getAllNguoiDung() {
        return nguoiDungService.getAllNguoiDung();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NguoiDung> getNguoiDungById(@PathVariable Integer id) {
        Optional<NguoiDung> nguoiDung = nguoiDungService.getNguoiDungById(id);
        return nguoiDung.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public NguoiDung createNguoiDung(@RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.createNguoiDung(nguoiDung);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NguoiDung> updateNguoiDung(@PathVariable Integer id, @RequestBody NguoiDung nguoiDung) {
        NguoiDung updated = nguoiDungService.updateNguoiDung(id, nguoiDung);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNguoiDung(@PathVariable Integer id) {
        nguoiDungService.deleteNguoiDung(id);
        return ResponseEntity.noContent().build();
    }
}
