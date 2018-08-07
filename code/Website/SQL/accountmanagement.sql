-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2016 at 08:07 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accountmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `Company_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `state` char(2) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `link_password` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`Company_name`, `email`, `address`, `state`, `zipcode`, `phone`, `link_password`) VALUES
('LukeCorp', 'luke@lukecorp.com', '413 Fake Street', 'NJ', '93847', '827', 'doggy');

-- --------------------------------------------------------

--
-- Table structure for table `deny_list`
--

DROP TABLE IF EXISTS `deny_list`;
CREATE TABLE IF NOT EXISTS `deny_list` (
  `emailaddress` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deny_list`
--

INSERT INTO `deny_list` (`emailaddress`, `company`) VALUES
('123@123.com', 'test'),
('test@123.com', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE IF NOT EXISTS `logininfo` (
  `password` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `account_type` enum('P','B') NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logininfo`
--

INSERT INTO `logininfo` (`password`, `Username`, `account_type`) VALUES
('password', '8888Car@gmail.com', 'P'),
('password', 'CarBlueSky@gmail.com', 'P'),
('password', 'CarCarCat@gmail.com', 'P'),
('password', 'Cat2Car@gmail.com', 'P'),
('password', 'DogCarBlue@gmail.com', 'P'),
('password', 'DogDog88@gmail.com', 'P'),
('password', 'Green2Sky@gmail.com', 'P'),
('password', 'luke@lukecorp.com', 'B'),
('password', 'Shrimp2Sky@gmail.com', 'P'),
('password', 'ShrimpCarDancer@gmail.com', 'P'),
('luke', 'tech@millerluke.com', 'P'),
('pass', 'test@test.com', 'P');

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

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Name_On_Card`, `Expiration_Date`, `Security_Code`, `Username`, `Card_Number`) VALUES
('Linda Johnson', '07/18', 131, 'DogDancerCat@gmail.com', '1228-6843-6536-4575'),
('Garth Smith', '07/18', 856, 'GreenCarDog@gmail.com', '1267-5257-8175-8633'),
('Garth Johnson', '07/18', 281, 'Sky88Green@gmail.com', '1372-7445-6362-7744'),
('Linda Johnson', '07/18', 254, 'CarBlueBlue@gmail.com', '1572-6241-1731-3513'),
('Christina Jones', '07/18', 387, 'CatCatCar@gmail.com', '1583-7462-7351-2787'),
('David Johnson', '07/18', 561, 'CarBlueSky@gmail.com', '1882-2637-2674-5848'),
('Jane Meadows', '07/18', 818, '88DancerCat@gmail.com', '2146-2621-2621-5373'),
('Bob Johnson', '07/18', 835, 'Dancer88Car@gmail.com', '2431-4666-5411-1563'),
('Bob Johnson', '07/18', 873, 'CarDancerCat@gmail.com', '2621-6273-6447-5226'),
('Sally Rockford', '07/18', 642, 'DogCarBlue@gmail.com', '3135-2477-7725-3237'),
('Jane Smith', '07/18', 243, 'SkySkyGreen@gmail.com', '3328-5864-4175-6436'),
('Sam Summers', '07/18', 621, 'CarSky88@gmail.com', '3365-2557-4472-3232'),
('Jane Jones', '07/18', 545, 'Green2Green@gmail.com', '3447-7714-3473-8647'),
('George Smith', '07/18', 627, 'DogCatCar@gmail.com', '3454-3444-6378-5348'),
('George Miller', '07/18', 862, 'Shrimp2Sky@gmail.com', '3518-1465-5114-6132'),
('Jane Miller', '07/18', 716, 'Sky288@gmail.com', '3668-2563-5144-2523'),
('Sam Johnson', '07/18', 861, 'BlueGreen2@gmail.com', '3684-6826-3857-3444'),
('Christina Cohen', '07/18', 782, 'GreenCatDog@gmail.com', '3747-3778-5348-1113'),
('Linda Brown', '07/18', 531, 'ShrimpCarDancer@gmail.com', '3775-4583-5356-8745'),
('Sally Rockford', '07/18', 242, 'GreenDancer88@gmail.com', '3853-4815-7357-4428'),
('David Summers', '07/18', 822, 'BlueDogDancer@gmail.com', '4234-7813-8457-4625'),
('Sam LaForge', '07/18', 652, 'CarCatCar@gmail.com', '4413-7135-1168-1878'),
('Sam LaForge', '07/18', 352, 'Dog288@gmail.com', '4454-7511-8187-8763'),
('Jane Brown', '07/18', 884, 'BlueDogGreen@gmail.com', '4641-8376-8238-5874'),
('Christina Smith', '07/18', 366, 'Green2Sky@gmail.com', '4828-1436-6226-8642'),
('Bob Jones', '07/18', 778, 'Car2Shrimp@gmail.com', '4836-1324-2855-8828'),
('David LaForge', '07/18', 253, 'DogSkyBlue@gmail.com', '4852-2317-5183-2277'),
('Sally Miller', '07/18', 621, 'DancerDancerDancer@gmail.com', '5265-6841-5561-8128'),
('Christina Jones', '07/18', 212, 'ShrimpShrimpSky@gmail.com', '5324-6785-6632-7731'),
('George Jones', '07/18', 577, 'CatDogGreen@gmail.com', '5423-1543-7843-4635'),
('Jane Brown', '07/18', 154, 'CarDancerShrimp@gmail.com', '5437-7771-7314-1172'),
('David Summers', '07/18', 778, 'Green2Sky@gmail.com', '5487-6564-2518-3866'),
('David Smith', '07/18', 458, 'DancerCarShrimp@gmail.com', '5513-6518-8628-1417'),
('Beth Miller', '07/18', 126, 'Cat2Car@gmail.com', '5515-5443-8537-1584'),
('David Johnson', '07/18', 832, '8888Car@gmail.com', '5568-3567-5133-7288'),
('Sam LaForge', '07/18', 836, 'CarBlue2@gmail.com', '5717-3415-5277-6822'),
('Bob Meadows', '07/18', 828, 'GreenDogBlue@gmail.com', '5755-5484-5576-1381'),
('Christina Rockford', '07/18', 136, '2Sky88@gmail.com', '6114-3727-6867-3816'),
('Garth Smith', '07/18', 445, '2GreenSky@gmail.com', '6257-3247-7568-2716'),
('Sam Summers', '07/18', 617, 'Car882@gmail.com', '6433-4325-7585-2334'),
('David Brown', '07/18', 162, 'GreenSkyShrimp@gmail.com', '6438-2486-2155-6737'),
('Sally Rockford', '07/18', 783, 'BlueDancer2@gmail.com', '7232-1368-6848-4381'),
('Linda Smith', '07/18', 846, 'DogDog88@gmail.com', '7327-6744-3444-7843'),
('Garth Johnson', '07/18', 541, 'DancerBlueDog@gmail.com', '7344-2134-2257-5526'),
('Jane Meadows', '07/18', 212, 'CarCatDog@gmail.com', '7635-4615-7111-1523'),
('Garth Cohen', '07/18', 468, 'DogCar2@gmail.com', '7652-1314-4777-4477'),
('Jane Meadows', '07/18', 168, 'GreenDancer2@gmail.com', '7786-3115-2788-7636'),
('Beth Jones', '07/18', 736, 'CarCarCat@gmail.com', '8587-6115-4348-4547'),
('George Cohen', '07/18', 188, 'DogCatGreen@gmail.com', '8816-1877-8582-6231'),
('Beth LaForge', '07/18', 535, 'GreenCar88@gmail.com', '8882-7561-4222-2428');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `LP` char(255) DEFAULT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `emailaddress` varchar(100) NOT NULL,
  `zip_code` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `default_vehicle` varchar(20) DEFAULT NULL,
  `default_payment` varchar(20) DEFAULT NULL,
  `company` char(255) DEFAULT NULL,
  PRIMARY KEY (`emailaddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`LP`, `first_name`, `last_name`, `emailaddress`, `zip_code`, `phone`, `default_vehicle`, `default_payment`, `company`) VALUES
(NULL, 'Luke', 'kjnkjn', '123@123.com', '08904', '+9+5+65', NULL, NULL, 'test'),
(NULL, 'Jane', ' Brown', '222@gmail.com', '69246', '69246', NULL, NULL, NULL),
(NULL, 'Jane', ' Johnson', '2Car2@gmail.com', '42934', '42934', NULL, NULL, NULL),
(NULL, 'Christina', ' Summers', '2CarShrimp@gmail.com', '78234', '78234', NULL, NULL, NULL),
(NULL, 'Christina', ' Cohen', '2CatBlue@gmail.com', '43333', '43333', NULL, NULL, NULL),
(NULL, 'Garth', ' Smith', '2GreenSky@gmail.com', '14131', '14131', NULL, NULL, NULL),
(NULL, 'Garth', ' Rockford', '2ShrimpDog@gmail.com', '47315', '47315', NULL, NULL, NULL),
(NULL, 'Christina', ' Rockford', '2Sky88@gmail.com', '38139', '38139', NULL, NULL, NULL),
(NULL, 'rwer', 'werwe', '3213@hfad.com', '123123', '123123', NULL, NULL, NULL),
(NULL, 'David', ' Johnson', '8888Car@gmail.com', '47991', '47991', NULL, NULL, 'LukeCorp'),
(NULL, 'Garth', ' Brown', '8888Dancer@gmail.com', '35835', '35835', NULL, NULL, NULL),
(NULL, 'Jane', ' Summers', '88BlueCar@gmail.com', '13529', '13529', NULL, NULL, NULL),
(NULL, 'Garth', ' Smith', '88BlueSky@gmail.com', '79318', '79318', NULL, NULL, NULL),
(NULL, 'Garth', ' Jones', '88DancerCar@gmail.com', '36119', '36119', NULL, NULL, NULL),
(NULL, 'Jane', ' Meadows', '88DancerCat@gmail.com', '29136', '29136', NULL, NULL, NULL),
(NULL, 'Christina', ' Smith', '88DancerShrimp@gmail.com', '21299', '21299', NULL, NULL, NULL),
(NULL, 'Garth', ' Cohen', '88ShrimpDancer@gmail.com', '96580', '96580', NULL, NULL, NULL),
(NULL, 'Beth', ' Cohen', 'Blue2Dog@gmail.com', '56826', '56826', NULL, NULL, NULL),
(NULL, 'Bob', ' Johnson', 'BlueCarSky@gmail.com', '30409', '30409', NULL, NULL, NULL),
(NULL, 'Sally', ' Rockford', 'BlueDancer2@gmail.com', '75176', '75176', NULL, NULL, NULL),
(NULL, 'David', ' Summers', 'BlueDogDancer@gmail.com', '46809', '46809', NULL, NULL, NULL),
(NULL, 'Jane', ' Brown', 'BlueDogGreen@gmail.com', '69362', '69362', NULL, NULL, 'LukeCorp'),
(NULL, 'Sam', ' Johnson', 'BlueGreen2@gmail.com', '63420', '63420', NULL, NULL, 'LukeCorp'),
(NULL, 'Christina', ' Summers', 'Car22@gmail.com', '72831', '72831', NULL, NULL, NULL),
(NULL, 'Bob', ' Jones', 'Car2Shrimp@gmail.com', '58227', '58227', NULL, NULL, NULL),
(NULL, 'Sam', ' Summers', 'Car882@gmail.com', '21595', '21595', NULL, NULL, NULL),
(NULL, 'Sam', ' LaForge', 'CarBlue2@gmail.com', '36180', '36180', NULL, NULL, 'LukeCorp'),
(NULL, 'Linda', ' Johnson', 'CarBlueBlue@gmail.com', '24618', '24618', NULL, NULL, NULL),
(NULL, 'David', ' Johnson', 'CarBlueSky@gmail.com', '14891', '14891', NULL, NULL, NULL),
(NULL, 'Beth', ' Jones', 'CarCarCat@gmail.com', '14212', '14212', NULL, NULL, NULL),
(NULL, 'Sam', ' LaForge', 'CarCatCar@gmail.com', '74641', '74641', NULL, NULL, NULL),
(NULL, 'Jane', ' Meadows', 'CarCatDog@gmail.com', '35217', '35217', NULL, NULL, NULL),
(NULL, 'Bob', ' Johnson', 'CarDancerCat@gmail.com', '34102', '34102', NULL, NULL, NULL),
(NULL, 'Jane', ' Brown', 'CarDancerShrimp@gmail.com', '97939', '97939', NULL, NULL, 'LukeCorp'),
(NULL, 'Sam', ' Summers', 'CarSky88@gmail.com', '89493', '89493', NULL, NULL, NULL),
(NULL, 'Beth', ' Miller', 'Cat2Car@gmail.com', '51703', '51703', NULL, NULL, NULL),
(NULL, 'Sally', ' Summers', 'Cat882@gmail.com', '88112', '88112', NULL, NULL, NULL),
(NULL, 'Sam', ' Johnson', 'Cat88Cat@gmail.com', '80050', '80050', NULL, NULL, NULL),
(NULL, 'Sam', ' Summers', 'CatBlueSky@gmail.com', '20020', '20020', NULL, NULL, NULL),
(NULL, 'Christina', ' Jones', 'CatCatCar@gmail.com', '52165', '52165', NULL, NULL, NULL),
(NULL, 'George', ' Jones', 'CatDogGreen@gmail.com', '87759', '87759', NULL, NULL, NULL),
(NULL, 'David', ' Johnson', 'CatSky2@gmail.com', '17502', '17502', NULL, NULL, NULL),
(NULL, 'Bob', ' Johnson', 'Dancer88Car@gmail.com', '48472', '48472', NULL, NULL, 'LukeCorp'),
(NULL, 'Garth', ' Johnson', 'DancerBlueDog@gmail.com', '88669', '88669', NULL, NULL, NULL),
(NULL, 'David', ' Smith', 'DancerCarShrimp@gmail.com', '75906', '75906', NULL, NULL, NULL),
(NULL, 'Beth', ' Meadows', 'DancerCatDog@gmail.com', '46540', '46540', NULL, NULL, NULL),
(NULL, 'Sally', ' Miller', 'DancerDancerDancer@gmail.com', '92508', '92508', NULL, NULL, NULL),
(NULL, 'Linda', ' Jones', 'DancerGreenGreen@gmail.com', '14100', '14100', NULL, NULL, NULL),
(NULL, 'Sam', ' Smith', 'DancerSkyBlue@gmail.com', '26832', '26832', NULL, NULL, NULL),
(NULL, 'Sam', ' LaForge', 'Dog288@gmail.com', '15580', '15580', NULL, NULL, NULL),
(NULL, 'Bob', ' Smith', 'Dog88Dancer@gmail.com', '17835', '17835', NULL, NULL, 'LukeCorp'),
(NULL, 'Garth', ' Cohen', 'DogCar2@gmail.com', '57990', '57990', NULL, NULL, 'LukeCorp'),
(NULL, 'Sally', ' Rockford', 'DogCarBlue@gmail.com', '10610', '10610', NULL, NULL, NULL),
(NULL, 'George', ' Smith', 'DogCatCar@gmail.com', '58869', '58869', NULL, NULL, NULL),
(NULL, 'George', ' Cohen', 'DogCatGreen@gmail.com', '11758', '11758', NULL, NULL, NULL),
(NULL, 'Linda', ' Johnson', 'DogDancerCat@gmail.com', '92935', '92935', NULL, NULL, NULL),
(NULL, 'Linda', ' Smith', 'DogDog88@gmail.com', '48291', '48291', NULL, NULL, NULL),
(NULL, 'Linda', ' Summers', 'DogGreenBlue@gmail.com', '39289', '39289', NULL, NULL, NULL),
(NULL, 'David', ' LaForge', 'DogSkyBlue@gmail.com', '53761', '53761', NULL, NULL, NULL),
(NULL, 'Jane', ' Jones', 'Green2Green@gmail.com', '21044', '21044', NULL, NULL, NULL),
(NULL, 'David', ' Summers', 'Green2Sky@gmail.com', '29911', '29911', NULL, NULL, NULL),
(NULL, 'Linda', ' LaForge', 'Green88Blue@gmail.com', '53081', '53081', NULL, NULL, NULL),
(NULL, 'Sally', ' Jones', 'Green88Cat@gmail.com', '29842', '29842', NULL, NULL, NULL),
(NULL, 'Beth', ' LaForge', 'GreenCar88@gmail.com', '50517', '50517', NULL, NULL, NULL),
(NULL, 'Garth', ' Smith', 'GreenCarDog@gmail.com', '11530', '11530', NULL, NULL, NULL),
(NULL, 'Christina', ' Cohen', 'GreenCatDog@gmail.com', '42667', '42667', NULL, NULL, 'LukeCorp'),
(NULL, 'Jane', ' Meadows', 'GreenDancer2@gmail.com', '74391', '74391', NULL, NULL, NULL),
(NULL, 'Sally', ' Rockford', 'GreenDancer88@gmail.com', '43276', '43276', NULL, NULL, NULL),
(NULL, 'Christina', ' Smith', 'GreenDancerBlue@gmail.com', '58845', '58845', NULL, NULL, NULL),
(NULL, 'Bob', ' Meadows', 'GreenDogBlue@gmail.com', '95651', '95651', NULL, NULL, 'LukeCorp'),
(NULL, 'Bob', ' Cohen', 'GreenGreenSky@gmail.com', '48561', '48561', NULL, NULL, NULL),
(NULL, 'David', ' Brown', 'GreenSkyShrimp@gmail.com', '91791', '91791', NULL, NULL, NULL),
(NULL, 'yufeng', 'liu', 'renren@fd.com', '08854', '3123123', NULL, NULL, NULL),
(NULL, 'Bob', ' Cohen', 'Shrimp2Cat@gmail.com', '96398', '96398', NULL, NULL, NULL),
(NULL, 'George', ' Miller', 'Shrimp2Sky@gmail.com', '65425', '65425', NULL, NULL, NULL),
(NULL, 'Christina', ' Meadows', 'ShrimpBlueGreen@gmail.com', '79218', '79218', NULL, NULL, NULL),
(NULL, 'Linda', ' Brown', 'ShrimpCarDancer@gmail.com', '28387', '28387', NULL, NULL, NULL),
(NULL, 'Sam', ' Johnson', 'ShrimpCatGreen@gmail.com', '53580', '53580', NULL, NULL, NULL),
(NULL, 'Jane', ' Brown', 'ShrimpGreenShrimp@gmail.com', '72875', '72875', NULL, NULL, NULL),
(NULL, 'Christina', ' Jones', 'ShrimpShrimpSky@gmail.com', '90323', '90323', NULL, NULL, NULL),
(NULL, 'Jane', ' Miller', 'Sky288@gmail.com', '70151', '70151', NULL, NULL, NULL),
(NULL, 'Garth', ' Johnson', 'Sky88Green@gmail.com', '64591', '64591', NULL, NULL, NULL),
(NULL, 'Bob', ' Meadows', 'SkyCatGreen@gmail.com', '30307', '30307', NULL, NULL, NULL),
(NULL, 'Sally', ' Miller', 'SkyDancer2@gmail.com', '53112', '53112', NULL, NULL, NULL),
(NULL, 'George', ' Johnson', 'SkyDancerBlue@gmail.com', '88365', '88365', NULL, NULL, NULL),
(NULL, 'Bob', ' Rockford', 'SkyGreenCar@gmail.com', '20669', '20669', NULL, NULL, NULL),
(NULL, 'Sally', ' Cohen', 'SkyShrimpGreen@gmail.com', '70513', '70513', NULL, NULL, NULL),
(NULL, 'Jane', ' Smith', 'SkySkyGreen@gmail.com', '48237', '48237', NULL, NULL, 'LukeCorp'),
(NULL, 'luke', 'miller', 'tech@millerluke.com', '08904', '83787', NULL, NULL, NULL),
(NULL, 'test1', 'test2', 'test2@123.com', '12321', '123123213213', NULL, NULL, NULL),
(NULL, 'test', 'test', 'test@123.com', '123', '123123123', '31231', '123123', 'test'),
(NULL, 'yufeng', 'liu', 'test@1234.com', '08854', '312321312', NULL, NULL, NULL),
(NULL, 'yufeng', 'liu', 'test@12345.com', '08854', '12312', NULL, NULL, NULL),
(NULL, 'Luke', 'Miller', 'test@test.com', '08904', '6543234', NULL, NULL, NULL);

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
  `company` char(255) DEFAULT NULL,
  PRIMARY KEY (`License_Plate_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`Make`, `Model`, `year`, `Username`, `License_Plate_Number`, `company`) VALUES
('31231', '13123', 1994, 'test', '31231', NULL),
('Toyota', 'Model D', 1992, 'CarSky88@gmail.com', 'acn-cuu', NULL),
('Subaru', 'Escape', 2010, 'DogCarBlue@gmail.com', 'akp-ydx', NULL),
('Mercury', 'Model D', 1996, 'CarBlue2@gmail.com', 'ams-rjx', NULL),
('Toyota', 'Model D', 2005, 'SkyDancer2@gmail.com', 'avl-ems', NULL),
('Ford', 'Outback', 2013, 'CatDogGreen@gmail.com', 'bmv-rdo', NULL),
('Lexus', 'Impreza', 2007, 'CarDancerShrimp@gmail.com', 'bta-ppm', NULL),
('Tesla', 'Charger', 2006, '88DancerCat@gmail.com', 'btc-xnh', NULL),
('Mitsubishi', 'Forester', 1994, 'Green88Blue@gmail.com', 'byy-dil', NULL),
('Saturn', 'Civic', 1996, '2Car2@gmail.com', 'cgx-hhf', NULL),
('Tesla', 'Impreza', 1990, 'SkyGreenCar@gmail.com', 'cmw-eya', NULL),
('Mercury', 'Lancer', 2000, 'CatCatCar@gmail.com', 'dpf-bdd', NULL),
('Mercury', 'Outback', 2000, 'CarCarCat@gmail.com', 'dsw-uet', NULL),
('Honda', 'Charger', 1997, 'Shrimp2Sky@gmail.com', 'dyg-yda', NULL),
('Toyota', 'Model D', 2007, 'Dancer88Car@gmail.com', 'eei-gxj', NULL),
('Honda', 'Civic', 2014, 'Sky288@gmail.com', 'egy-fxe', NULL),
('Mitsubishi', 'Impreza', 2004, '88DancerCar@gmail.com', 'ekv-qpi', NULL),
('Honda', 'Charger', 2000, 'ShrimpCarDancer@gmail.com', 'etd-vdi', NULL),
('test', 'test1', 1932, 'test2@123.com', 'fdafds', NULL),
('Subaru', 'Model D', 2005, 'Green2Green@gmail.com', 'gsj-rhh', NULL),
('Mitsubishi', 'Model D', 1995, 'Cat2Car@gmail.com', 'gvn-xov', NULL),
('Mercury', 'Lancer', 2010, 'SkyCatGreen@gmail.com', 'hft-bdn', NULL),
('Mercury', 'Model D', 1996, 'DogSkyBlue@gmail.com', 'hhx-snp', NULL),
('Tesla', 'Camry', 2009, 'BlueCarSky@gmail.com', 'hih-qdf', NULL),
('Saturn', 'Escape', 1991, 'GreenGreenSky@gmail.com', 'hry-oex', NULL),
('Saturn', 'Camry', 2011, 'DogDog88@gmail.com', 'isq-fpz', NULL),
('Lexus', 'Camry', 2012, 'CarCatCar@gmail.com', 'itp-pfp', NULL),
('Toyota', 'Outback', 2012, '2Sky88@gmail.com', 'jog-ltv', NULL),
('Tesla', 'Model D', 1992, 'DancerDancerDancer@gmail.com', 'jvn-ynk', NULL),
('Mitsubishi', 'Charger', 2009, 'DancerBlueDog@gmail.com', 'koj-gyg', NULL),
('Mitsubishi', 'Forester', 1992, 'DogCatCar@gmail.com', 'kpc-uyh', NULL),
('Tesla', 'Outback', 2010, 'GreenDogBlue@gmail.com', 'kwo-tqr', NULL),
('Saturn', 'Escape', 2008, 'ShrimpGreenShrimp@gmail.com', 'lmu-uij', NULL),
('Mercury', 'Outback', 1992, 'Car2Shrimp@gmail.com', 'lud-brt', NULL),
('Honda', 'Lancer', 2003, 'GreenDancer88@gmail.com', 'lvi-uft', NULL),
('Ford', 'Escape', 2008, 'Green2Sky@gmail.com', 'mlw-xxv', NULL),
('Toyota', 'Civic', 2016, '88BlueSky@gmail.com', 'mux-xdb', NULL),
('Honda', 'Forester', 1992, 'Dog288@gmail.com', 'nfn-xmg', NULL),
('Chevy', 'Escape', 2016, 'BlueDancer2@gmail.com', 'nqk-kjm', NULL),
('Tesla', 'Charger', 2003, 'CatSky2@gmail.com', 'nqz-sjo', NULL),
('Saturn', 'Forester', 2008, 'GreenDancer2@gmail.com', 'oip-yls', NULL),
('Toyota', 'Escape', 1993, 'DancerGreenGreen@gmail.com', 'okt-slq', NULL),
('Lexus', 'Charger', 2009, 'BlueDogDancer@gmail.com', 'omd-orm', NULL),
('Toyota', 'Lancer', 2015, 'Blue2Dog@gmail.com', 'oon-mtn', NULL),
('Saturn', 'Camry', 1996, 'GreenCatDog@gmail.com', 'pbc-xye', NULL),
('Honda', 'Model D', 1990, 'ShrimpShrimpSky@gmail.com', 'qas-klp', NULL),
('Toyota', 'Model D', 2005, 'Sky88Green@gmail.com', 'qzd-cyy', NULL),
('Toyota', 'Charger', 2010, 'Car882@gmail.com', 'sce-rru', NULL),
('Honda', 'Model D', 2013, 'GreenSkyShrimp@gmail.com', 'tdj-ozj', NULL),
('Saturn', 'Impreza', 2008, 'Dog88Dancer@gmail.com', 'teg-tca', NULL),
('Subaru', 'Model D', 2005, '2GreenSky@gmail.com', 'tfw-wsq', NULL),
('Tesla', 'Impreza', 2001, 'CarBlueBlue@gmail.com', 'tut-bpc', NULL),
('Toyota', 'Impreza', 2013, 'CatBlueSky@gmail.com', 'tvh-jpn', NULL),
('Toyota', 'Impreza', 2001, 'BlueGreen2@gmail.com', 'tyd-ula', NULL),
('Honda', 'Lancer', 2005, 'DancerCarShrimp@gmail.com', 'tzt-tpu', NULL),
('Honda', 'Model D', 2012, 'DancerSkyBlue@gmail.com', 'uhf-uno', NULL),
('Subaru', 'Outback', 2003, 'test@test.com', 'uhy-243', NULL),
('Ford', 'Escape', 2006, 'CarBlueSky@gmail.com', 'ujp-orr', NULL),
('Chevy', 'Outback', 2006, 'Green2Sky@gmail.com', 'ups-tui', NULL),
('Tesla', 'Impreza', 1999, 'CarDancerCat@gmail.com', 'vos-fbm', NULL),
('Honda', 'Outback', 1993, 'DogDancerCat@gmail.com', 'vuf-kcd', NULL),
('Lexus', 'Outback', 2006, 'DogCatGreen@gmail.com', 'wbo-qhj', NULL),
('Chevy', 'Model D', 1996, 'SkySkyGreen@gmail.com', 'wip-mjz', NULL),
('Mitsubishi', 'Camry', 2013, '8888Car@gmail.com', 'wna-nwj', NULL),
('Lexus', 'Outback', 1997, 'CarCatDog@gmail.com', 'wnl-oju', NULL),
('Subaru', 'Lancer', 2015, 'GreenCarDog@gmail.com', 'wsr-jry', NULL),
('Ford', 'Escape', 1999, 'Green88Cat@gmail.com', 'wyv-zfn', NULL),
('Toyota', 'Impreza', 1993, 'DogCar2@gmail.com', 'xuj-ixn', NULL),
('Ford', 'Civic', 2003, 'GreenCar88@gmail.com', 'xze-lyw', NULL),
('Subaru', 'Model D', 1992, '2CatBlue@gmail.com', 'ybc-bpv', NULL),
('Saturn', 'Civic', 2002, '2CarShrimp@gmail.com', 'yys-bwn', NULL),
('Subaru', 'Model D', 2003, 'Cat88Cat@gmail.com', 'zuf-pcu', NULL),
('Saturn', 'Lancer', 1992, 'BlueDogGreen@gmail.com', 'zyv-wps', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
