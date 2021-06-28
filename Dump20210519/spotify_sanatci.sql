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
-- Table structure for table `sanatci`
--

DROP TABLE IF EXISTS `sanatci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanatci` (
  `sanatci_id` int NOT NULL AUTO_INCREMENT,
  `sanatci_adi` varchar(255) DEFAULT NULL,
  `ulke_id` int DEFAULT NULL,
  PRIMARY KEY (`sanatci_id`),
  KEY `fk_ulke_id` (`ulke_id`),
  CONSTRAINT `fk_ulke_id` FOREIGN KEY (`ulke_id`) REFERENCES `ulke` (`ulkeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanatci`
--

LOCK TABLES `sanatci` WRITE;
/*!40000 ALTER TABLE `sanatci` DISABLE KEYS */;
INSERT INTO `sanatci` VALUES (1,'Serdar Ortac',1),(2,'Mahsun Kirmizigul',1),(3,'Edis',1),(4,'Tarkan',1),(5,'Zeynep Bastik',1),(6,'Kum',2),(7,'Can Ozan',1),(8,'Bruce Wills',2),(9,'Yasli Amca',1),(10,'Elif ozcan',2),(11,'Murda',3),(12,'Ezhel',3),(13,'Madrigal',2),(14,'Evdeki saat',2),(15,'Nova Norda',3),(16,'uclersaati',3);
/*!40000 ALTER TABLE `sanatci` ENABLE KEYS */;
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
