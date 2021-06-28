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
-- Table structure for table `sarki`
--

DROP TABLE IF EXISTS `sarki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sarki` (
  `sarki_id` int NOT NULL AUTO_INCREMENT,
  `sarkiadi` varchar(255) NOT NULL,
  `turID` int DEFAULT NULL,
  `sanatci` varchar(255) DEFAULT NULL,
  `album_id` int DEFAULT NULL,
  `sure` int DEFAULT NULL,
  `dinlenmeSayisi` int DEFAULT NULL,
  `tarih` date DEFAULT NULL,
  PRIMARY KEY (`sarki_id`),
  KEY `fk_album_id` (`album_id`),
  KEY `fk_turID` (`turID`),
  CONSTRAINT `fk_album_id` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_turID` FOREIGN KEY (`turID`) REFERENCES `muzik_turu` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sarki`
--

LOCK TABLES `sarki` WRITE;
/*!40000 ALTER TABLE `sarki` DISABLE KEYS */;
INSERT INTO `sarki` VALUES (1,'Poset',1,'Serdar Ortac',1,3,454,'1999-02-02'),(2,'Dinle',1,'Mahsun Kirmizigul',2,2,46,'1999-02-02'),(3,'Mikrop',1,'Serdar Ortac',1,3,25,'1999-02-02'),(4,'Isim Olmaz',1,'Serdar Ortac',1,3,33,'1999-02-02'),(5,'Martilar',1,'Edis',3,3,455,'2021-05-02'),(6,'Olurum Sana',1,'Tarkan',4,4,515,'1999-02-02'),(7,'Simarik',1,'Tarkan',4,4,2,'2021-05-02'),(8,'Bos Yapma',1,'Zeynep Bastik',5,4,357,'1999-02-02'),(9,'Dusmanlarima',1,'Kum',6,4,2,'2021-05-02'),(10,'Yastik izi',1,'Kum',6,4,401,'1999-02-02'),(11,'Sar bu sehri',2,'Can Ozan',7,3,176,'1999-02-02'),(12,'Toprak yagmura',2,'Can Ozan',7,3,190,'1999-02-02'),(13,'Baktin olmuyo',2,'Can Ozan',7,3,214,'1999-02-02'),(14,'Ill go crazy',2,'Bruce Wills',8,3,491,'1999-02-02'),(15,'Save the last dance',2,'Bruce Wills',8,4,550,'1999-02-02'),(16,'Kafam karisik',2,'Yasli Amca',9,4,44,'1999-02-02'),(17,'Keder',2,'Yasli Amca',9,4,195,'1999-02-02'),(18,'Anla hain',2,'Yasli Amca',9,4,103,'1999-02-02'),(19,'Saatli bomba',2,'Elif ozcan',10,4,899,'1999-02-02'),(20,'Bana baktiginda',2,'Elif ozcan',10,4,736,'1999-02-02'),(21,'Made in turkey',3,'Murda',11,4,847,'1999-02-02'),(22,'Duman',3,'Murda',11,4,893,'1999-02-02'),(23,'Bi sonraki hayatimda gel',3,'Murda',11,4,713,'1999-02-02'),(24,'Seni dert etmeler',3,'Madrigal',12,4,314,'1999-02-02'),(25,'Kelebekler',3,'Madrigal',12,4,704,'1999-02-02'),(26,'Uzuvlar',3,'Evdeki saat',13,3,445,'1999-02-02'),(27,'Aya',3,'Ezhel',14,3,1000,'1999-02-02'),(28,'Kazidik tirnaklarla',3,'Ezhel',14,3,917,'1999-02-02'),(29,'Ciktim bi yola',3,'Nova Norda',15,3,945,'1999-02-02'),(30,'eski',3,'uclersaati',16,3,96,'1999-02-02');
/*!40000 ALTER TABLE `sarki` ENABLE KEYS */;
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
