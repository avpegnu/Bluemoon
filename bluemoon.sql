-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bluemoon
CREATE DATABASE IF NOT EXISTS `bluemoon` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `bluemoon`;

-- Dumping structure for table bluemoon.dich_vu
CREATE TABLE IF NOT EXISTS `dich_vu` (
  `ma_dv` varchar(50) NOT NULL,
  `ma_hogd` varchar(50) NOT NULL,
  `thoi_gian` date NOT NULL,
  `xe_may` int(11) DEFAULT 0,
  `o_to` int(11) DEFAULT 0,
  `so_dien` int(11) DEFAULT 0,
  `so_nuoc` float DEFAULT 0,
  PRIMARY KEY (`ma_dv`),
  KEY `ma_hogd` (`ma_hogd`),
  CONSTRAINT `dich_vu_ibfk_1` FOREIGN KEY (`ma_hogd`) REFERENCES `ho_gia_dinh` (`ma_hogd`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bluemoon.dich_vu: ~54 rows (approximately)
INSERT INTO `dich_vu` (`ma_dv`, `ma_hogd`, `thoi_gian`, `xe_may`, `o_to`, `so_dien`, `so_nuoc`) VALUES
	('HO1DV0224', 'HO1', '2024-02-01', 2, 1, 120, 8),
	('HO1DV0324', 'HO1', '2024-03-01', 4, 2, 200, 31),
	('HO1DV0424', 'HO1', '2024-04-01', 4, 2, 250, 28),
	('HO1DV0524', 'HO1', '2024-05-01', 4, 2, 214, 36),
	('HO1DV0624', 'HO1', '2024-06-01', 4, 2, 240, 24),
	('HO1DV0724', 'HO1', '2024-07-01', 5, 2, 260, 26),
	('HO1DV0824', 'HO1', '2024-08-01', 4, 2, 192, 31),
	('HO1DV0924', 'HO1', '2024-09-01', 4, 2, 232, 28),
	('HO2DV0224', 'HO2', '2024-02-01', 3, 2, 192, 18),
	('HO2DV0324', 'HO2', '2024-03-01', 3, 2, 181, 26),
	('HO2DV0424', 'HO2', '2024-04-01', 3, 2, 202, 24),
	('HO2DV0524', 'HO2', '2024-05-01', 3, 2, 194, 19),
	('HO2DV0624', 'HO2', '2024-06-01', 4, 2, 192, 31),
	('HO2DV0724', 'HO2', '2024-07-01', 4, 2, 212, 28),
	('HO2DV0824', 'HO2', '2024-08-01', 4, 2, 201, 28),
	('HO2DV0924', 'HO2', '2024-09-01', 4, 2, 195, 28),
	('HO3DV0324', 'HO3', '2024-03-01', 2, 2, 192, 31),
	('HO3DV0424', 'HO3', '2024-04-01', 2, 2, 186, 25),
	('HO3DV0524', 'HO3', '2024-05-01', 2, 2, 167, 26),
	('HO3DV0624', 'HO3', '2024-06-01', 2, 2, 187, 27),
	('HO3DV0724', 'HO3', '2024-07-01', 2, 2, 197, 32),
	('HO3DV0824', 'HO3', '2024-08-01', 2, 2, 196, 36),
	('HO3DV0924', 'HO3', '2024-09-01', 2, 2, 205, 28),
	('HO4DV0224', 'HO4', '2024-02-01', 2, 2, 192, 31),
	('HO4DV0324', 'HO4', '2024-03-01', 2, 2, 192, 31),
	('HO4DV0424', 'HO4', '2024-04-01', 2, 2, 186, 25),
	('HO4DV0524', 'HO4', '2024-05-01', 2, 2, 167, 26),
	('HO4DV0624', 'HO4', '2024-06-01', 2, 2, 187, 27),
	('HO4DV0724', 'HO4', '2024-07-01', 2, 2, 197, 32),
	('HO4DV0824', 'HO4', '2024-08-01', 2, 2, 196, 36),
	('HO4DV0924', 'HO4', '2024-09-01', 2, 2, 205, 28),
	('HO5DV0224', 'HO5', '2024-02-01', 3, 1, 162, 31),
	('HO5DV0324', 'HO5', '2024-03-01', 3, 2, 172, 31),
	('HO5DV0424', 'HO5', '2024-04-01', 3, 2, 189, 25),
	('HO5DV0524', 'HO5', '2024-05-01', 3, 2, 197, 26),
	('HO5DV0624', 'HO5', '2024-06-01', 3, 2, 167, 27),
	('HO5DV0724', 'HO5', '2024-07-01', 3, 2, 207, 32),
	('HO5DV0824', 'HO5', '2024-08-01', 3, 2, 176, 36),
	('HO5DV0924', 'HO5', '2024-09-01', 3, 2, 205, 28),
	('HO6DV0324', 'HO6', '2024-03-01', 3, 2, 172, 31),
	('HO6DV0424', 'HO6', '2024-04-01', 3, 2, 189, 25),
	('HO6DV0524', 'HO6', '2024-05-01', 3, 2, 197, 26),
	('HO6DV0624', 'HO6', '2024-06-01', 3, 2, 167, 27),
	('HO6DV0724', 'HO6', '2024-07-01', 3, 2, 207, 32),
	('HO6DV0824', 'HO6', '2024-08-01', 3, 2, 176, 36),
	('HO6DV0924', 'HO6', '2024-09-01', 3, 2, 205, 28),
	('HO7DV0224', 'HO7', '2024-02-01', 3, 1, 162, 31),
	('HO7DV0324', 'HO7', '2024-03-01', 3, 2, 172, 31),
	('HO7DV0424', 'HO7', '2024-04-01', 3, 2, 189, 25),
	('HO7DV0524', 'HO7', '2024-05-01', 3, 2, 197, 26),
	('HO7DV0624', 'HO7', '2024-06-01', 3, 2, 167, 27),
	('HO7DV0724', 'HO7', '2024-07-01', 3, 2, 207, 32),
	('HO7DV0824', 'HO7', '2024-08-01', 3, 2, 176, 36),
	('HO7DV0924', 'HO7', '2024-09-01', 3, 2, 205, 28);

-- Dumping structure for table bluemoon.ho_gia_dinh
CREATE TABLE IF NOT EXISTS `ho_gia_dinh` (
  `ma_hogd` varchar(50) NOT NULL,
  `ten_hogd` varchar(255) NOT NULL,
  `dia_chi` varchar(255) NOT NULL,
  `dien_tich` int(11) NOT NULL,
  `ngay_thue` date NOT NULL,
  PRIMARY KEY (`ma_hogd`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bluemoon.ho_gia_dinh: ~8 rows (approximately)
INSERT INTO `ho_gia_dinh` (`ma_hogd`, `ten_hogd`, `dia_chi`, `dien_tich`, `ngay_thue`) VALUES
	('HO1', 'Gia Đình A', 'Căn Hộ P101', 120, '2024-01-07'),
	('HO2', 'Gia Đình B', 'Căn hộ P203', 50, '2024-01-26'),
	('HO3', 'Gia Đình C', 'Căn hộ P406', 40, '2024-02-02'),
	('HO4', 'Gia Đình D', 'Căn hộ P805', 80, '2024-01-26'),
	('HO5', 'Gia Đình E', 'Căn hộ P1802', 100, '2024-01-31'),
	('HO6', 'Gia Đình F', 'Căn Hộ P2206', 120, '2024-02-06'),
	('HO7', 'Gia Đình H', 'Căn Hộ P402', 130, '2024-01-04'),
	('HO8', 'Gia Đình G', 'Căn hộ P704', 100, '2024-01-20');

-- Dumping structure for table bluemoon.loai_phi
CREATE TABLE IF NOT EXISTS `loai_phi` (
  `ma_phi` varchar(50) NOT NULL,
  `ten_phi` varchar(50) NOT NULL,
  `tien_m2` int(11) DEFAULT 0,
  `tien_xe` int(11) DEFAULT 0,
  `tien_so` int(11) DEFAULT 0,
  `tien_tu_thien` int(11) DEFAULT 0,
  PRIMARY KEY (`ma_phi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bluemoon.loai_phi: ~8 rows (approximately)
INSERT INTO `loai_phi` (`ma_phi`, `ten_phi`, `tien_m2`, `tien_xe`, `tien_so`, `tien_tu_thien`) VALUES
	('DVCC', 'Dịch vụ chung cư', 10000, 0, 0, 0),
	('OT', 'Phí gửi ô tô', 0, 1200000, 0, 0),
	('QLCC', 'Quản lý chung cư', 7000, 0, 0, 0),
	('TD', 'Tiền điện', 0, 0, 3500, 0),
	('TM', 'Tiền internet', 0, 0, 100000, 0),
	('TN', 'Tiền nước', 0, 0, 30000, 0),
	('TT', 'Phí từ thiện', 0, 0, 0, 1),
	('XM', 'Phí gửi xe máy', 0, 70000, 0, 0);

-- Dumping structure for table bluemoon.nhan_khau
CREATE TABLE IF NOT EXISTS `nhan_khau` (
  `ma_nhan_khau` varchar(50) NOT NULL DEFAULT 'NULL',
  `so_cccd` varchar(50) DEFAULT NULL,
  `ma_hogd` varchar(50) NOT NULL,
  `ho_ten` varchar(50) NOT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL,
  `quan_he_chu_ho` varchar(50) DEFAULT NULL,
  `tam_tru` bit(1) NOT NULL,
  PRIMARY KEY (`ma_nhan_khau`) USING BTREE,
  KEY `ma_hogd` (`ma_hogd`) USING BTREE,
  CONSTRAINT `nhan_khau_ibfk_1` FOREIGN KEY (`ma_hogd`) REFERENCES `ho_gia_dinh` (`ma_hogd`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bluemoon.nhan_khau: ~21 rows (approximately)
INSERT INTO `nhan_khau` (`ma_nhan_khau`, `so_cccd`, `ma_hogd`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `quan_he_chu_ho`, `tam_tru`) VALUES
	('HO1TV1', '001204035885', 'HO1', 'Nguyễn Văn A', '2001-06-01', b'1', 'Chủ hộ', b'1'),
	('HO1TV2', '001304035123', 'HO1', 'Lê Phương Thảo', '2003-12-28', b'0', 'Vợ', b'1'),
	('HO1TV3', '', 'HO1', 'Nguyễn Thị Linh', '2023-06-09', b'0', 'Con gái', b'1'),
	('HO1TV4', '', 'HO1', 'Nguyễn Văn Nam', '2024-12-18', b'1', 'Con trai', b'1'),
	('HO1TV5', '030402002012', 'HO1', 'Nguyễn Văn Tam', '2002-12-01', b'1', 'Em trai', b'0'),
	('HO2TV1', '001204035886', 'HO2', 'Lê Văn B', '1998-12-31', b'0', 'Chủ hộ', b'1'),
	('HO2TV2', '001306023045', 'HO2', 'Trần Văn Anh', '1996-01-01', b'1', 'Chồng', b'1'),
	('HO2TV3', NULL, 'HO2', 'Trần Anh Sơn', '2019-12-30', b'1', 'Con trai', b'1'),
	('HO3TV1', '001204035887', 'HO3', 'Trần Văn C', '2002-11-09', b'1', 'Chủ hộ', b'1'),
	('HO3TV2', '001204022033', 'HO3', 'Trần Văn Thọ', '1999-12-26', b'1', 'Anh trai', b'1'),
	('HO4TV1', '001205035772', 'HO4', 'Đào Thị D', '1998-02-04', b'0', 'Chủ hộ', b'1'),
	('HO4TV2', '021102002041', 'HO4', 'Đào Văn Tuấn', '1973-12-30', b'1', 'Bố', b'1'),
	('HO4TV3', '010201022011', 'HO4', 'Bùi Thị Thơ', '1976-02-14', b'0', 'Mẹ', b'1'),
	('HO5TV1', '001305123123', 'HO5', 'Trịnh Văn E', '1992-10-23', b'1', 'Chủ hộ', b'1'),
	('HO5TV2', '001205022541', 'HO5', 'Lê Anh Đào', '1994-10-22', b'0', 'Vợ', b'1'),
	('HO5TV3', '', 'HO5', 'Trịnh Văn Chính', '2013-12-02', b'1', 'Con trai', b'1'),
	('HO5TV4', '001201010222', 'HO5', 'Trịnh Văn Thịnh', '1968-11-08', b'1', 'Bố', b'1'),
	('HO6TV1', '030376182812', 'HO6', 'Lê Tăng Đạt', '1975-05-01', b'1', 'Chủ hộ', b'1'),
	('HO6TV2', '020151823812', 'HO6', 'Nguyễn Xuân Bách', '2004-01-01', b'1', 'Con trai nuôi', b'1'),
	('HO6TV3', '001361351361', 'HO6', 'Nguyễn Tuấn Cảnh', '1949-02-02', b'1', 'Bố nuôi', b'1'),
	('HO7TV1', '002412051261', 'HO7', 'Trần Bảo Ngọc', '2000-06-12', b'0', 'Chủ hộ', b'1');

-- Dumping structure for table bluemoon.tai_khoan
CREATE TABLE IF NOT EXISTS `tai_khoan` (
  `ma_tai_khoan` int(11) NOT NULL,
  `ho_ten` varchar(50) NOT NULL,
  `ten_tai_khoan` varchar(255) NOT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_tai_khoan`,`ten_tai_khoan`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Dumping data for table bluemoon.tai_khoan: ~8 rows (approximately)
INSERT INTO `tai_khoan` (`ma_tai_khoan`, `ho_ten`, `ten_tai_khoan`, `mat_khau`, `tinh_trang`) VALUES
	(1, 'ADMIN', 'admin', 'admin', b'1'),
	(2, 'Nguyễn Việt Anh', 'nva', 'nva', b'1'),
	(3, 'Nguyễn Xuân Bách', 'nxb', 'nxb', b'1'),
	(4, 'Nguyễn Tuấn Cảnh', 'ntc', 'ntc', b'1'),
	(5, 'Lê Tăng Đạt', 'ltd', 'ltd', b'1'),
	(6, 'Đỗ Văn Việt', 'dvv', 'dvv', b'1'),
	(7, 'Trần Thanh Phong', 'ttp', 'ttp', b'1'),
	(8, 'ADMIN2', 'admin2', 'admin2', b'0');

-- Dumping structure for table bluemoon.thu_phi
CREATE TABLE IF NOT EXISTS `thu_phi` (
  `ma_thu` varchar(50) NOT NULL,
  `ma_phi` varchar(50) NOT NULL,
  `ngay_thu` date DEFAULT NULL,
  `ma_nhan_khau` varchar(50) NOT NULL,
  `ma_hogd` varchar(50) NOT NULL,
  `so_tien` int(11) DEFAULT NULL,
  PRIMARY KEY (`ma_thu`),
  KEY `ma_hogd` (`ma_hogd`),
  KEY `ma_nhan_khau` (`ma_nhan_khau`),
  KEY `ma_phi` (`ma_phi`),
  CONSTRAINT `thu_phi_ibfk_2` FOREIGN KEY (`ma_hogd`) REFERENCES `ho_gia_dinh` (`ma_hogd`) ON DELETE CASCADE,
  CONSTRAINT `thu_phi_ibfk_3` FOREIGN KEY (`ma_nhan_khau`) REFERENCES `nhan_khau` (`ma_nhan_khau`) ON DELETE CASCADE,
  CONSTRAINT `thu_phi_ibfk_4` FOREIGN KEY (`ma_phi`) REFERENCES `loai_phi` (`ma_phi`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table bluemoon.thu_phi: ~47 rows (approximately)
INSERT INTO `thu_phi` (`ma_thu`, `ma_phi`, `ngay_thu`, `ma_nhan_khau`, `ma_hogd`, `so_tien`) VALUES
	('HO1TP201', 'DVCC', '2024-02-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP202', 'QLCC', '2024-02-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP203', 'XM', '2024-02-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP204', 'OT', '2024-02-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP205', 'TM', '2024-02-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP206', 'TD', '2024-02-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP207', 'TN', '2024-02-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP208', 'TT', '2024-02-16', 'HO1TV1', 'HO1', 200000),
	('HO1TP301', 'DVCC', '2024-03-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP302', 'QLCC', '2024-03-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP303', 'XM', '2024-03-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP304', 'OT', '2024-03-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP305', 'TM', '2024-03-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP306', 'TD', '2024-03-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP307', 'TN', '2024-03-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP308', 'TT', '2024-03-16', 'HO1TV1', 'HO1', 100000),
	('HO1TP401', 'DVCC', '2024-04-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP402', 'QLCC', '2024-04-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP403', 'XM', '2024-04-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP404', 'OT', '2024-04-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP405', 'TM', '2024-04-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP406', 'TD', '2024-04-16', 'HO1TV1', 'HO1', NULL),
	('HO1TP407', 'TN', '2024-04-16', 'HO1TV1', 'HO1', NULL),
	('HO2TP201', 'DVCC', '2024-02-15', 'HO2TV1', 'HO2', NULL),
	('HO2TP202', 'QLCC', '2024-02-15', 'HO2TV1', 'HO2', NULL),
	('HO2TP203', 'XM', '2024-02-15', 'HO2TV1', 'HO2', NULL),
	('HO2TP204', 'OT', '2024-02-15', 'HO2TV1', 'HO2', NULL),
	('HO2TP205', 'TM', '2024-02-15', 'HO2TV1', 'HO2', NULL),
	('HO2TP206', 'TD', '2024-02-15', 'HO2TV1', 'HO2', NULL),
	('HO2TP207', 'TN', '2024-02-15', 'HO2TV1', 'HO2', NULL),
	('HO2TP208', 'TT', '2024-02-15', 'HO2TV1', 'HO2', 100000),
	('HO3TP201', 'DVCC', '2024-03-15', 'HO3TV1', 'HO3', NULL),
	('HO3TP202', 'QLCC', '2024-03-15', 'HO3TV1', 'HO3', NULL),
	('HO3TP203', 'XM', '2024-03-15', 'HO3TV1', 'HO3', NULL),
	('HO3TP204', 'OT', '2024-03-15', 'HO3TV1', 'HO3', NULL),
	('HO3TP205', 'TM', '2024-03-15', 'HO3TV1', 'HO3', NULL),
	('HO3TP206', 'TD', '2024-03-15', 'HO3TV1', 'HO3', NULL),
	('HO3TP207', 'TN', '2024-03-15', 'HO3TV1', 'HO3', NULL),
	('HO3TP208', 'TT', '2024-03-15', 'HO3TV1', 'HO3', 150000),
	('HO4TP201', 'DVCC', '2024-02-15', 'HO4TV1', 'HO4', NULL),
	('HO4TP202', 'QLCC', '2024-02-15', 'HO4TV1', 'HO4', NULL),
	('HO4TP203', 'XM', '2024-02-15', 'HO4TV1', 'HO4', NULL),
	('HO4TP204', 'OT', '2024-02-15', 'HO4TV1', 'HO4', NULL),
	('HO4TP205', 'TM', '2024-02-15', 'HO4TV1', 'HO4', NULL),
	('HO4TP206', 'TD', '2024-02-15', 'HO4TV1', 'HO4', NULL),
	('HO4TP207', 'TN', '2024-02-15', 'HO4TV1', 'HO4', NULL),
	('HO4TP208', 'TT', '2024-02-15', 'HO4TV1', 'HO4', 150000);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
