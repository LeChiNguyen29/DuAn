import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Footer from "./components/Footer";

import Header from "./components/Header";
import TrangChu from "./pages/TrangChu";
import GioHang from "./pages/GioHang";
import DangKy from "./pages/DangKy";
import DagnNhap from "./pages/DangNhap";
import DoiMatKhau from "./pages/DoiMatKhau";
import SanPham from "./pages/SanPham";
import QuenMatKhau from "./pages/QuenMatKhau";
import TimKiem from "./pages/TimKiem";

function AppRoutes() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<TrangChu />} />
        <Route path="/gio-hang" element={<GioHang />} />
        <Route path="/dang-ky" element={<DangKy />} />
        <Route path="/dang-nhap" element={<DagnNhap />} />
        <Route path="/doi-mat-khau" element={<DoiMatKhau />} />
        <Route path="/quen-mat-khau" element={<QuenMatKhau />} />
        <Route path="/tim-kiem" element={<TimKiem />} />
        <Route path="/san-pham/:id" element={<SanPham />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default AppRoutes;
