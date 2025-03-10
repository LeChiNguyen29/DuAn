import React from "react";
import { Link } from "react-router-dom";

function DangKy() {
    return (
        <>
            <div className="container py-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <div className="card shadow-sm p-4">
                            <h2 className="text-center fw-bold">Đăng Ký Tài Khoản</h2>
                            <form id="registerForm">
                                <div className="mb-3">
                                    <label htmlFor="fullName" className="form-label">Họ và Tên</label>
                                    <input type="text" className="form-control" id="fullName" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="email" className="form-label">Email</label>
                                    <input type="email" className="form-control" id="email" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="phone" className="form-label">Số điện thoại</label>
                                    <input type="text" className="form-control" id="phone" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="address" className="form-label">Địa chỉ</label>
                                    <input type="text" className="form-control" id="address" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="password" className="form-label">Mật khẩu</label>
                                    <input type="password" className="form-control" id="password" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="confirmPassword" className="form-label">Nhập lại mật khẩu</label>
                                    <input type="password" className="form-control" id="confirmPassword" />
                                </div>
                                <button type="submit" className="btn btn-danger w-100">Đăng Ký</button>
                            </form>
                            <p>Bạn đã có tài khoản? <Link to="/dang-nhap">Đăng nhập ngay</Link></p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default DangKy

