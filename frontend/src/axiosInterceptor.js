// Cách sử dụng trong interceptor của Axios
import axios from 'axios';
import { showTokenExpiredToast } from './toast';

axios.interceptors.response.use(
  response => response,
  error => {
    if (error.response && error.response.status === 401) {
      showTokenExpiredToast(); // Hiển thị thông báo
      localStorage.removeItem('accessToken'); // Xóa token
      setTimeout(() => {
        window.location.href = '/login'; // Chuyển hướng về trang đăng nhập
      }, 5000);
    }
    return Promise.reject(error);
  }
);
