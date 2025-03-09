package org.example.backend.repository;

import org.example.backend.model.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuyenRepository extends JpaRepository<Quyen, Integer> {
    Optional<Quyen> findByTenQuyen(String tenQuyen);
}
