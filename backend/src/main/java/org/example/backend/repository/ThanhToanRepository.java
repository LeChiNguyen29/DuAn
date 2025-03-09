package org.example.backend.repository;

import org.example.backend.model.ThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThanhToanRepository extends JpaRepository<ThanhToan, Integer> {
    Optional<ThanhToan> findByDonHangId(Integer donHangId);
}
