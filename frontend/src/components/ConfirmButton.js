import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast, ToastContainer, Slide } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const ConfirmButton = ({ name, message, link, btn}) => {
  const navigate = useNavigate(); // Hook điều hướng

  const handleClick = (e) => {
    e.preventDefault();

    toast.info(message, {
      position: "top-right",
      autoClose: 2000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      theme: "light",
      style: { border: "2px solid pink" },
      transition: Slide,
    });

    setTimeout(() => {
      navigate(link); // Truyền dữ liệu vào navigate
    }, 2100);
  };

  return (
    <>
      <Link className={btn} onClick={handleClick}>
        {name}
      </Link>
      <ToastContainer />
    </>
  );
};

export default ConfirmButton;
