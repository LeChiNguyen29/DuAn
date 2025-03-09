package org.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "quyen")
public class Quyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_quyen")
    private Integer id;

    @Column(name = "ten_quyen", unique = true, nullable = false)
    private String tenQuyen;
}
