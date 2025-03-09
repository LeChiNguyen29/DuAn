import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import SanPhamService from "../services/SanPhamService";
import GioHangService from "../services/GioHangService";

function SanPham() {

    const { id } = useParams();
    const [sanPham, setSanPham] = useState({});
    const [soLuong, setSoLuong] = useState(1);
    const [gioHang, setGioHang] = useState([]);

    const addToCart = (sanPhamSelected) => {
        
        const sanPhamTrongGio = gioHang.find((item) => item.id === sanPhamSelected.id);

        if (sanPhamTrongGio) {
            
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






    const handleChange = (e) => {
        const newValue = Math.max(1, Math.min(sanPham.soLuong, e.target.value)); // Giới hạn giá trị
        setSoLuong(newValue);
    };

    const divStyle = {
        display: 'flex',
        justifyContent: 'center'
    }

    useEffect(() => {
        SanPhamService.getById(id) // Gọi API để lấy chi tiết sản phẩm
            .then(response => {
                setSanPham(response.data)
            })
            .catch(error => console.error("Lỗi khi lấy dữ liệu:", error));
    }, [id]);

    return (
        <>
            <div className="container py-5">
                <div className="row">
                    <div className="col-md-6" style={divStyle}>
                        <img
                            src={`http://localhost:8080/images/${sanPham.anhSanPham || '/images/banner1.webp'}`}
                            alt={`${sanPham.moTa || 'Mô tả sản phẩm'}`}
                            className="img-fluid rounded shadow"
                        />
                    </div>
                    <div className="col-md-6">
                        <h2 className="fw-bold">{sanPham.tenSanPham}</h2>
                        <p className="text-muted">Mã sản phẩm: {sanPham.id}</p>
                        <h4 className="text-danger">{new Intl.NumberFormat('vi-VN').format(sanPham.gia)} VNĐ</h4>
                        <p>{sanPham.moTa}</p>
                        <label htmlFor="soLuong" className="form-label">Số lượng:</label>
                        <input type="number" id="soLuong" className="form-control w-25" value={`${soLuong}`} min="1" max={sanPham.soLuong} onChange={handleChange} />
                        <div>
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

                <h3 className="mt-5">Sản Phẩm Liên Quan</h3>
                <div className="row">
                    <div className="col-md-3">
                        <div className="card">
                            <img src="Screenshot 2025-02-18 223359.png" className="card-img-top" alt="Hoa 1" />
                            <div className="card-body">
                                <h5 className="card-title">Hoa Hồng Tươi</h5>
                                <p className="text-danger">500.000đ</p>
                                <button className="btn btn-primary w-100">Xem Chi Tiết</button>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="card">
                            <img src="Screenshot 2025-02-18 223359.png" className="card-img-top" alt="Hoa 2" />
                            <div className="card-body">
                                <h5 className="card-title">Hoa Ly Trắng</h5>
                                <p className="text-danger">600.000đ</p>
                                <button className="btn btn-primary w-100">Xem Chi Tiết</button>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="card">
                            <img src="Screenshot 2025-02-18 223359.png" className="card-img-top" alt="Hoa 3" />
                            <div className="card-body">
                                <h5 className="card-title">Hoa Hướng Dương</h5>
                                <p className="text-danger">450.000đ</p>
                                <button className="btn btn-primary w-100">Xem Chi Tiết</button>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="card">
                            <img src="Screenshot 2025-02-18 223359.png" className="card-img-top" alt="Hoa 4" />
                            <div className="card-body">
                                <h5 className="card-title">Hoa Cúc Họa Mi</h5>
                                <p className="text-danger">400.000đ</p>
                                <button className="btn btn-primary w-100">Xem Chi Tiết</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default SanPham

