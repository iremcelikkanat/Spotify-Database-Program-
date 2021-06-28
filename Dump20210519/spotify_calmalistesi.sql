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
-- Table structure for table `calmalistesi`
--

DROP TABLE IF EXISTS `calmalistesi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calmalistesi` (
  `calmalistesi_id` int NOT NULL AUTO_INCREMENT,
  `calmalistesi_adi` varchar(50) DEFAULT NULL,
  `olusturanID` int DEFAULT NULL,
  `tur_id` int DEFAULT NULL,
  PRIMARY KEY (`calmalistesi_id`),
  KEY `fk_calmalistesi_tur_id` (`tur_id`),
  KEY `fk_olusturanID` (`olusturanID`),
  CONSTRAINT `fk_calmalistesi_tur_id` FOREIGN KEY (`tur_id`) REFERENCES `muzik_turu` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_olusturanID` FOREIGN KEY (`olusturanID`) REFERENCES `kullanici` (`kullanici_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calmalistesi`
--

LOCK TABLES `calmalistesi` WRITE;
/*!40000 ALTER TABLE `calmalistesi` DISABLE KEYS */;
INSERT INTO `calmalistesi` VALUES (1,'pop',1,1),(2,'caz',1,2),(3,'klasik',1,3),(4,'pop',6,1),(5,'caz',6,2),(6,'klasik',6,3),(7,'pop',2,1),(8,'caz',2,2),(9,'klasik',2,3),(10,'pop',3,1),(11,'caz',3,2),(12,'klasik',3,3),(13,'pop',4,1),(14,'caz',4,2),(15,'klasik',4,3),(16,'pop',5,1),(17,'caz',5,2),(18,'klasik',5,3),(19,'pop',7,1),(20,'caz',7,2),(21,'klasik',7,3),(22,'pop',8,1),(23,'caz',8,2),(24,'klasik',8,3),(25,'pop',9,1),(26,'caz',9,2),(27,'klasik',9,3),(28,'pop',10,1),(29,'caz',10,2),(30,'klasik',10,3);
/*!40000 ALTER TABLE `calmalistesi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-19 20:49:08
