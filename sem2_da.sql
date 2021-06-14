-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 14, 2021 lúc 10:03 AM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `sem2_da`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `Name` varchar(50) NOT NULL,
  `Passwork` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Name`, `Passwork`) VALUES
('1', '1'),
('123', '123'),
('MjFang', '123'),
('phuong', '123'),
('phuong123', '123'),
('phuongphuong', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `score`
--

CREATE TABLE `score` (
  `ID` int(11) NOT NULL,
  `Score` int(11) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Times` time DEFAULT NULL,
  `Dates` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `score`
--

INSERT INTO `score` (`ID`, `Score`, `Name`, `Times`, `Dates`) VALUES
(2635, 99999, '1', '00:00:00', '2002-08-07'),
(2637, 20, NULL, '23:49:14', '2021-06-11'),
(2638, 24, NULL, '23:52:20', '2021-06-11'),
(2639, 2, NULL, '00:52:18', '2021-06-12'),
(2640, 80, '123', '00:56:02', '2021-06-12'),
(2641, 32, NULL, '01:06:29', '2021-06-12'),
(2643, 34, NULL, '10:44:23', '2021-06-12'),
(2644, 10, NULL, '12:09:41', '2021-06-12'),
(2645, 12, NULL, '12:52:30', '2021-06-12'),
(2646, 2, NULL, '12:53:32', '2021-06-12'),
(2647, 22, NULL, '12:59:40', '2021-06-12'),
(2648, 44, NULL, '00:08:16', '2021-06-13'),
(2649, 18, NULL, '13:35:15', '2021-06-14'),
(2652, 34, 'phuong123', '13:40:36', '2021-06-14'),
(2653, 18, 'phuongphuong', '14:16:10', '2021-06-14'),
(2654, 34, 'MjFang', '14:21:01', '2021-06-14'),
(2655, 12, 'phuong123', '14:32:54', '2021-06-14');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Name`);

--
-- Chỉ mục cho bảng `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_name` (`Name`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `score`
--
ALTER TABLE `score`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2656;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `fk_name` FOREIGN KEY (`Name`) REFERENCES `account` (`Name`) ON DELETE SET NULL ON UPDATE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
