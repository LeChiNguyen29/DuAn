import React from "react";

function TimKiem() {
    return (
        <>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="#">Flower Shop</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ms-auto">
                            <li class="nav-item"><a class="nav-link" href="#">Trang chủ</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">Sản phẩm</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="container mt-4">
                <div class="row">
                    <div class="col-md-3">
                        <h4>Danh mục</h4>
                        <ul class="list-group">
                            <li class="list-group-item">Hoa Hồng</li>
                            <li class="list-group-item">Hoa Lan</li>
                            <li class="list-group-item">Hoa Cúc</li>
                        </ul>
                    </div>
                    <div class="col-md-9">
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Tìm kiếm hoa..."/>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-4">
                                <div class="card">
                                    <img src="https://via.placeholder.com/200" class="card-img-top" alt="Hoa Hồng Đỏ"/>
                                        <div class="card-body">
                                            <h5 class="card-title">Hoa Hồng Đỏ</h5>
                                            <p class="card-text">Giá: 200.000 VNĐ</p>
                                            <a href="#" class="btn btn-primary">Mua ngay</a>
                                        </div>
                                </div>
                            </div>
                            <div class="col-md-4 mb-4">
                                <div class="card">
                                    <img src="https://via.placeholder.com/200" class="card-img-top" alt="Hoa Hồng Trắng"/>
                                        <div class="card-body">
                                            <h5 class="card-title">Hoa Hồng Trắng</h5>
                                            <p class="card-text">Giá: 250.000 VNĐ</p>
                                            <a href="#" class="btn btn-primary">Mua ngay</a>
                                        </div>
                                </div>
                            </div>
                            <div class="col-md-4 mb-4">
                                <div class="card">
                                    <img src="https://via.placeholder.com/200" class="card-img-top" alt="Hoa Hồng Vàng"/>
                                        <div class="card-body">
                                            <h5 class="card-title">Hoa Hồng Vàng</h5>
                                            <p class="card-text">Giá: 220.000 VNĐ</p>
                                            <a href="#" class="btn btn-primary">Mua ngay</a>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </>
    )
}

export default TimKiem
