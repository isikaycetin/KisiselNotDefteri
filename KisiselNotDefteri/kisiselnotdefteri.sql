-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 19 Ara 2024, 14:14:31
-- Sunucu sürümü: 8.0.40
-- PHP Sürümü: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kisiselnotdefteri`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kisiselnotlar`
--

DROP TABLE IF EXISTS `kisiselnotlar`;
CREATE TABLE IF NOT EXISTS `kisiselnotlar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `baslik` varchar(255) NOT NULL,
  `icerik` text NOT NULL,
  `tarih` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_id` int DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `kisiselnotlar`
--

INSERT INTO `kisiselnotlar` (`id`, `baslik`, `icerik`, `tarih`, `user_id`, `kategori`) VALUES
(2, 'sadas', '', '2024-12-12 16:08:42', NULL, NULL),
(3, '', '', '2024-12-12 16:08:42', NULL, NULL),
(4, 'beşiktaş', '', '2024-12-12 16:24:27', NULL, NULL),
(8, 'sdad', 'asdas', '2024-12-12 20:59:06', 1, NULL),
(9, 'as', 'sa', '2024-12-12 21:00:10', 1, NULL),
(24, 'icardi', 'naber icardi', '2024-12-18 19:25:10', 1, NULL),
(26, 'beşiktaş', 'kötü takım', '2024-12-18 19:39:40', 2, 'futbol'),
(27, 'prison break', 'michael scofield', '2024-12-18 19:44:40', 2, 'film'),
(28, 'Yazılım Mimarisi', 'Yazılım Mimari Ödevi', '2024-12-18 19:45:07', 2, 'Ders'),
(30, 'süleyman çakır', 'krtlar vadisi', '2024-12-18 19:46:15', 2, 'film'),
(32, 'clash of clans', 'mobil oyun', '2024-12-18 19:52:09', 3, 'oyun'),
(33, 'CS GO', 'fps silah oyunu', '2024-12-18 19:52:30', 3, 'oyun'),
(34, 'strike back', 'askeri aksiyon intikam dizisi', '2024-12-18 19:53:05', 3, 'dizi'),
(35, 'Shogun', 'japon tarihi', '2024-12-18 19:53:36', 3, 'dizi'),
(36, 'Yapay Zeka', 'SWI-PROLOG', '2024-12-18 19:54:02', 3, 'Yazılım'),
(37, 'Java ile Nesne Programlama', 'javayı classlarla interfacelerle öğreniyoruz', '2024-12-18 19:54:43', 3, 'Yazılım'),
(38, 'Ders', 'grafikler', '2024-12-19 15:04:50', 2, 'Ders'),
(40, 'serd', 'dfsdf', '2024-12-19 15:10:50', 2, 'asdas'),
(41, 'anı', 'anılar', '2024-12-19 15:47:16', 2, 'hatıra'),
(42, 'sassd', 'sadsad', '2024-12-19 16:00:49', 4, 'sdsdd');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanıcılar`
--

DROP TABLE IF EXISTS `kullanıcılar`;
CREATE TABLE IF NOT EXISTS `kullanıcılar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) DEFAULT 'user',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `kullanıcılar`
--

INSERT INTO `kullanıcılar` (`id`, `username`, `password`, `role`) VALUES
(1, 'yıldıray', 'parlak', 'admin'),
(2, 'ışıkay', 'çetin', 'user'),
(3, 'kutay', 'yıldırım', 'user'),
(4, 'mehmet', '12345', 'user');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
