package org.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chi_tiet_don_hang")
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_chi_tiet")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ma_don_hang")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham")
    private SanPham sanPham;

    @Column(name = "so_luong", nullable = false)
    private Integer soLuong;

    @Column(name = "gia", nullable = false)
    private Double gia;
}
