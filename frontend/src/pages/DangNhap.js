import React from "react";
import { Link } from "react-router-dom";

function DagnNhap() {
    return (
        <>
            <div className="container py-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <div className="card shadow-sm p-4">
                            <h2 className="text-center fw-bold">Đăng Nhập</h2>
                            <form id="registerForm">
                                <div className="mb-3">
                                    <label htmlFor="email" className="form-label">Email</label>
                                    <input type="email" className="form-control" id="email" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="password" className="form-label">Mật Khẩu</label>
                                    <input type="password" className="form-control" id="password" />
                                </div>

                                <button type="submit" className="btn btn-danger w-100">Đăng Nhập</button>
                            </form>
                            <p>Bạn chưa có tài khoản? <Link to="/dang-ky">Đăng ký ngay</Link></p>
                            <p><Link to="/doi-mat-khau">Quên mật khẩu?</Link></p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default DagnNhap

