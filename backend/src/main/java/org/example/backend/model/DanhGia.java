package org.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "danh_gia")
public class DanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_danh_gia")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ma_nguoi_dung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham")
    private SanPham sanPham;

    @Column(name = "so_sao")
    private Integer soSao;

    @Column(name = "binh_luan")
    private String binhLuan;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao")
    private Date ngayTao = new Date();
}
