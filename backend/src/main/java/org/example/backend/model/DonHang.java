package org.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ma_nguoi_dung")
    private NguoiDung nguoiDung;

    @Column(name = "tong_tien", nullable = false)
    private Double tongTien;

    @Column(name = "trang_thai")
    private String trangThai = "Chờ xử lý";

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao")
    private Date ngayTao = new Date();
}
