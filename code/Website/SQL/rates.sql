-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2016 at 08:10 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rates`
--

-- --------------------------------------------------------

--
-- Table structure for table `rates`
--

DROP TABLE IF EXISTS `rates`;
CREATE TABLE IF NOT EXISTS `rates` (
  `ratename` char(25) CHARACTER SET utf8 NOT NULL,
  `activeperiod` char(25) CHARACTER SET utf8 NOT NULL,
  `cost` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rates`
--

INSERT INTO `rates` (`ratename`, `activeperiod`, `cost`) VALUES
('Evening Rates', 'Monday-Sunday[11pm-3am]', 15),
('Weekend Hourly Rate', 'Saturday-Sunday', 25),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10),
('Hourly Rate', 'Always', 10);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
