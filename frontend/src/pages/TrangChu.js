import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import SanPhamService from "../services/SanPhamService";
import GioHangService from "../services/GioHangService";

function TrangChu() {
    const [listSanPham, setListSanPham] = useState([]);
    const [gioHang, setGioHang] = useState([]);

    const addToCart = (sanPhamSelected) => {

        if (sanPhamSelected) {
            
            // Neu san pham da ton tai thi + 1
        } else {
            const cartData = {
                nguoiDung: {
                    "id": 1,
                    "tenDangNhap": "admin",
                    "matKhau": "123456",
                    "email": "admin@shop.com",
                    "soDienThoai": "0123456789",
                    "diaChi": "Ha Noi",
                    "ngayTao": "2025-03-08T14:58:08.347+00:00"
                },
                sanPham: sanPhamSelected,
                soLuong: 1
            };
            GioHangService.create(cartData)
                .then(response => {
                    setGioHang(response.data)
                    console.log("Thêm sản phẩm vào giỏ hàng thành công", response.data);
                })
                .catch(error => {
                    console.error("Lỗi khi thêm sản phẩm vào giỏ hàng:", error);
                });
        }
    };

    useEffect(() => {
        SanPhamService.getAll()
            .then((response) => setListSanPham(response.data))
            .catch((error) => console.error("Lỗi khi lấy dữ liệu:", error));
    }, []);

    return (
        <>
            <div id="carouselExampleControls" className="carousel slide" data-bs-ride="carousel">
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <img
                            src={`/images/banner1.webp`}
                            className="d-block w-100"
                            alt="Banner 1"
                        />
                    </div>
                    <div className="carousel-item">
                        <img
                            src={`/images/banner2.webp`}
                            className="d-block w-100"
                            alt="Banner 2"
                        />
                    </div>
                    <div className="carousel-item">
                        <img
                            src={`/images/banner3.webp`}
                            className="d-block w-100"
                            alt="Banner 3"
                        />
                    </div>
                </div>
                <button
                    className="carousel-control-prev"
                    type="button"
                    data-bs-target="#carouselExampleControls"
                    data-bs-slide="prev"
                >
                    <span
                        className="carousel-control-prev-icon"
                        aria-hidden="true"
                    ></span>
                </button>
                <button
                    className="carousel-control-next"
                    type="button"
                    data-bs-target="#carouselExampleControls"
                    data-bs-slide="next"
                >
                    <span
                        className="carousel-control-next-icon"
                        aria-hidden="true"
                    ></span>
                </button>
            </div>

            <section className="container py-5">
                <h2 className="text-center fw-bold mb-4">Sản Phẩm Nổi Bật</h2>
                <div className="row">
                    {listSanPham.map((sanPham) => (
                        <div className="col-md-3" key={sanPham.id}>
                            <div
                                className="card text-center shadow-sm"
                                style={{ cursor: "pointer" }}
                                onClick={() => window.location.href = `/san-pham/${sanPham.id}`}
                            >
                                <img
                                    src={`http://localhost:8080/images/${sanPham.anhSanPham}`}
                                    alt={sanPham.tenSanPham}
                                    className="card-img-top"
                                />
                                <div className="card-body">
                                    <h5 className="card-title">{sanPham.tenSanPham}</h5>
                                    <p className="text-danger fw-bold">{sanPham.gia ? sanPham.gia.toLocaleString() : 'Liên hệ'} VNĐ</p>
                                    <div
                                        className="div-sp"
                                        onClick={(e) => e.stopPropagation()}
                                    >
                                        <Link
                                            className="btn btn-danger"
                                            to={`/san-pham/${sanPham.id}`}
                                            aria-label={`Đặt hàng ${sanPham.tenSanPham}`}
                                        >
                                            Đặt Hàng
                                        </Link>
                                        <button
                                            className="btn btn-success"
                                            onClick={() => addToCart(sanPham)}
                                            aria-label={`Thêm ${sanPham.tenSanPham} vào giỏ hàng`}
                                        >
                                            Thêm vào Giỏ Hàng
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </section>
        </>
    );
}

export default TrangChu;
