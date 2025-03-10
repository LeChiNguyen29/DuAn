import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

// Cấu hình Toast
export const showTokenExpiredToast = () => {
  toast.error('Phiên đăng nhập đã hết hạn, vui lòng đăng nhập lại.', {
    position: 'top-right', // Hiển thị ở góc trên bên phải
    autoClose: 5000, // Biến mất sau 5 giây
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
    draggable: true,
    theme: 'light', // Nền trắng
    style: { border: '2px solid pink' }, // Viền hồng
    transition: toast.POSITION.TOP_RIGHT // Hiệu ứng slide
  });
};