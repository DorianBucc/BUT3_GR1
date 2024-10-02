-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bankiuttest
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `compte`
--

DROP TABLE IF EXISTS `compte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compte` (
  `numeroCompte` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `solde` double NOT NULL,
  `avecDecouvert` varchar(5) NOT NULL,
  `decouvertAutorise` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`numeroCompte`),
  KEY `index_userClient` (`userId`),
  CONSTRAINT `fk_Compte_userId` FOREIGN KEY (`userId`) REFERENCES `utilisateur` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compte`
--

LOCK TABLES `compte` WRITE;
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` VALUES ('AB7328887341','j.doe2',4242,'AVEC',123),('AV1011011011','g.descomptes',5,'AVEC',100),('BD4242424242','j.doe1',100,'SANS',NULL),('CADNV00000','j.doe1',42,'AVEC',42),('CADV000000','j.doe1',0,'AVEC',42),('CSDNV00000','j.doe1',42,'SANS',NULL),('CSDV000000','j.doe1',0,'SANS',NULL),('IO1010010001','j.doe2',6868,'SANS',NULL),('KL4589219196','g.descomptesvides',0,'AVEC',150),('KO7845154956','g.descomptesvides',0,'SANS',NULL),('LA1021931215','j.doe1',100,'SANS',NULL),('MD8694030938','j.doe1',500,'SANS',NULL),('PP1285735733','a.lidell1',37,'SANS',NULL),('SA1011011011','g.descomptes',10,'SANS',0),('TD0398455576','j.doe1',23,'AVEC',500),('XD1829451029','j.doe1',-48,'AVEC',100);
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `userId` varchar(50) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `userPwd` varchar(45) DEFAULT NULL,
  `male` bit(1) NOT NULL,
  `type` varchar(10) NOT NULL,
  `numClient` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `numClient_UNIQUE` (`numClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES ('a.lidell1','Lidell','Alice','789, grande rue, Metz','/GvtzBIA3LdpSiMFRVWtKg==',_binary '','CLIENT','9865432100'),('admin','Smith','Joe','123, grande rue, Metz','x6qwzeIdPh4XpdzlZ4JnmA==',_binary '','MANAGER',''),('c.exist','TEST NOM','TEST PRENOM','TEST ADRESSE','l0iARKg2JwV3fOzTu/NKgA==',_binary '','CLIENT','0101010101'),('g.descomptes','TEST NOM','TEST PRENOM','TEST ADRESSE','l0iARKg2JwV3fOzTu/NKgA==',_binary '','CLIENT','1000000001'),('g.descomptesvides','TEST NOM','TEST PRENOM','TEST ADRESSE','l0iARKg2JwV3fOzTu/NKgA==',_binary '','CLIENT','0000000002'),('g.exist','TEST NOM','TEST PRENOM','TEST ADRESSE','l0iARKg2JwV3fOzTu/NKgA==',_binary '','CLIENT','1010101010'),('g.pasdecompte','TEST NOM','TEST PRENOM','TEST ADRESSE','l0iARKg2JwV3fOzTu/NKgA==',_binary '','CLIENT','5544554455'),('j.doe1','Doe','Jane','456, grand boulevard, Brest','/GvtzBIA3LdpSiMFRVWtKg==',_binary '','CLIENT','1234567890'),('j.doe2','Doe','John','457, grand boulevard, Perpignan','/GvtzBIA3LdpSiMFRVWtKg==',_binary '','CLIENT','0000000001');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02  9:34:29
