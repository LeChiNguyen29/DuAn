import React from "react";

function DoiMatKhau() {
    return (
        <>
            <div className="container py-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <div className="card shadow-sm p-4">
                            <h2 className="text-center fw-bold">Đổi Mật Khẩu</h2>
                            <form id="changePasswordForm">
                                <div className="mb-3">
                                    <label htmlFor="email" className="form-label">Email</label>
                                    <input type="email" className="form-control" id="email" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="currentPassword" className="form-label">Mật khẩu hiện tại</label>
                                    <input type="password" className="form-control" id="currentPassword" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="newPassword" className="form-label">Mật khẩu mới</label>
                                    <input type="password" className="form-control" id="newPassword" />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="confirmPassword" className="form-label">Xác nhận mật khẩu mới</label>
                                    <input type="password" className="form-control" id="confirmPassword" />
                                </div>
                                <button type="submit" className="btn btn-danger w-100">Cập Nhật Mật Khẩu</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default DoiMatKhau

