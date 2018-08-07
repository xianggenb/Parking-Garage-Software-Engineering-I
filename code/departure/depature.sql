-- MySQL dump 10.13  Distrib 5.5.47, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: depature
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `depature`
--

DROP TABLE IF EXISTS `depature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depature` (
  `LP` varchar(255) NOT NULL,
  `arrival` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `depature` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `email` varchar(255) NOT NULL,
  `payment` varchar(255) NOT NULL,
  `spot` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depature`
--

LOCK TABLES `depature` WRITE;
/*!40000 ALTER TABLE `depature` DISABLE KEYS */;
INSERT INTO `depature` VALUES ('wwj-tvd','2016-03-28 05:15:08','2016-03-28 06:15:09','769574822@qq.com','1234-1234-1234-1234',1,1),('urx-thg','2016-03-28 05:15:08','2016-03-28 06:15:09','769574822@qq.com','1234-1234-1234-1234',1,1),('urx-thg','2016-03-28 05:15:08','2016-03-28 06:15:09','769574822@qq.com','1234-1234-1234-1234',1,1),('urx-thg','2016-03-28 05:15:08','2016-03-28 06:15:09','769574822@qq.com','1234-1234-1234-1234',1,1),('urx-thg','2016-03-28 05:15:08','2016-03-28 06:15:09','769574822@qq.com','1234-1234-1234-1234',1,1),('urx-thg','2016-03-28 05:15:08','2016-03-28 06:15:09','769574822@qq.com','1234-1234-1234-1234',1,1),('urx-thg','2016-03-28 05:15:08','2016-03-28 06:15:09','769574822@qq.com','1234-1234-1234-1234',1,1);
/*!40000 ALTER TABLE `depature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS `spot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spot` (
  `LP` varchar(255) NOT NULL,
  `spot` int(255) NOT NULL,
  `status` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spot`
--

LOCK TABLES `spot` WRITE;
/*!40000 ALTER TABLE `spot` DISABLE KEYS */;
INSERT INTO `spot` VALUES ('A1234',1,0);
/*!40000 ALTER TABLE `spot` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26 20:53:33
