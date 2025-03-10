import React from "react";
import { Link } from "react-router-dom";

function QuenMatKhau() {
    return (
        <>
            <div className="container py-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <div className="card shadow-sm p-4">
                            <h2 className="text-center fw-bold">Quên Mật Khẩu</h2>
                            <form id="changePasswordForm">
                                <div className="mb-3">
                                    <label htmlFor="email" className="form-label">Email</label>
                                    <input type="email" className="form-control" id="email" />
                                </div>
                                <Link className="btn btn-danger w-100" to="/dang-nhap">Tiếp tục</Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default QuenMatKhau

