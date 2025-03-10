import React from "react";
import { Link } from "react-router-dom";
import ConfirmButton from "../components/ConfirmButton";

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
                                <ConfirmButton 
                                    name={'Tiếp tục'} 
                                    message={'Vui lòng kiểm tra email và làm theo hướng dẫn.'} 
                                    link={'/dang-nhap'}
                                    btn={'btn btn-danger w-100'}    
                                />
                            </form>
                            <p><Link to="/dang-nhap">Quay lại</Link></p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default QuenMatKhau

