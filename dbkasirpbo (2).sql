-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 23, 2024 at 12:28 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbkasirpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_table`
--

CREATE TABLE `admin_table` (
  `id` int NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin_table`
--

INSERT INTO `admin_table` (`id`, `Username`, `Password`) VALUES
(1, 'admin', 'admin01'),
(2, 'superadmin', 'admin303');

-- --------------------------------------------------------

--
-- Table structure for table `barang_table`
--

CREATE TABLE `barang_table` (
  `id` int NOT NULL,
  `Kode` varchar(50) NOT NULL,
  `Nama_barang` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Harga_barang` int NOT NULL,
  `Stok_barang` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `barang_table`
--

INSERT INTO `barang_table` (`id`, `Kode`, `Nama_barang`, `Harga_barang`, `Stok_barang`) VALUES
(1, 'AA001', 'Baju polos', 100, 35),
(2, 'AA002', 'Hoodie', 79, 10),
(3, 'AA003', 'Kaos', 50, 4),
(4, 'CC001', 'Celana Cargo', 125, 43),
(5, 'AA004', 'Sweater hitam', 350, 30),
(18, 'AA005', 'Varsity', 300, 10),
(20, 'CC002', 'Celana Jeans', 150, 11);

-- --------------------------------------------------------

--
-- Table structure for table `petugas_table`
--

CREATE TABLE `petugas_table` (
  `id` int NOT NULL,
  `Email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `petugas_table`
--

INSERT INTO `petugas_table` (`id`, `Email`, `Username`, `Password`) VALUES
(1, 'kasir01@gg.com', 'kasir1', 'qwerty'),
(2, 'kasir02@gg.com', 'kasir2', 'asdfgh'),
(3, 'kasir3@gg.com', 'kasir3', 'asdfgh'),
(4, 'Eva@gmail.com', 'Eva', 'Eva.'),
(5, 'test@gg', 'kasir5', 'qwerty'),
(6, 'test@gg.com', 'kasir16', 'szk'),
(7, 'zz@gg.com', 'kasir69', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_table`
--

CREATE TABLE `supplier_table` (
  `id` int NOT NULL,
  `Kode` varchar(55) NOT NULL,
  `Nama` varchar(60) NOT NULL,
  `Alamat` varchar(60) NOT NULL,
  `Kota` varchar(30) NOT NULL,
  `Provinsi` varchar(30) NOT NULL,
  `Telepon` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `KodePos` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `supplier_table`
--

INSERT INTO `supplier_table` (`id`, `Kode`, `Nama`, `Alamat`, `Kota`, `Provinsi`, `Telepon`, `Email`, `KodePos`) VALUES
(1, '001', 'Skibidi', 'Ohio no 69', 'Ohio', 'Ohio', '087567', 'Skibidi@rizz.com', 111),
(4, '002', 'Sigma', 'Ohio no. 420', 'Ohio', 'Ohio', '9678878', 'Sigma@rizz.com', 115),
(5, '003', 'Suppliermaxxing', 'Ngawi no 3', 'Ngawi', 'Jawa Timur', '45675678', 'Suppliermx@gg.com', 778),
(6, '004', 'Sppeed', 'Jln. Sigma no 420', 'Ngawi', 'Ohio', '6787890987', 'speed@gg.com', 9890),
(7, '005', 'Rafi RDR', 'Sokaraja', 'Purwokerto', 'Jawa tengah', '9876789', 'rafi@gg.com', 989);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_table`
--

CREATE TABLE `transaksi_table` (
  `id` int NOT NULL,
  `Barang` varchar(100) NOT NULL,
  `Jumlah_barang` varchar(100) NOT NULL,
  `Total` int NOT NULL,
  `waktu` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaksi_table`
--

INSERT INTO `transaksi_table` (`id`, `Barang`, `Jumlah_barang`, `Total`, `waktu`) VALUES
(1, 'Test', '3', 8300, '2024-09-14 11:52:08'),
(2, 'book', '2', 8300, '2024-09-14 11:52:08'),
(3, 'Pen', '1', 8300, '2024-09-14 11:52:08'),
(4, 'Baju polos', '3', 600, '2024-09-14 12:52:35'),
(5, 'Kaos', '6', 600, '2024-09-14 12:52:35'),
(6, 'Celana Cargo', '2', 1566, '2024-09-14 15:36:57'),
(7, 'Hoodie', '4', 1566, '2024-09-14 15:36:57'),
(8, 'Baju polos', '10', 1566, '2024-09-14 15:36:57'),
(9, 'Hoodie', '1', 415, '2024-09-17 03:27:09'),
(10, 'Kaos', '2', 415, '2024-09-17 03:27:09'),
(11, 'Sweater hitam', '1', 415, '2024-09-17 03:27:09'),
(12, 'Kaos', '2', 50, '2024-09-18 12:33:07'),
(13, 'Baju polos', '2', 50, '2024-09-18 12:33:07'),
(14, 'Baju polos', '2', 315, '2024-09-19 05:49:26'),
(15, 'Celana Cargo', '1', 315, '2024-09-19 05:49:26'),
(16, 'Baju polos', '1', 100, '2024-09-19 06:20:55'),
(17, 'Kaos', '2', 75, '2024-09-19 06:36:49'),
(18, 'Hoodie', '1', 129, '2024-09-19 07:18:58'),
(19, 'Kaos', '1', 129, '2024-09-19 07:18:58');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_table`
--
ALTER TABLE `admin_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `barang_table`
--
ALTER TABLE `barang_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `petugas_table`
--
ALTER TABLE `petugas_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier_table`
--
ALTER TABLE `supplier_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi_table`
--
ALTER TABLE `transaksi_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_table`
--
ALTER TABLE `admin_table`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `barang_table`
--
ALTER TABLE `barang_table`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `petugas_table`
--
ALTER TABLE `petugas_table`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `supplier_table`
--
ALTER TABLE `supplier_table`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `transaksi_table`
--
ALTER TABLE `transaksi_table`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
