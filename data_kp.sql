-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2019 at 04:34 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_kp`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen_koordinator`
--

CREATE TABLE `dosen_koordinator` (
  `NIP` int(20) NOT NULL,
  `Nama_Dosen` varchar(25) NOT NULL,
  `Password_Dosen` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen_koordinator`
--

INSERT INTO `dosen_koordinator` (`NIP`, `Nama_Dosen`, `Password_Dosen`) VALUES
(222222222, 'Hafiz Budi Firmansyah', 'hafiz11'),
(343434343, 'I Wayan Wiprayoga Wisesa', 'iwawiwi'),
(1111111111, 'Arkham', 'arkham');

-- --------------------------------------------------------

--
-- Table structure for table `dosen_pembimbing`
--

CREATE TABLE `dosen_pembimbing` (
  `NIP_Pem` int(18) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `No_Telp` int(13) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `formulir`
--

CREATE TABLE `formulir` (
  `NIM` int(10) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Alamat` varchar(30) NOT NULL,
  `Jenis_Kelamin` varchar(10) NOT NULL,
  `Angkatan` int(4) NOT NULL,
  `Nama_Instansi` varchar(30) NOT NULL,
  `Alamat_Instansi` varchar(30) NOT NULL,
  `Waktu_KP` varchar(25) NOT NULL,
  `Status_KP` varchar(10) DEFAULT NULL,
  `Dosen_Pembimbing` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formulir`
--

INSERT INTO `formulir` (`NIM`, `Nama`, `Alamat`, `Jenis_Kelamin`, `Angkatan`, `Nama_Instansi`, `Alamat_Instansi`, `Waktu_KP`, `Status_KP`, `Dosen_Pembimbing`) VALUES
(14116043, 'Agung Ajjah', 'Jl Hasan', 'Laki-Laki', 2016, 'PT KAI', 'Jakarta', '20 Juni-20 Juli 2019', 'Disetujui', 'Pak Indra'),
(14116053, 'Novry Andi', 'Jl Hasan', 'Laki-Laki', 2016, 'PT KAI', 'Jakarta', '20 Juni-20 Juli 2019', 'Disetujui', 'Pak Indra'),
(14116115, 'Helmud Panggabean', 'Jl Hasan', 'Laki-Laki', 2016, 'Ristekdikti', 'Jakarta', '20 Juni-20 Juli 2019', 'Disetujui', 'Pak Rajiv'),
(14116148, 'Alvijar Akbar Pahlevi', 'Jl Mujair no 10', 'Laki-Laki', 2016, 'Ombudsman', 'Jl Way Semangka', '27 Mei-27 Juli 2019', 'Disetujui', 'Pak Iqbal');

-- --------------------------------------------------------

--
-- Table structure for table `formulir_kp`
--

CREATE TABLE `formulir_kp` (
  `Id` int(10) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Host` int(4) NOT NULL,
  `Nama_Instansi` varchar(30) NOT NULL,
  `Alamat_Instansi` varchar(30) NOT NULL,
  `Waktu_KP` varchar(21) NOT NULL,
  `Status_KP` varchar(10) DEFAULT NULL,
  `Dosen_Pembimbing` varchar(30) DEFAULT NULL,
  `NIM` int(10) DEFAULT NULL,
  `NIP_Pem` int(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `NIM` int(10) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `Jenis_Kelamin` varchar(1) NOT NULL,
  `Angkatan` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`NIM`, `Nama`, `Password`, `Jenis_Kelamin`, `Angkatan`) VALUES
(14116000, 'Helmud Panggabean', 'helmud', 'L', 2016),
(14116053, 'Novry Andi', 'andi', 'L', 2016),
(14116148, 'Alvijar Akbar Pahlevi', 'alvijar', 'L', 2016);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen_koordinator`
--
ALTER TABLE `dosen_koordinator`
  ADD PRIMARY KEY (`NIP`);

--
-- Indexes for table `dosen_pembimbing`
--
ALTER TABLE `dosen_pembimbing`
  ADD PRIMARY KEY (`NIP_Pem`);

--
-- Indexes for table `formulir`
--
ALTER TABLE `formulir`
  ADD PRIMARY KEY (`NIM`);

--
-- Indexes for table `formulir_kp`
--
ALTER TABLE `formulir_kp`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `NIM` (`NIM`),
  ADD KEY `NIP` (`NIP_Pem`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`NIM`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dosen_koordinator`
--
ALTER TABLE `dosen_koordinator`
  MODIFY `NIP` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1111111112;

--
-- AUTO_INCREMENT for table `formulir`
--
ALTER TABLE `formulir`
  MODIFY `NIM` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14116149;

--
-- AUTO_INCREMENT for table `formulir_kp`
--
ALTER TABLE `formulir_kp`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `NIM` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14116149;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `formulir_kp`
--
ALTER TABLE `formulir_kp`
  ADD CONSTRAINT `formulir_kp_ibfk_1` FOREIGN KEY (`NIM`) REFERENCES `mahasiswa` (`NIM`),
  ADD CONSTRAINT `formulir_kp_ibfk_2` FOREIGN KEY (`NIP_Pem`) REFERENCES `dosen_koordinator` (`NIP`),
  ADD CONSTRAINT `formulir_kp_ibfk_3` FOREIGN KEY (`NIP_Pem`) REFERENCES `dosen_koordinator` (`NIP`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
