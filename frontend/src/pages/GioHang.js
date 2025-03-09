import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import GioHangService from "../services/GioHangService";
import SanPhamService from "../services/SanPhamService";

function GioHang() {

    const [gioHang, setGioHang] = useState([]);
    const [soLuong, setSoLuong] = useState(1);

    // Lấy giỏ hàng
    useEffect(() => {
        GioHangService.getAll()
            .then(response => setGioHang(response.data))
            .catch((error) => console.error("Lỗi khi lấy dữ liệu:", error));
    }, [])

    const handleQuantityChange = (e, id) => {
        const newQuantity = Math.max(1, e.target.value);  // Giới hạn số lượng tối thiểu là 1

        // Cập nhật lại số lượng trong giỏ hàng
        const updatedCart = gioHang.map(item =>
            item.sanPham.id === id ? { ...item, soLuong: newQuantity } : item
        );
        setGioHang(updatedCart);
    };

    // Lấy thông tin số lượng sản phẩm còn lại và gán giá trị tối đa
    const getMaxQuantity = (id) => {
        const sanPham = gioHang.find(item => item.sanPham.id === id);
        if (sanPham) {
            SanPhamService.getById(id)
                .then(response => {
                    const maxQuantity = response.data.soLuongCon;  // Số lượng còn lại trong cơ sở dữ liệu
                    // Cập nhật lại giỏ hàng với số lượng tối đa từ cơ sở dữ liệu
                    const updatedCart = gioHang.map(item =>
                        item.sanPham.id === id ? { ...item, maxQuantity: maxQuantity } : item
                    );
                    setGioHang(updatedCart);
                })
                .catch(error => console.error("Lỗi khi lấy dữ liệu sản phẩm:", error));
        }
    };

    const handleRemoveItem = (id) => {
        // Xóa sản phẩm khỏi giỏ hàng
        const updatedCart = gioHang.filter(item => item.sanPham.id !== id);
        setGioHang(updatedCart);
    };

    return (
        <div className="container py-5">
            <p className="h3">Giỏ Hàng</p>
            { !gioHang && <p>Giỏ hàng của bạn đang trống!</p> }
            <div className="row">
                <div id="content" className="col mt-5">
                    <div id="shopping-cart">
                        <div className="table-responsive">
                            <table className="table table-bordered">
                                <thead>
                                    <tr>
                                        <th className="text-center">Hình ảnh</th>
                                        <th className="text-start">Tên sản phẩm</th>
                                        <th className="text-start">Mã sản phẩm</th>
                                        <th className="text-start">Số lượng</th>
                                        <th className="text-end">Đơn giá</th>
                                        <th className="text-end">Tổng cộng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {gioHang.map((hang) => (
                                        <tr key={hang.sanPham.id}>
                                            <td className="text-center">
                                                <Link to={`/san-pham/${hang.sanPham.id}`}>
                                                    <img width="40px" height="40px" 
                                                         src={`http://localhost:8080/images/${hang.sanPham.anhSanPham}`} 
                                                         className="img-thumbnail" />
                                                </Link>
                                            </td>
                                            <td className="text-start text-wrap">
                                                <Link className="cart-item-name" to={`/san-pham/${hang.sanPham.id}`}>
                                                    {hang.sanPham.tenSanPham}
                                                </Link>
                                            </td>
                                            <td className="text-start">{hang.sanPham.id}</td>
                                            <td className="text-start">
                                                <div className="input-group">
                                                    <input 
                                                        type="number" 
                                                        className="form-control w-25" 
                                                        value={hang.soLuong} 
                                                        min="1" 
                                                        max={hang.maxQuantity || 10}  // Giới hạn số lượng theo cơ sở dữ liệu
                                                        onChange={(e) => handleQuantityChange(e, hang.sanPham.id)} 
                                                        onFocus={() => getMaxQuantity(hang.sanPham.id)} // Lấy số lượng tối đa khi người dùng focus vào input
                                                    />
                                                    <button 
                                                        type="button" 
                                                        className="btn btn-danger" 
                                                        onClick={() => handleRemoveItem(hang.sanPham.id)}
                                                    >
                                                        <i className="fa-solid fa-circle-xmark"> X</i>
                                                    </button>
                                                </div>
                                            </td>
                                            <td className="text-end">{hang.sanPham.gia.toLocaleString()} VND</td>
                                            <td className="text-end">
                                                {(hang.sanPham.gia * hang.soLuong).toLocaleString()} VND
                                            </td>
                                        </tr>
                                    ))}
                                </tbody>
                                <tfoot id="checkout-total">
                                    <tr>
                                        <td colSpan="5" className="text-end"><strong>Tổng cộng</strong></td>
                                        <td className="text-end">{gioHang.reduce((total, item) => total + (item.sanPham.gia * item.soLuong), 0).toLocaleString()} VND</td>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                    <div className="d-inline-block pt-2 w-100">
                        <div className="float-start">
                            <Link to="/" className="btn btn-light">Tiếp tục mua sắm</Link>
                        </div>
                        <div className="float-end">
                            <Link to="/" className="btn btn-primary">Thanh toán</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default GioHang;
