CREATE DATABASE  IF NOT EXISTS `pedaggiautostrade` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pedaggiautostrade`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pedaggiautostrade
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `amministratore` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `ChiaveRecupero` varchar(45) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Cognome` varchar(45) NOT NULL,
  `LuogoN` varchar(45) NOT NULL,
  `DataN` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES ('lorcar94','lorenzo94','igRTIc','lorenzo','caruso','avezzano','01-08-1994','3270895432'),('ludo196','random01','c1','Ludovico','Di Federico','Pescara','1996-10-01','3270544051');
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autostrada`
--

DROP TABLE IF EXISTS `autostrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autostrada` (
  `Codice` varchar(45) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `KmInizio` int(11) NOT NULL,
  `KmFine` int(11) NOT NULL,
  `Amministratore` varchar(45) NOT NULL,
  PRIMARY KEY (`Codice`),
  KEY `Amministratore_idx` (`Amministratore`),
  CONSTRAINT `Amministratore` FOREIGN KEY (`Amministratore`) REFERENCES `amministratore` (`Username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autostrada`
--

LOCK TABLES `autostrada` WRITE;
/*!40000 ALTER TABLE `autostrada` DISABLE KEYS */;
INSERT INTO `autostrada` VALUES ('A01','Autostrada del Sole','Collina',0,750,'ludo196'),('A24','Strada dei parchi','Montagna',751,900,'ludo196');
/*!40000 ALTER TABLE `autostrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carta`
--

DROP TABLE IF EXISTS `carta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carta` (
  `IBAN` varchar(45) NOT NULL,
  `Saldo` float NOT NULL,
  PRIMARY KEY (`IBAN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carta`
--

LOCK TABLES `carta` WRITE;
/*!40000 ALTER TABLE `carta` DISABLE KEYS */;
INSERT INTO `carta` VALUES ('IT098',0),('IT521691',30.5),('IT690',14.24);
/*!40000 ALTER TABLE `carta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casello`
--

DROP TABLE IF EXISTS `casello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casello` (
  `Coordinate` varchar(45) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Km` int(11) NOT NULL,
  `Autostrada` varchar(45) NOT NULL,
  PRIMARY KEY (`Coordinate`),
  KEY `Autostrada_idx` (`Autostrada`),
  CONSTRAINT `Autostrada` FOREIGN KEY (`Autostrada`) REFERENCES `autostrada` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casello`
--

LOCK TABLES `casello` WRITE;
/*!40000 ALTER TABLE `casello` DISABLE KEYS */;
INSERT INTO `casello` VALUES ('12 23 45 N 10 56 43 E','Milano',10,'A01'),('18 19 34 E 27 12 34 O','Napoli Casoria',700,'A01'),('34 32 56 S 12 13 14 E ','Frosinone',135,'A01'),('45 32 67 N 12 13 17 E','Tagliacozzo',800,'A24'),('47 12 34 S 12 19 32 O','Tornimparte',840,'A24');
/*!40000 ALTER TABLE `casello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oneri`
--

DROP TABLE IF EXISTS `oneri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oneri` (
  `Euro` int(11) NOT NULL,
  `Importo` float NOT NULL,
  `ValoreMin` float NOT NULL,
  `ValoreMax` float NOT NULL,
  PRIMARY KEY (`Euro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oneri`
--

LOCK TABLES `oneri` WRITE;
/*!40000 ALTER TABLE `oneri` DISABLE KEYS */;
INSERT INTO `oneri` VALUES (1,0,5.01,13),(2,0.05,4.01,5),(3,0.1,3.01,4),(4,0.15,2.01,3),(5,0.2,1.01,2),(6,0.28,0.01,1);
/*!40000 ALTER TABLE `oneri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedaggio`
--

DROP TABLE IF EXISTS `pedaggio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedaggio` (
  `ID` varchar(45) NOT NULL,
  `Stato` varchar(45) NOT NULL,
  `Importo` float NOT NULL,
  `Veicolo` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Veicolo_idx` (`Veicolo`),
  CONSTRAINT `Veicolo` FOREIGN KEY (`Veicolo`) REFERENCES `veicolo` (`Targa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedaggio`
--

LOCK TABLES `pedaggio` WRITE;
/*!40000 ALTER TABLE `pedaggio` DISABLE KEYS */;
INSERT INTO `pedaggio` VALUES ('P1','Pagato',14.34,'AY56ZE'),('P2','Pagato',11.76,'EX98MS'),('P3','Pagato',18.76,'AY56ZE'),('P4','Pagato',12,'EX98MS');
/*!40000 ALTER TABLE `pedaggio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariffa`
--

DROP TABLE IF EXISTS `tariffa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tariffa` (
  `Categoria` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Valore` float NOT NULL,
  PRIMARY KEY (`Categoria`,`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariffa`
--

LOCK TABLES `tariffa` WRITE;
/*!40000 ALTER TABLE `tariffa` DISABLE KEYS */;
INSERT INTO `tariffa` VALUES ('3','Collina',0.14),('3','Montagna',0.21),('4','Collina',0.22),('4','Montagna',0.25),('5','Collina',0.25),('5','Montagna',0.29),('A','Collina',0.11),('A','Montagna',0.15),('B','Collina',0.11),('B','Montagna',0.15);
/*!40000 ALTER TABLE `tariffa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `ChiaveRecupero` varchar(45) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Cognome` varchar(45) NOT NULL,
  `LuogoN` varchar(45) NOT NULL,
  `DataN` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Carta` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`),
  KEY `Carta_idx` (`Carta`),
  CONSTRAINT `Carta` FOREIGN KEY (`Carta`) REFERENCES `carta` (`IBAN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('lors10','totti10','c2','Lorenzo','Salvi','Teramo','1993-08-10','3468192604','IT521691'),('salvy1596','salvatore96','r2deO3','salvatore','salernitano','aversa','01-05-1996','3408698761','IT690'),('serena91','ser91','115l3g','serena','santa','avezzano','10-09-1987','3468976453','IT098');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veicolo`
--

DROP TABLE IF EXISTS `veicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veicolo` (
  `Targa` varchar(45) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Modello` varchar(45) NOT NULL,
  `Peso` int(11) NOT NULL,
  `Assi` int(11) NOT NULL,
  `Altezza` int(11) NOT NULL,
  `Anno` int(11) NOT NULL,
  `Categoria` varchar(45) NOT NULL,
  `qtaCO2` float NOT NULL,
  `Oneri` int(11) NOT NULL,
  `Utente` varchar(45) NOT NULL,
  PRIMARY KEY (`Targa`),
  KEY `Oneri_idx` (`Oneri`),
  KEY `Utente_idx` (`Utente`),
  CONSTRAINT `Oneri` FOREIGN KEY (`Oneri`) REFERENCES `oneri` (`Euro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Utente` FOREIGN KEY (`Utente`) REFERENCES `utente` (`Username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicolo`
--

LOCK TABLES `veicolo` WRITE;
/*!40000 ALTER TABLE `veicolo` DISABLE KEYS */;
INSERT INTO `veicolo` VALUES ('AY56ZE','Ford','X-1',2500,2,140,2010,'B',0.7,4,'salvy1596'),('EX98MS','Fiat','4x4',1250,2,145,1998,'B',0.8,3,'salvy1596');
/*!40000 ALTER TABLE `veicolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-11 12:53:27
