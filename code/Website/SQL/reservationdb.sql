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
-- Database: `reservationdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `business`
--

DROP TABLE IF EXISTS `business`;
CREATE TABLE IF NOT EXISTS `business` (
  `ConfirmationNumber` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `CompanyName` varchar(255) NOT NULL,
  `LP` varchar(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `StartTime` time NOT NULL,
  `EndTime` time NOT NULL,
  PRIMARY KEY (`ConfirmationNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `business`
--

INSERT INTO `business` (`ConfirmationNumber`, `FirstName`, `LastName`, `CompanyName`, `LP`, `StartDate`, `EndDate`, `StartTime`, `EndTime`) VALUES
(6, 'john', 'smith', 'WORLDWIDEWEB', 'jkl678', '2016-04-25', '2016-04-25', '10:30:00', '11:00:00'),
(7, 'john', 'smith', 'WORLDWIDEWEB', 'jkl678', '2016-04-25', '2016-04-25', '10:00:00', '10:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `recurring`
--

DROP TABLE IF EXISTS `recurring`;
CREATE TABLE IF NOT EXISTS `recurring` (
  `ConfirmationNumber` int(11) NOT NULL AUTO_INCREMENT,
  `LP` varchar(255) NOT NULL,
  `State` int(6) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `SubscriptionStartTime` time NOT NULL,
  `SubscriptionEndTime` time NOT NULL,
  `SubscriptionType` varchar(255) NOT NULL,
  PRIMARY KEY (`ConfirmationNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recurring`
--

INSERT INTO `recurring` (`ConfirmationNumber`, `LP`, `State`, `FirstName`, `LastName`, `SubscriptionStartTime`, `SubscriptionEndTime`, `SubscriptionType`) VALUES
(1, 'ase123', 0, 'john', 'smith', '01:30:00', '10:30:00', 'weekly'),
(2, 'ckz-rti', 0, 'Garth', ' Brown', '19:43:34', '19:45:34', 'daily');

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE IF NOT EXISTS `reservations` (
  `LP` varchar(255) NOT NULL,
  `ArrivalTime` timestamp NOT NULL,
  `DepartureTime` timestamp NOT NULL,
  `ConfirmationNumber` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  PRIMARY KEY (`ConfirmationNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`LP`, `ArrivalTime`, `DepartureTime`, `ConfirmationNumber`, `FirstName`, `LastName`) VALUES
('123-ghj', '2012-12-14 06:35:34', '2014-12-14 06:55:34', 1, 'John', 'Doe'),
('123-ghj', '2012-12-14 06:35:34', '2012-12-14 06:55:34', 2, 'John', 'greenberg'),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, '', ''),
('d', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 6, 'd', 'd'),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 7, 'yo', 'yo'),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 8, 'yo', 'yo'),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 9, 'yo', 'yo'),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 10, 'yo', 'yo'),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 11, 'yo', 'yo'),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 12, 'yo', 'yo'),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 13, '', ''),
('gwss', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 14, 'afsd', 'fas'),
('gwss', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 15, 'afsd', 'fas'),
('dsfjs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 16, 'jdsa', 'adsfadf'),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 17, '', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 18, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 19, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 20, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 21, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 22, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 23, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 24, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 25, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 26, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 27, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 28, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 29, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 30, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 31, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 32, 'fdsafsd', 'adsfda'),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 33, 'fdsafsd', 'adsfda'),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 34, '', ''),
('sdfh83', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 35, 'john', 'doe'),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 36, '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 37, '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 38, '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 39, '', ''),
('vjlg', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 40, '', ''),
('asw123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 41, 'john', 'doe'),
('asw123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 42, 'john', 'doe'),
('asw123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 43, 'john', 'doe'),
('yqd-lgs', '2016-04-25 23:15:09', '2016-04-25 23:17:09', 44, 'Garth', ' Jones'),
('wbo-qhj', '2016-04-26 00:53:10', '2016-04-26 00:56:10', 45, 'George', ' Cohen'),
('btc-xnh', '2016-04-26 10:53:23', '2016-04-26 10:55:23', 46, 'Jane', ' Meadows'),
('btc-xnh', '2016-04-26 10:53:31', '2016-04-26 10:56:31', 47, 'Jane', ' Meadows'),
('gsj-rhh', '2016-04-26 10:53:57', '2016-04-26 10:55:57', 48, 'Jane', ' Jones'),
('vos-fbm', '2016-04-26 11:22:02', '2016-04-26 11:25:02', 49, 'Bob', ' Johnson'),
('omd-orm', '2016-04-26 11:22:08', '2016-04-26 11:25:08', 50, 'David', ' Summers'),
('nfn-xmg', '2016-04-26 11:22:31', '2016-04-26 11:23:31', 51, 'Sam', ' LaForge'),
('tut-bpc', '2016-04-26 11:22:43', '2016-04-26 11:25:43', 52, 'Linda', ' Johnson'),
('tzt-tpu', '2016-04-26 11:22:51', '2016-04-26 11:23:51', 53, 'David', ' Smith'),
('hhx-snp', '2016-04-26 11:23:15', '2016-04-26 11:25:15', 54, 'David', ' LaForge'),
('wnl-oju', '2016-04-26 11:23:35', '2016-04-26 11:25:35', 55, 'Jane', ' Meadows'),
('tyd-ula', '2016-04-26 12:32:44', '2016-04-26 12:35:44', 56, 'Sam', ' Johnson'),
('bmv-rdo', '2016-04-26 13:26:24', '2016-04-26 13:28:24', 57, 'George', ' Jones'),
('wsr-jry', '2016-04-26 13:26:36', '2016-04-26 13:27:36', 58, 'Garth', ' Smith'),
('acn-cuu', '2016-04-26 13:27:00', '2016-04-26 13:29:00', 59, 'Sam', ' Summers'),
('kpc-uyh', '2016-04-26 13:27:31', '2016-04-26 13:29:31', 60, 'George', ' Smith'),
('zyv-wps', '2016-04-26 13:49:00', '2016-04-26 13:50:00', 61, 'Jane', ' Brown'),
('bta-ppm', '2016-04-26 13:55:57', '2016-04-26 13:57:57', 62, 'Jane', ' Brown'),
('wip-mjz', '2016-04-26 13:58:37', '2016-04-26 14:01:37', 63, 'Jane', ' Smith'),
('egy-fxe', '2016-04-26 14:25:16', '2016-04-26 14:27:16', 64, 'Jane', ' Miller'),
('xze-lyw', '2016-04-26 14:26:00', '2016-04-26 14:28:00', 65, 'Beth', ' LaForge'),
('lud-brt', '2016-04-26 14:26:11', '2016-04-26 14:27:11', 66, 'Bob', ' Jones'),
('sce-rru', '2016-04-26 14:26:33', '2016-04-26 14:28:33', 67, 'Sam', ' Summers'),
('tdj-ozj', '2016-04-26 14:26:43', '2016-04-26 14:27:43', 68, 'David', ' Brown'),
('kwo-tqr', '2016-04-26 14:27:11', '2016-04-26 14:29:11', 69, 'Bob', ' Meadows'),
('wna-nwj', '2016-04-26 14:58:34', '2016-04-26 14:59:34', 70, 'David', ' Johnson'),
('isq-fpz', '2016-04-26 14:59:28', '2016-04-26 15:00:28', 71, 'Linda', ' Smith'),
('ujp-orr', '2016-04-26 14:59:37', '2016-04-26 15:02:37', 72, 'David', ' Johnson'),
('mlw-xxv', '2016-04-26 15:00:17', '2016-04-26 15:01:17', 73, 'Christina', ' Smith'),
('dyg-yda', '2016-04-26 15:00:35', '2016-04-26 15:01:35', 74, 'George', ' Miller'),
('gvn-xov', '2016-04-26 15:00:54', '2016-04-26 15:02:54', 75, 'Beth', ' Miller'),
('akp-ydx', '2016-04-26 15:01:59', '2016-04-26 15:02:59', 76, 'Sally', ' Rockford'),
('ysh-2h3', '2016-12-24 07:34:45', '2016-12-24 09:34:45', 77, 'Luke', 'Miller');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `LP` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `emailaddress` varchar(255) NOT NULL,
  `zip_code` int(7) NOT NULL,
  `phone` int(11) NOT NULL,
  `default_vehicle` varchar(255) NOT NULL,
  `default_payment` int(16) NOT NULL,
  `company` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`LP`, `first_name`, `last_name`, `emailaddress`, `zip_code`, `phone`, `default_vehicle`, `default_payment`, `company`) VALUES
('jkl678', 'john', 'smith', 'johnsmith@gmail.com', 9876, 678234987, 'car', 1234567890, ''),
('', 'hello', '', '', 0, 0, '', 0, ''),
('jkl789', 'jane', 'smith', 'janesmith@gmail.com', 89054, 789456123, 'jaguar', 1234567890, ''),
('678ast', 'bob', 'schmitt', 'bob@gmail.com', 76234, 123456789, '', 1234567890, 'WORLDWIDEWEB');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
