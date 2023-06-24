-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 24 Haz 2023, 12:36:37
-- Sunucu sürümü: 10.4.28-MariaDB
-- PHP Sürümü: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `otomasyon`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `islemler`
--

CREATE TABLE `islemler` (
  `eposta` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `islemAciklama` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `islemTutar` int(50) NOT NULL,
  `islemTarih` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `islemler`
--

INSERT INTO `islemler` (`eposta`, `islemAciklama`, `islemTutar`, `islemTarih`) VALUES
('admin@hotmail.com', '2 kişilik otel odası istendi 2 gece 3 gün.', 7000, '2023-06-15'),
('admin2@hotmail.com', 'Apart kiralandı 24 saatlik', 1500, '2023-06-22'),
('deneme1@hotmail.com', 'Ev kiralandı 7 günlük', 14, '2023-06-16'),
('d@hotmail.com', '1 kişilik otel odası istendi 3 gece 4 gün ve oda t', 10, '2023-06-18');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `eposta` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(50) NOT NULL,
  `ad` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `soyad` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`eposta`, `sifre`, `ad`, `soyad`) VALUES
('admin@hotmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'admin', 'admin'),
('admin2@hotmail.com', '202cb962ac59075b964b07152d234b70', 'admin2', 'admin2'),
('mercanesen@hotmail.com', 'c4bc573d6343c19e51b21a5b6a19072e', 'mercan', 'esen');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yönetici`
--

CREATE TABLE `yönetici` (
  `eposta` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `şifre` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `yönetici`
--

INSERT INTO `yönetici` (`eposta`, `şifre`) VALUES
('yönetici@hotmail.com', '123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
