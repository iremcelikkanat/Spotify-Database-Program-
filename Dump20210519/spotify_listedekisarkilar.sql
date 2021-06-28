-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: spotify
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `listedekisarkilar`
--

DROP TABLE IF EXISTS `listedekisarkilar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listedekisarkilar` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `kullanicilarID` int DEFAULT NULL,
  `sarkilarID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_kullanicilarID` (`kullanicilarID`),
  KEY `fk_sarkilarID` (`sarkilarID`),
  CONSTRAINT `fk_kullanicilarID` FOREIGN KEY (`kullanicilarID`) REFERENCES `kullanici` (`kullanici_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sarkilarID` FOREIGN KEY (`sarkilarID`) REFERENCES `sarki` (`sarki_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listedekisarkilar`
--

LOCK TABLES `listedekisarkilar` WRITE;
/*!40000 ALTER TABLE `listedekisarkilar` DISABLE KEYS */;
INSERT INTO `listedekisarkilar` VALUES (58,2,1),(59,8,1),(60,1,3),(61,1,1),(62,8,22),(63,8,13),(64,8,3),(65,1,5),(66,2,5),(67,2,3),(68,6,5),(69,6,1),(70,7,6),(71,7,1),(72,6,7),(73,6,9),(74,6,8),(75,6,27),(76,6,3),(77,8,5),(78,5,3),(79,5,1),(80,5,5),(81,3,10),(82,3,9),(83,3,12),(84,3,18),(85,3,30),(86,3,29),(87,4,2),(88,4,6),(89,4,15),(90,4,14),(91,4,24),(92,4,26),(93,4,21),(94,6,14),(95,6,20),(96,6,19),(97,6,23),(98,7,8),(99,7,22),(100,7,20),(101,7,19),(102,7,11),(103,8,15),(104,9,8),(105,9,17),(106,9,16),(107,9,21),(108,9,22),(109,10,5),(110,10,7),(111,10,13),(112,10,19),(113,10,23),(114,10,24),(115,1,15),(116,1,20),(117,1,19),(118,1,28),(119,1,29),(120,1,30),(121,8,20);
/*!40000 ALTER TABLE `listedekisarkilar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-19 20:49:07
