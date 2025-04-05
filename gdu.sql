-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2025 at 05:17 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gdu`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`id`, `username`, `authority`) VALUES
(1, 'hung', 'ROLE_ADMIN'),
(2, 'hung', 'ROLE_MANAGER'),
(3, 'hung', 'ROLE_STUDENT'),
(4, 'tru', 'ROLE_STUDENT'),
(5, 'truong', 'ROLE_MANAGER'),
(6, 'truong', 'ROLE_STUDENT');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name_company` varchar(255) NOT NULL,
  `street_address` varchar(255) NOT NULL,
  `city` varchar(50) NOT NULL,
  `region` varchar(20) NOT NULL,
  `post_code` char(5) NOT NULL,
  `country` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name_company`, `street_address`, `city`, `region`, `post_code`, `country`) VALUES
(1, 'Nguyễn Văn A', '123 Đường A', 'Hà Nội', 'Miền Bắc', '10000', 'Việt Nam'),
(2, 'Trần Thị B', '456 Đường B', 'TP.HCM', 'Miền Nam', '70000', 'Việt Nam'),
(3, 'Lê Văn C', '789 Đường C', 'Đà Nẵng', 'Miền Trung', '55000', 'Việt Nam'),
(4, 'Phạm Thị D', '101 Đường D', 'Hải Phòng', 'Miền Bắc', '18000', 'Việt Nam'),
(5, 'Hoàng Văn E', '202 Đường E', 'Cần Thơ', 'Miền Tây', '90000', 'Việt Nam'),
(15, 'van', '123 thd', 'Ho Chi Minh', 'Vietnam', '123vn', 'VietNam'),
(16, 'e1T', '123 thd', 'Ha Noi', 'Vie', 'E1TVN', 'Vietnam'),
(20, 'VNG', '12 VNG', 'HCM', 'VietNam', '12VNG', 'Vietnam'),
(21, 'eIT', '123 thd', 'Ha Noi', 'Viet Nam', '123IT', 'Vietnam'),
(23, 'AWS', '12 Silicon Valley', 'Texas', 'Viet Nam', 'AWS35', 'USA'),
(25, 'ShopCom', 'Phan Van Tri', 'Ho Chi Minh', 'Viet Nam', 'E1TSC', 'Vietnam'),
(26, 'Nguyen Van A', '123 Duong A', 'Ha Noi', 'VietNam', '101vA', 'Vietnam');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `email`) VALUES
(1, 'Leslie', 'Andrews', 'leslie@luv2code.com'),
(2, 'Emma', 'Baumgarten', 'emma@luv2code.com'),
(3, 'Avani', 'Gupta', 'avani@luv2code.com'),
(4, 'Yuri', 'Petrov', 'yuri@luv2code.com'),
(5, 'Juan', 'Vega', 'juan@luv2code.com');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `image_url` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `description`, `price`, `image_url`) VALUES
(1, 'Peanut Butter', 'Bơ đậu phộng béo ngậy với hương vị tuyệt hảo', 45.00, 'https://food.fnr.sndimg.com/content/dam/images/food/fullset/2007/10/15/0/EA1112_Peanut_Butter.jpg.rend.hgtvcom.1280.1280.suffix/1382375731291.webp'),
(2, 'Pumpkin Pie', 'Bánh bí ngô truyền thống thơm ngon', 35.00, 'https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/e54fa10d818b5a75debc944b79bc6e7e/Derivates/eccbf500e6e1e8f9dc4a69adf311500746fa593d.jpg'),
(3, 'Jambalaya', 'Món ăn cay nóng kiểu New Orleans', 50.00, 'https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/e0c688bb1afa8f4b7e6912bca2c3b3fc/Derivates/a72cefbf839e118d5f4ef36f15a1b06d6b7e1720.jpg'),
(4, 'Pizza', 'Delicious Italy Pizza', 9.99, 'https://daylambanh.edu.vn/wp-content/uploads/2024/04/cach-lam-banh-pizza.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `first_name`, `last_name`, `email`) VALUES
(14, 'Vu', 'Hoang\r\n', 'vuhoang@gmail.com'),
(20, 'Quynh', 'Lan', 'quynhlan@gmail.com'),
(21, 'Bao', 'Khoa', 'baokhoa@gmail.com'),
(22, 'abc', 'aaa', 'abc@gmail.com'),
(24, 'Le', 'Quoc Hung', 'lequochung123@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('hung', '$2a$12$9Ewqv90SvoNi0mkWDGiJoeainfM09OrgJ47a3cyO2Gpf8tinzJ0gK', 1),
('Lan', '$2a$10$KomfbYJKLQF4ZXTlwNzBT.yFXWk4eAe16gKNet75nK3CYa8d7rpL.', 1),
('tru', '$2a$12$11fmFFTG7x9wU2yIExaj3et31m.flPY8YeGMifD5zjbVw3hiIYoc2', 1),
('truong', '$2a$12$ROki/QX8tZD0rvbW72QOk.uxk7vOiU1uO8PtyUNWe4YeyV1M8uWNm', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
