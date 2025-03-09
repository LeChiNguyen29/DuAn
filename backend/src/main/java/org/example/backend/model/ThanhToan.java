package org.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "thanh_toan")
public class ThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_thanh_toan")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "ma_don_hang")
    private DonHang donHang;

    @Column(name = "phuong_thuc", nullable = false)
    private String phuongThuc;

    @Column(name = "trang_thai")
    private String trangThai = "Chờ thanh toán";

    @Column(name = "ma_giao_dich")
    private String maGiaoDich;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao")
    private Date ngayTao = new Date();
}
