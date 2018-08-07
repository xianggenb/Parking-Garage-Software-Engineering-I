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
-- Database: `database`
--

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE IF NOT EXISTS `logininfo` (
  `password` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logininfo`
--

INSERT INTO `logininfo` (`password`, `Username`) VALUES
('123', '3213@hfad.com'),
('123', 'test2@123.com'),
('123', 'test@123.com');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `Name_On_Card` varchar(30) NOT NULL,
  `Expiration_Date` varchar(5) NOT NULL,
  `Security_Code` int(3) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Card_Number` varchar(20) NOT NULL,
  PRIMARY KEY (`Card_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `emailaddress` varchar(100) NOT NULL,
  `zip_code` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `default_vehicle` varchar(20) DEFAULT NULL,
  `default_payment` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`emailaddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`first_name`, `last_name`, `emailaddress`, `zip_code`, `phone`, `default_vehicle`, `default_payment`) VALUES
('rwer', 'werwe', '3213@hfad.com', '123123', '123123', NULL, NULL),
('test1', 'test2', 'test2@123.com', '12321', '123123213213', NULL, NULL),
('test', 'test', 'test@123.com', '123', '123123123', 'dasdasd', '13123123');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `Make` varchar(30) NOT NULL,
  `Model` varchar(30) NOT NULL,
  `year` year(4) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `License_Plate_Number` varchar(30) NOT NULL,
  PRIMARY KEY (`License_Plate_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`Make`, `Model`, `year`, `Username`, `License_Plate_Number`) VALUES
('test', 'test1', 1932, 'test2@123.com', 'fdafds');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
