-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3308
-- Generation Time: Dec 18, 2024 at 03:18 PM
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
-- Database: `ojek_pangkalan`
--

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id_driver` int(11) NOT NULL,
  `nama_driver` varchar(100) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `kendaraan` varchar(50) DEFAULT NULL,
  `plat_nomor` varchar(20) DEFAULT NULL,
  `tarif` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id_driver`, `nama_driver`, `no_hp`, `kendaraan`, `plat_nomor`, `tarif`) VALUES
(1, 'Sari', '081234567890', 'Fazzio', 'DA 1234 AU', 25000.00),
(4, 'Firman', '082135652640', 'Scoopy', 'DA 6261 UA', 10000.00),
(6, 'Reno', '081234567891', 'Vario', 'DA 2345 BBS', 15000.00),
(7, 'Hilman', '08123454321234', 'N-Max', 'KT 5432 IA', 20000.00),
(9, 'Adit', '081234567891', 'Mio', 'KT 2345 UY', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `orderan`
--

CREATE TABLE `orderan` (
  `id_order` int(11) NOT NULL,
  `id_pengguna` int(11) NOT NULL,
  `id_driver` int(11) NOT NULL,
  `lokasi_awal` varchar(255) NOT NULL,
  `lokasi_tujuan` varchar(255) NOT NULL,
  `status` enum('Proses','Selesai','Dibatalkan') DEFAULT 'Proses',
  `waktu_pesan` time DEFAULT NULL,
  `tanggal_pesan` date DEFAULT NULL,
  `tarif` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderan`
--

INSERT INTO `orderan` (`id_order`, `id_pengguna`, `id_driver`, `lokasi_awal`, `lokasi_tujuan`, `status`, `waktu_pesan`, `tanggal_pesan`, `tarif`) VALUES
(13, 1, 1, 'Kayu Tangi', 'Belitung', 'Selesai', '02:29:28', '2024-12-18', 20000.00),
(15, 10, 1, 'Kidaung Permai', 'Pasar lama', 'Selesai', '03:29:56', '2024-12-18', 25000.00),
(19, 1, 4, 'Kidaung Permai', 'Pasar Lama', 'Proses', '15:07:32', '2024-12-18', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `no_pembayaran` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `metode_pembayaran` enum('Tunai','Transfer','E-Wallet') NOT NULL,
  `total_bayar` decimal(10,2) DEFAULT NULL,
  `tanggal_pembayaran` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`no_pembayaran`, `id_order`, `metode_pembayaran`, `total_bayar`, `tanggal_pembayaran`) VALUES
(4, 13, 'Tunai', 25000.00, '2024-12-11'),
(5, 15, 'Tunai', 25000.00, '2024-12-18'),
(8, 13, 'Tunai', 25000.00, '2024-12-18'),
(9, 15, 'Tunai', 10000.00, '2024-12-18'),
(10, 13, 'E-Wallet', 25000.00, '2024-12-18'),
(12, 13, 'Tunai', 20000.00, '2024-12-18'),
(13, 13, 'E-Wallet', 20000.00, '2024-12-18'),
(14, 13, 'Transfer', 20000.00, '2024-12-18');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `nama_pengguna` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `nama_pengguna`, `email`, `no_hp`, `alamat`) VALUES
(1, 'Indah', 'indah@gmail', '082135652640', 'Pangeran'),
(3, 'Yulia', 'yulia@gmail', '0878765432', 'Cendana 2B'),
(7, 'Indri', 'indri@gmail', '081234567823', 'Kayu Tangi 2'),
(8, 'Rani', 'rani@gmail', '082346789345', 'Belitung'),
(9, 'Lidya', 'lidya@gmail', '081234567853', 'Sei Andai'),
(10, 'Raudah', 'raudah@gmail', '082156743578', 'Pasar Lama'),
(11, 'Ersa', 'ersa@gmail', '081234567892', 'kuin cerucuk');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id_driver`);

--
-- Indexes for table `orderan`
--
ALTER TABLE `orderan`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_pengguna` (`id_pengguna`),
  ADD KEY `id_driver` (`id_driver`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`no_pembayaran`),
  ADD KEY `id_order` (`id_order`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `id_driver` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `orderan`
--
ALTER TABLE `orderan`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `no_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderan`
--
ALTER TABLE `orderan`
  ADD CONSTRAINT `orderan_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`) ON DELETE CASCADE,
  ADD CONSTRAINT `orderan_ibfk_2` FOREIGN KEY (`id_driver`) REFERENCES `driver` (`id_driver`) ON DELETE CASCADE;

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `orderan` (`id_order`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
