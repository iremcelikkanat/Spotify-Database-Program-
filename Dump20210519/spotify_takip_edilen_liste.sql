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
-- Table structure for table `takip_edilen_liste`
--

DROP TABLE IF EXISTS `takip_edilen_liste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `takip_edilen_liste` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `kullanici_id` int DEFAULT NULL,
  `calmalistesi_id` int DEFAULT NULL,
  `sarkilar_id` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_kullanici_id` (`kullanici_id`),
  KEY `fk_calmalistesi_id` (`calmalistesi_id`),
  CONSTRAINT `fk_calmalistesi_id` FOREIGN KEY (`calmalistesi_id`) REFERENCES `calmalistesi` (`calmalistesi_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_kullanici_id` FOREIGN KEY (`kullanici_id`) REFERENCES `kullanici` (`kullanici_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `takip_edilen_liste`
--

LOCK TABLES `takip_edilen_liste` WRITE;
/*!40000 ALTER TABLE `takip_edilen_liste` DISABLE KEYS */;
INSERT INTO `takip_edilen_liste` VALUES (1,8,22,5),(2,3,10,10),(3,3,10,9),(4,3,10,12),(5,3,10,18),(6,3,10,30),(7,3,10,29),(8,4,13,2),(9,4,13,6),(10,4,13,15),(11,4,13,14),(12,4,13,24),(13,4,13,26),(14,4,13,21),(15,6,4,14),(16,6,4,20),(17,6,4,19),(18,6,4,23),(19,7,19,8),(20,7,19,22),(21,7,19,20),(22,7,19,19),(23,7,19,11),(24,8,22,15),(25,9,25,8),(26,9,25,17),(27,9,25,16),(28,9,25,21),(29,9,25,22),(30,10,28,5),(31,10,28,7),(32,10,28,13),(33,10,28,19),(34,10,28,23),(35,10,28,24),(36,1,2,15),(37,1,1,20),(38,1,1,19),(39,1,1,28),(40,1,1,29),(41,1,1,30),(42,8,22,20);
/*!40000 ALTER TABLE `takip_edilen_liste` ENABLE KEYS */;
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
