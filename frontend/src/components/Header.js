import React from "react";
import { Link } from "react-router-dom";

function Header () {
    return (
        <header>
            <nav className="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
                <div className="container">
                    <Link className="navbar-brand text-danger fw-bold" to="/">Technology.vn</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav ms-auto">
                        <li className="nav-item"><Link className="nav-link" to="/gio-hang">Giỏ Hàng</Link></li>
                            <li className="nav-item dropdown">
                                <a className="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Tài khoản</a>
                                <ul className="dropdown-menu">
                                    <li><Link className="dropdown-item" to="/dang-ky">Đăng ký</Link></li>
                                    <li><Link className="dropdown-item" to="/dang-nhap">Đăng nhập</Link></li>
                                </ul>
                            </li>
                        </ul>
                        <form className="d-flex ms-3">
                            <input className="form-control me-2" type="search" placeholder="Tìm kiếm..." aria-label="Search"/>
                            <Link className="btn btn-outline-danger" to={'/tim-kiem'}>Tìm</Link>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
    )
}

export default Header