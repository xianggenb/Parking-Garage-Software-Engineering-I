-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2016 at 08:09 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `departure`
--

-- --------------------------------------------------------

--
-- Table structure for table `depature`
--

DROP TABLE IF EXISTS `depature`;
CREATE TABLE IF NOT EXISTS `depature` (
  `LP` varchar(255) NOT NULL,
  `arrival` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `depature` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `email` varchar(255) NOT NULL,
  `payment` varchar(255) NOT NULL,
  `spot` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `depature`
--

INSERT INTO `depature` (`LP`, `arrival`, `depature`, `email`, `payment`, `spot`, `status`) VALUES
('wwj-tvd', '2016-03-28 05:15:08', '2016-03-28 06:15:09', '769574822@qq.com', '1234-1234-1234-1234', 1, 1),
('urx-thg', '2016-03-28 05:15:08', '2016-03-28 06:15:09', '769574822@qq.com', '1234-1234-1234-1234', 1, 1),
('urx-thg', '2016-03-28 05:15:08', '2016-03-28 06:15:09', '769574822@qq.com', '1234-1234-1234-1234', 1, 1),
('urx-thg', '2016-03-28 05:15:08', '2016-03-28 06:15:09', '769574822@qq.com', '1234-1234-1234-1234', 1, 1),
('urx-thg', '2016-03-28 05:15:08', '2016-03-28 06:15:09', '769574822@qq.com', '1234-1234-1234-1234', 1, 1),
('urx-thg', '2016-03-28 05:15:08', '2016-03-28 06:15:09', '769574822@qq.com', '1234-1234-1234-1234', 1, 1),
('urx-thg', '2016-03-28 05:15:08', '2016-03-28 06:15:09', '769574822@qq.com', '1234-1234-1234-1234', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS `spot`;
CREATE TABLE IF NOT EXISTS `spot` (
  `LP` varchar(255) NOT NULL,
  `spot` int(255) NOT NULL,
  `status` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spot`
--

INSERT INTO `spot` (`LP`, `spot`, `status`) VALUES
('A1234', 1, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
