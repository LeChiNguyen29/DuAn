package org.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "danh_muc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_danh_muc")
    private Integer id;

    @Column(name = "ten_danh_muc", nullable = false)
    private String tenDanhMuc;

    @Column(name = "mo_ta")
    private String moTa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao")
    private Date ngayTao = new Date();
}
