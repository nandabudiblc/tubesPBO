-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2015 at 08:38 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `travel`
--

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `id_member` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `no_ktp` varchar(30) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `privilege` enum('Member','Customer') NOT NULL,
  PRIMARY KEY (`id_member`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_member`, `nama`, `alamat`, `no_ktp`, `no_hp`, `username`, `password`, `privilege`) VALUES
(1, 'Nanda', 'Budi', '38394839489', '09238298392', 'nanda', 'nanda', 'Member'),
(4, 'budi', 'malang', 'asas', 'ada', 'ada', '859a37720c27b9f70e11b79bab9318fe', 'Member'),
(6, 'yoga', 'Jalan Danau Ranau G5 E 31 Malang', '332323', '0912121', 'yoga', '807659cd883fc0a63f6ce615893b3558', 'Member'),
(9, 'noda', 'noda', 'noda', 'noda', 'noda', '745a1bf2a514676bfc0ab775521486bc', 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `paketwisata`
--

CREATE TABLE IF NOT EXISTS `paketwisata` (
  `id_paketwisata` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `batas_peserta` int(11) NOT NULL,
  `harga` double NOT NULL,
  `id_tempatwisata` int(11) NOT NULL,
  `jumlah_paket` int(11) NOT NULL,
  `lama_hari` int(11) NOT NULL,
  `fasilitas` text NOT NULL,
  PRIMARY KEY (`id_paketwisata`),
  KEY `id_tempatwisata` (`id_tempatwisata`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `paketwisata`
--

INSERT INTO `paketwisata` (`id_paketwisata`, `nama`, `batas_peserta`, `harga`, `id_tempatwisata`, `jumlah_paket`, `lama_hari`, `fasilitas`) VALUES
(1, 'luxury', 10, 500000, 1, 5, 3, '-makan 3x sehari\r\n-penginapan luxury');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `id_petugas` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `no_ktp` varchar(30) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `privilege` enum('Admin','Petugas') NOT NULL,
  `tempat_lahir` varchar(150) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `gaji` int(11) NOT NULL,
  PRIMARY KEY (`id_petugas`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama`, `alamat`, `no_ktp`, `no_hp`, `username`, `password`, `privilege`, `tempat_lahir`, `tanggal_lahir`, `gaji`) VALUES
(1, 'asro\r\nmiladi', 'bandung', '1202323012950001', '0829893983', 'asroo', 'c56eb06de09c99e681f8fd9db937aa6d', 'Admin', 'Malang\r\n', '1993-10-02', 0),
(2, 'nanda', 'Malang', '5222', '091', 'nanda', '859a37720c27b9f70e11b79bab9318fe', 'Admin', 'Malang', '2003-10-03', 1000010);

-- --------------------------------------------------------

--
-- Table structure for table `tempatwisata`
--

CREATE TABLE IF NOT EXISTS `tempatwisata` (
  `id_tempatwisata` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `lokasi` varchar(200) NOT NULL,
  `deskripsi` varchar(200) NOT NULL,
  `latlong` varchar(30) NOT NULL,
  PRIMARY KEY (`id_tempatwisata`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tempatwisata`
--

INSERT INTO `tempatwisata` (`id_tempatwisata`, `nama`, `lokasi`, `deskripsi`, `latlong`) VALUES
(1, 'gunung tangkuban per', 'bandu', 'gunung aktif di daerah Lembang jawa bar', '-6.9739024,107.627451'),
(3, 'BNS', 'Jalan Segoro No 1 Malang', 'BNS adalah wisata yang ada di Batu dan\nbuka pada malam hari', '1098');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_petugas` int(11) NOT NULL,
  `id_member` int(11) NOT NULL,
  `id_paketwisata` int(11) NOT NULL,
  `jenis_pesan` enum('perorangan','kelompok') NOT NULL,
  `jumlah_kelompok` int(11) DEFAULT NULL,
  `jumlah_orang` int(11) DEFAULT NULL,
  `status` enum('jadi','batal') NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `id_person` (`id_petugas`),
  KEY `id_member` (`id_member`),
  KEY `id_paketwisata` (`id_paketwisata`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_petugas`, `id_member`, `id_paketwisata`, `jenis_pesan`, `jumlah_kelompok`, `jumlah_orang`, `status`, `tanggal`) VALUES
(1, 1, 4, 1, 'kelompok', 2, 5, 'jadi', '2015-04-10');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `paketwisata`
--
ALTER TABLE `paketwisata`
  ADD CONSTRAINT `paketwisata_ibfk_1` FOREIGN KEY (`id_tempatwisata`) REFERENCES `tempatwisata` (`id_tempatwisata`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_member`) REFERENCES `member` (`id_member`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`id_paketwisata`) REFERENCES `paketwisata` (`id_paketwisata`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
