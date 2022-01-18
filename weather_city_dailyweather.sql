-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: weather
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `city_dailyweather`
--

DROP TABLE IF EXISTS `city_dailyweather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_dailyweather` (
  `name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `tempMax` varchar(45) NOT NULL,
  `tempMin` varchar(45) NOT NULL,
  `textDay` varchar(45) NOT NULL,
  PRIMARY KEY (`name`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_dailyweather`
--

LOCK TABLES `city_dailyweather` WRITE;
/*!40000 ALTER TABLE `city_dailyweather` DISABLE KEYS */;
INSERT INTO `city_dailyweather` VALUES ('上海','2022-01-11','6','0','晴'),('上海','2022-01-12','8','2','晴'),('上海','2022-01-13','6','0','多云'),('上海','2022-01-14','7','1','阴'),('上海','2022-01-15','11','4','阴'),('上海','2022-01-16','11','6','多云'),('上海','2022-01-17','11','5','阴'),('上海','2022-01-18','11','5','晴'),('上海','2022-01-19','14','5','多云'),('上海','2022-01-20','10','4','多云'),('北京','2022-01-11','0','-8','晴'),('北京','2022-01-12','2','-7','晴'),('北京','2022-01-13','4','-7','晴'),('北京','2022-01-14','4','-6','晴'),('北京','2022-01-15','3','-8','晴'),('北京','2022-01-16','1','-7','多云'),('北京','2022-01-17','4','-7','晴'),('北京','2022-01-18','3','-7','晴'),('北京','2022-01-19','0','-8','多云'),('北京','2022-01-20','0','-7','多云'),('福州','2022-01-11','16','6','多云'),('福州','2022-01-12','12','8','多云'),('福州','2022-01-13','15','7','多云'),('福州','2022-01-14','15','7','多云'),('福州','2022-01-15','20','11','多云'),('福州','2022-01-16','15','11','小雨'),('福州','2022-01-17','12','11','阴'),('福州','2022-01-18','13','11','小雨'),('福州','2022-01-19','18','11','多云'),('福州','2022-01-20','16','11','阴');
/*!40000 ALTER TABLE `city_dailyweather` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-18 12:08:44
