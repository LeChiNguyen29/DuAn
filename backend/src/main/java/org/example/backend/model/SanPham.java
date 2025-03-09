package org.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_san_pham")
    private Integer id;

    @Column(name = "ten_san_pham", nullable = false)
    private String tenSanPham;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia", nullable = false)
    private Double gia;

    @Column(name = "so_luong", nullable = false)
    private Integer soLuong;

    @Column(name = "anh_san_pham")
    private String anhSanPham;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao")
    private Date ngayTao = new Date();

    @ManyToOne
    @JoinColumn(name = "ma_danh_muc", nullable = true)
    private DanhMuc danhMuc;
}
