-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2016 at 09:57 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `reservationdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `business`
--

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
  `EmailAddress` varchar(255) NOT NULL,
  PRIMARY KEY (`ConfirmationNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `business`
--

INSERT INTO `business` (`ConfirmationNumber`, `FirstName`, `LastName`, `CompanyName`, `LP`, `StartDate`, `EndDate`, `StartTime`, `EndTime`, `EmailAddress`) VALUES
(1, 'petesmith', '', 'microsoft', '567ghj', '0000-00-00', '0000-00-00', '00:00:00', '00:00:00', ''),
(2, 'petesmith', '', 'microsoft', '567ghj', '0000-00-00', '0000-00-00', '00:00:00', '00:00:00', ''),
(3, 'petesmith', '', 'apple', 'company', '2016-04-14', '0000-00-00', '09:30:00', '12:00:00', ''),
(4, 'bob', 'schmitt', 'WORLDWIDEWEB', '678ast', '2016-04-19', '0000-00-00', '01:30:00', '09:30:00', ''),
(5, 'john', 'smith', 'WORLDWIDEWEB', 'jkl678', '2016-04-20', '0000-00-00', '09:00:00', '10:30:00', ''),
(6, 'john', 'schmitt', 'WORLDWIDEWEB', '678ast', '2016-04-13', '0000-00-00', '01:00:00', '10:30:00', ''),
(7, 'john', 'smith', 'WORLDWIDEWEB', 'jkl678', '2016-04-06', '0000-00-00', '01:00:00', '09:30:00', ''),
(8, 'bob', 'schmitt', 'WORLDWIDEWEB', '678ast', '2016-04-13', '2016-04-14', '01:30:00', '09:30:00', '');

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

CREATE TABLE IF NOT EXISTS `logininfo` (
  `Username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininfo`
--

INSERT INTO `logininfo` (`Username`, `password`) VALUES
('maxsmith@gmail.com', 'maxpassword'),
('samdoe@yahoo.com', 'sampassword'),
('jimmy.nitro@gmail.com', 'jimmypass');

-- --------------------------------------------------------

--
-- Table structure for table `recurring`
--

CREATE TABLE IF NOT EXISTS `recurring` (
  `ConfirmationNumber` int(11) NOT NULL AUTO_INCREMENT,
  `LP` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `SubscriptionStartTime` time NOT NULL,
  `SubscriptionEndTime` time NOT NULL,
  `SubscriptionType` varchar(255) NOT NULL,
  `State` int(12) NOT NULL,
  `EmailAddress` varchar(255) NOT NULL,
  PRIMARY KEY (`ConfirmationNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `recurring`
--

INSERT INTO `recurring` (`ConfirmationNumber`, `LP`, `FirstName`, `LastName`, `SubscriptionStartTime`, `SubscriptionEndTime`, `SubscriptionType`, `State`, `EmailAddress`) VALUES
(2, '456rty', 'john', 'smith', '01:30:00', '09:30:00', 'monthly', 0, ''),
(3, '456rty', 'john', 'smith', '01:30:00', '09:30:00', 'monthly', 0, ''),
(4, 'sdfs', 'john', 'smith', '09:00:00', '09:30:00', 'daily', 0, ''),
(5, 'gwss', 'john', 'smith', '01:00:00', '09:30:00', 'weeklyw', 0, ''),
(6, 'sdfs', 'john', 'smith', '01:00:00', '04:00:00', 'weeklyTue', 0, ''),
(7, 'gwss', 'john', 'smith', '01:30:00', '04:00:00', 'weeklyFri', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE IF NOT EXISTS `reservations` (
  `LP` varchar(255) NOT NULL,
  `ArrivalTime` timestamp NOT NULL,
  `DepartureTime` timestamp NOT NULL,
  `ConfirmationNumber` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `EmailAddress` varchar(255) NOT NULL,
  PRIMARY KEY (`ConfirmationNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`LP`, `ArrivalTime`, `DepartureTime`, `ConfirmationNumber`, `FirstName`, `LastName`, `EmailAddress`) VALUES
('123-ghj', '2012-12-14 06:35:34', '2014-12-14 06:55:34', 1, 'John', 'Doe', ''),
('123-ghj', '2012-12-14 06:35:34', '2012-12-14 06:55:34', 2, 'John', 'greenberg', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, '', '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, '', '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, '', '', ''),
('d', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 6, 'd', 'd', ''),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 7, 'yo', 'yo', ''),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 8, 'yo', 'yo', ''),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 9, 'yo', 'yo', ''),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 10, 'yo', 'yo', ''),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 11, 'yo', 'yo', ''),
('soad', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 12, 'yo', 'yo', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 13, '', '', ''),
('gwss', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 14, 'afsd', 'fas', ''),
('gwss', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 15, 'afsd', 'fas', ''),
('dsfjs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 16, 'jdsa', 'adsfadf', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 17, '', '', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 18, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 19, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 20, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 21, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 22, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 23, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 24, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 25, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 26, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 27, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 28, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 29, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 30, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 31, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 32, 'fdsafsd', 'adsfda', ''),
('sdfs', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 33, 'fdsafsd', 'adsfda', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 34, '', '', ''),
('sdfh83', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 35, 'john', 'doe', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 36, '', '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 37, '', '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 38, '', '', ''),
('', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 39, '', '', ''),
('vjlg', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 40, '', '', ''),
('asw123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 41, 'john', 'doe', ''),
('asw123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 42, 'john', 'doe', ''),
('asw123', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 43, 'john', 'doe', ''),
('jfk4568', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 44, 'jane', 'smith', 'janesmith@gmail.com'),
('jfk4568', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 45, 'jane', 'smith', 'janesmith@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

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
('MA1234', 'Max', 'Smith', 'maxsmith@gmail.com', 12345, 567394737, 'MA1234', 1234567890, 'Pear'),
('SD4321', 'Sam', 'Doe', 'samdoe@yahoo.com', 24532, 2073345748, 'SD4321', 2087932656, 'Facepage'),
('JN2345', 'Jimmy', 'Nitro', 'jimmy.nitro@gmail.com', 46274, 2125436348, 'JN2345', 125465652, 'Macrosoft');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
