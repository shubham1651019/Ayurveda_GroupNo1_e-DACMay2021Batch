-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: ayudb
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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age_name` varchar(100) NOT NULL,
  `city_name` varchar(100) NOT NULL,
  `contact_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,'23','dhule','7846536373','manu@gmail.com','mansi','shinde','$2a$10$JOi90Jp4J.ArGkq1gjTY1eyx966jhHqFTMLsTB7XJsujQtN8Ww1n.'),(5,'23','pune','8056347846','askhi@gmail.com','akshi','fulpaagare','$2a$10$sJ5kcCDCTKKDsOkpi34i0.TjWP9akLw1ORPtdkzZ1bjsEA/QuG052'),(6,'23','goa','7085673856','ram@gmail.com','ram','jadhav','$2a$10$U3twB4HQWXphwQcB1zobK.ru/6dFA9raOLluOf9il2qnZM0G8eZgy'),(7,'24','surat','7084367788','nisha@gmail.com','nisha','relan','$2a$10$YcN.2gZIa2a2oCCF.lLuvOcKyqJyL1ujd74L.CLeLk310swZg/1xS'),(8,'35','mumbai','8036578896','kajal@gmail.com','kajal','rathod','$2a$10$bBfW4lWh1zguJavTrpU/TOEas0N5gBwBshVgn0mAMokr5IWOibgY2'),(9,'25','baroda','7846536373','pooja@gmail.com','pooja','belsare','$2a$10$D/aQILwNi1MJzggbjIS/Z.ug7rFwM0DIZvZQBI1E4U8bGKZEdSer.'),(11,'25','pune','7804536783','jayu@gmail.com','Jayeshree','Patil','$2a$10$sMrILbrVD0NKaI5k4Vd5ne4vcK.Y8qeUMsnbh8EBpyw3L2rDE6jdK');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-27 13:01:33
