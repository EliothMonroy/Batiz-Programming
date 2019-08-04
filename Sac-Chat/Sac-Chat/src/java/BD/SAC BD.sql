CREATE DATABASE  IF NOT EXISTS `saclife` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `saclife`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: saclife
-- ------------------------------------------------------
-- Server version	5.7.4-m14

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
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `id_evento` int(11) NOT NULL,
  `id_creador` varchar(100) CHARACTER SET utf8 NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descripcion` text NOT NULL,
  `tipo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (1,'1','2015-03-15 05:45:11','Consulta creada a un usuario no registrado',0,0),(2,'1','2015-03-15 05:45:12','Consulta creada a un usuario no registrado',0,0),(3,'1','2015-03-15 05:45:14','Consulta creada a un usuario no registrado',0,0),(4,'2','2015-03-15 06:03:03','Consulta creada a un usuario no registrado',0,0),(5,'2','2015-03-15 06:03:17','Consulta creada a un usuario no registrado',0,0),(6,'2','2015-03-15 06:07:56','Consulta creada a un usuario no registrado',0,0),(7,'1','2015-03-15 06:22:51','Consulta creada a un usuario registrado pero sin agenda',1,1),(8,'1','2015-03-15 06:28:40','Consulta creada a un usuario no registrado',0,0),(9,'1','2015-03-15 06:30:01','Consulta creada a un usuario registrado pero sin agenda',1,1),(10,'2','2015-03-15 06:38:58','Consulta creada a un usuario no registrado',0,0),(11,'2','2015-03-15 06:40:21','Consulta creada a un usuario no registrado',0,0),(12,'2','2015-03-15 06:40:35','Consulta creada a un usuario no registrado',0,0),(13,'2','2015-03-15 06:40:39','Consulta creada a un usuario no registrado',0,0),(14,'2','2015-03-15 06:42:13','Consulta creada a un usuario no registrado',0,0),(15,'2','2015-03-15 06:42:19','Consulta creada a un usuario no registrado',0,0),(16,'2','2015-03-15 06:42:34','Consulta creada a un usuario no registrado',0,0),(17,'2','2015-03-15 06:44:11','Consulta creada a un usuario no registrado',0,0),(18,'2','2015-03-15 06:44:24','Consulta creada a un usuario no registrado',0,0),(19,'2','2015-03-15 06:52:54','Consulta creada a un usuario no registrado',0,0),(20,'2','2015-03-15 06:54:05','Consulta creada a un usuario no registrado',0,0),(21,'2','2015-03-15 07:32:27','Consulta creada a un usuario registrado pero sin agenda',1,1),(22,'2','2015-03-15 07:34:00','Consulta creada a un usuario registrado pero sin agenda',1,1),(23,'2','2015-03-15 23:17:21','Consulta creada a un usuario registrado pero sin agenda',1,1),(24,'2','2015-03-15 23:18:45','Consulta creada a un usuario no registrado',0,0),(25,'2','2015-03-15 23:22:56','Consulta creada a un usuario no registrado',0,0),(26,'2','2015-03-15 23:25:06','Consulta creada a un usuario no registrado',0,0),(27,'2','2015-03-16 00:06:19','Consulta creada a un usuario no registrado',0,0),(28,'2','2015-03-16 00:07:40','Consulta creada a un usuario registrado pero sin agenda',1,1),(29,'1','2015-03-16 00:08:18','Consulta creada a un usuario registrado pero sin agenda',1,1),(30,'1','2015-03-16 00:08:20','Consulta creada a un usuario registrado pero sin agenda',1,1),(31,'1','2015-03-16 00:08:21','Consulta creada a un usuario registrado pero sin agenda',1,1),(32,'1','2015-03-16 00:08:22','Consulta creada a un usuario registrado pero sin agenda',1,1),(33,'1','2015-03-16 00:08:23','Consulta creada a un usuario registrado pero sin agenda',1,1),(34,'1','2015-03-16 00:08:24','Consulta creada a un usuario registrado pero sin agenda',1,1),(35,'1','2015-03-16 00:08:24','Consulta creada a un usuario registrado pero sin agenda',1,1),(36,'1','2015-03-16 00:08:25','Consulta creada a un usuario registrado pero sin agenda',1,1),(37,'1','2015-03-16 00:10:55','Consulta creada a un usuario registrado pero sin agenda',1,1),(38,'1','2015-03-16 00:10:57','Consulta creada a un usuario registrado pero sin agenda',1,1),(39,'1','2015-03-16 00:10:59','Consulta creada a un usuario registrado pero sin agenda',1,1),(40,'1','2015-03-16 00:11:00','Consulta creada a un usuario registrado pero sin agenda',1,1),(41,'2','2015-03-16 00:11:06','Consulta creada a un usuario registrado pero sin agenda',1,1),(42,'2','2015-03-16 00:12:28','Consulta creada a un usuario registrado pero sin agenda',1,1),(43,'2','2015-03-16 00:14:10','Consulta creada a un usuario registrado pero sin agenda',1,1),(44,'2','2015-03-16 00:14:28','Consulta creada a un usuario registrado pero sin agenda',1,1),(45,'2','2015-03-16 00:24:20','Consulta creada a un usuario registrado pero sin agenda',1,1),(46,'2','2015-03-16 00:26:13','Consulta creada a un usuario registrado pero sin agenda',1,1),(47,'2','2015-03-16 00:27:00','Consulta creada a un usuario registrado pero sin agenda',1,1),(48,'2','2015-03-16 00:29:14','Consulta creada a un usuario registrado pero sin agenda',1,1),(49,'2','2015-03-16 00:32:14','Consulta creada a un usuario registrado pero sin agenda',1,1),(50,'2','2015-03-16 00:39:47','Consulta creada a un usuario registrado pero sin agenda',1,1),(51,'2','2015-03-16 01:14:04','Consulta creada a un usuario registrado pero sin agenda',1,1),(52,'2','2015-03-16 01:15:18','Consulta creada a un usuario registrado pero sin agenda',1,1),(53,'2','2015-03-16 01:19:48','Consulta creada a un usuario registrado pero sin agenda',1,1),(54,'2','2015-03-16 01:21:40','Consulta creada a un usuario registrado pero sin agenda',1,1),(55,'2','2015-03-16 01:21:57','Consulta creada a un usuario registrado pero sin agenda',1,1),(56,'2','2015-03-16 01:58:00','Consulta creada a un usuario registrado pero sin agenda',1,1),(57,'2','2015-03-16 01:58:12','Consulta creada a un usuario registrado pero sin agenda',1,1),(58,'1','2015-03-16 02:01:19','Consulta creada a un usuario registrado pero sin agenda',1,1),(59,'1','2015-03-16 18:31:29','Consulta creada a un usuario registrado pero sin agenda',1,1),(60,'1','2015-03-16 18:35:01','Consulta creada a un usuario registrado pero sin agenda',1,1),(61,'1','2015-03-16 18:35:18','Consulta creada a un usuario registrado pero sin agenda',1,1),(62,'1','2015-03-16 18:47:32','Consulta creada a un usuario no registrado',0,0),(63,'1','2015-03-16 18:52:19','Consulta creada a un usuario registrado pero sin agenda',1,1),(64,'1','2015-03-16 22:05:32','Consulta creada a un usuario registrado pero sin agenda',1,1),(65,'1','2015-03-16 22:10:56','Dar de alta un usuario y crear su primer consulta',1,0),(66,'1','2015-03-16 22:12:26','Dar de alta un usuario y crear su primer consulta',1,0),(67,'1','2015-03-16 22:18:34','Dar de alta un usuario y crear su primer consulta',1,0),(68,'1','2015-03-16 22:21:54','Dar de alta un usuario y crear su primer consulta',1,0),(69,'1','2015-03-16 22:22:00','Dar de alta un usuario y crear su primer consulta',1,0),(70,'1','2015-03-16 22:25:25','Dar de alta un usuario y crear su primer consulta',1,0),(71,'1','2015-03-17 00:57:18','Dar de alta un usuario y crear su primer consulta',1,0),(72,'1','2015-03-17 00:57:27','Dar de alta un usuario y crear su primer consulta',1,0),(73,'1','2015-03-17 18:31:53','Dar de alta un usuario y crear su primer consulta',1,0),(74,'2','2015-03-17 18:47:41','Dar de alta un usuario y crear su primer consulta',1,0),(75,'2','2015-03-17 18:48:50','Dar de alta un usuario y crear su primer consulta',1,0),(76,'2','2015-03-18 02:37:32','Dar de alta un usuario y crear su primer consulta',1,0),(77,'2','2015-03-18 03:08:30','Dar de alta un usuario y crear su primer consulta',1,0),(78,'2','2015-03-18 03:35:18','Dar de alta un usuario y crear su primer consulta',1,0),(79,'2','2015-03-18 03:38:54','Dar de alta un usuario y crear su primer consulta',1,0),(80,'2','2015-03-18 03:57:15','Consulta creada a un usuario registrado pero sin agenda',1,1),(81,'2','2015-03-18 04:02:16','Consulta creada a un usuario registrado pero sin agenda',1,1),(82,'2','2015-03-18 04:06:22','Consulta creada a un usuario registrado pero sin agenda',1,1),(83,'2','2015-03-18 04:10:32','Consulta creada a un usuario registrado pero sin agenda',1,1),(84,'2','2015-03-18 04:13:05','Consulta creada a un usuario registrado pero sin agenda',1,1),(85,'2','2015-03-18 04:14:21','Consulta creada a un usuario registrado pero sin agenda',1,1),(86,'2','2015-03-25 01:14:54','Consulta creada a un usuario registrado pero sin agenda',1,0),(87,'2','2015-03-18 04:25:49','Consulta creada a un usuario registrado pero sin agenda',1,1),(88,'2','2015-03-18 04:31:03','Consulta creada a un usuario registrado pero sin agenda',1,1),(89,'2','2015-03-18 04:34:00','Consulta creada a un usuario registrado pero sin agenda',1,1),(90,'2','2015-03-18 04:42:22','Consulta creada a un usuario registrado pero sin agenda',1,1),(91,'2','2015-03-18 04:44:45','Consulta creada a un usuario registrado pero sin agenda',1,1),(92,'2','2015-03-18 04:50:41','Consulta creada a un usuario registrado pero sin agenda',1,1),(93,'1','2015-03-19 04:10:57','Consulta creada a un usuario registrado pero sin agenda',1,1),(94,'1','2015-03-19 04:10:59','Consulta creada a un usuario registrado pero sin agenda',1,1),(95,'2','2015-03-19 04:12:24','Consulta creada a un usuario registrado pero sin agenda',1,1),(96,'2','2015-03-19 04:14:24','Consulta creada a un usuario registrado pero sin agenda',1,1),(97,'1','2015-03-19 20:00:37','Dar de alta un usuario y crear su primer consulta',1,0),(98,'2','2015-03-19 20:01:16','Dar de alta un usuario y crear su primer consulta',1,0),(99,'2','2015-03-19 20:03:47','Dar de alta un usuario y crear su primer consulta',1,0),(100,'2','2015-03-19 20:06:57','Consulta creada a un usuario registrado pero sin agenda',1,1),(101,'2','2015-03-19 20:07:11','Consulta creada a un usuario registrado pero sin agenda',1,1),(102,'2','2015-03-25 01:24:35','Consulta creada a un usuario registrado pero sin agenda',1,0),(103,'2','2015-03-20 23:21:01','Dar de alta un usuario y crear su primer consulta',1,1),(104,'2','2015-03-20 20:15:21','Consulta creada a un usuario registrado pero sin agenda',1,1),(105,'2','2015-03-25 00:32:43','Consulta creada a un usuario registrado pero sin agenda',1,0),(106,'2','2015-03-20 20:37:54','Dar de alta un usuario y crear su primer consulta',1,0),(107,'2','2015-03-25 01:32:19','Consulta creada a un usuario registrado pero sin agenda',1,0),(108,'2','2015-03-25 01:33:11','Consulta creada a un usuario registrado pero sin agenda',1,1),(109,'2','2015-03-25 01:40:32','Dar de alta un usuario y crear su primer consulta',1,1),(110,'2','2015-03-25 01:43:33','Dar de alta un usuario y crear su primer consulta',1,1),(111,'2','2015-03-25 01:45:19','Dar de alta un usuario y crear su primer consulta',1,1);
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cambios`
--

DROP TABLE IF EXISTS `cambios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cambios` (
  `id_empleado` int(11) NOT NULL,
  `tabla_cambio` varchar(50) CHARACTER SET utf8 NOT NULL,
  `id_cosa` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cambios`
--

LOCK TABLES `cambios` WRITE;
/*!40000 ALTER TABLE `cambios` DISABLE KEYS */;
/*!40000 ALTER TABLE `cambios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id_chat` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_chat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_video`
--

DROP TABLE IF EXISTS `chat_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat_video` (
  `id_chat` int(11) NOT NULL,
  `duracion` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_chat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_video`
--

LOCK TABLES `chat_video` WRITE;
/*!40000 ALTER TABLE `chat_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 NOT NULL,
  `contra` varchar(200) CHARACTER SET utf8 NOT NULL,
  `nombre_cliente` varchar(50) CHARACTER SET utf8 NOT NULL,
  `tipo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_registro` date NOT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 NOT NULL,
  `telefono` varchar(100) CHARACTER SET utf8 NOT NULL,
  `logo` varchar(200) CHARACTER SET utf8 NOT NULL,
  `slogan` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '#SACyourhealth',
  `premium` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `id_consulta` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `id_paciente` varchar(100) CHARACTER SET utf8 NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `peso` float NOT NULL,
  `estatura` float NOT NULL,
  `descripcion` varchar(300) CHARACTER SET utf8 NOT NULL,
  `id_enfermedad` int(11) NOT NULL,
  PRIMARY KEY (`id_consulta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` VALUES (0,8,9,1,'1',1,16,58,'1',1),(23,37,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(24,38,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(25,39,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(26,40,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(27,41,1,2,'1',45,89,167,'Pues me tarde',1),(28,42,1,2,'1',45,99,99,'kiko',16),(29,43,1,2,'1',99,8,0,'00',0),(30,44,1,2,'1',99,8,0,'00',0),(31,45,1,2,'1',3,6,6,'Crenado receta',15),(32,46,1,2,'1',78,88,99,'creando receta 2',10),(33,47,1,2,'1',9,5,7,'yy',12),(34,48,1,2,'1',77,88,88,'888',0),(35,49,1,2,'1',787,89,89,'jjjdd',16),(36,50,1,2,'1',595,909,89,'kaka',0),(37,51,1,2,'1',89,9,9,'juan',4),(38,52,1,2,'1',6,6,6,'6',0),(39,53,1,2,'1',3399,99,99,'jj',13),(40,54,1,2,'1',9,9,9,'9',0),(41,55,1,2,'1',8,8,8,'8',0),(42,56,1,2,'1',556,56,56,'Yeah',0),(43,57,1,2,'1',556,56,56,'Yeah',0),(44,58,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(45,59,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(46,60,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(47,61,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(49,63,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(50,64,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(51,65,1,1,'0',16,58,2,'Anotaciones prueba',3),(52,66,1,1,'0',16,58,2,'Anotaciones prueba',3),(53,67,1,1,'1',16,58,2,'Anotaciones prueba',3),(54,68,1,1,'1',16,58,2,'Anotaciones prueba',3),(55,70,1,1,'1',16,58,2,'Anotaciones prueba',3),(56,71,1,1,'3',16,58,2,'Anotaciones prueba',3),(57,72,1,1,'3',16,58,2,'Anotaciones prueba',3),(58,73,1,1,'3',16,58,2,'Anotaciones prueba',3),(59,74,1,2,'4',40,87,67,'No ha subido de peso',0),(60,75,1,2,'4',40,55,156,'Si ha subido de peso!',2),(61,76,1,2,'4',45,56,22,'kokokokokk',16),(62,77,1,2,'4',8,8,8,'BABLA',13),(63,78,1,2,'4',8,8,8,'dasdasd',0),(64,79,1,2,'5',67,67,67,'yeah ababy',13),(65,80,1,2,'1',78,9999,99,'jju',0),(66,81,1,2,'4',787,8787,787,'hjhjhjh',0),(67,82,1,2,'1',6,6,6,'6',0),(68,83,1,2,'1',8,8,8,'jjj',0),(69,84,1,2,'1',7,7,7,'jjjjj',0),(70,85,1,2,'1',7,7,7,'7',0),(71,86,1,2,'4',8,8,8,'8',0),(72,87,1,2,'1',8,8,8,'8',0),(73,88,1,2,'1',7,7,7,'7',0),(74,89,1,2,'1',6,6,6,'jjj',0),(75,90,1,2,'5',7,7,7,'7',0),(76,91,1,2,'5',5,5,5,'jjjj',0),(77,92,1,2,'1',7,7,7,'7',4),(78,93,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(79,94,1,1,'1',16,58,1,'Anotaciones prueba con devuelta de id',1),(80,95,1,2,'4',77,99,77,'99999',0),(81,96,1,2,'5',778,99,90,'jajaj',0),(82,97,1,1,'3',16,58,2,'Anotaciones prueba',3),(83,98,1,2,'3',16,58,2,'Anotaciones prueba',3),(84,99,1,2,'6',16,58,2,'Anotaciones prueba',3),(85,100,1,2,'7',16,58,1,'Anotaciones prueba con devuelta de id',1),(86,101,1,2,'7',16,58,1,'Anotaciones prueba con devuelta de id',1),(87,102,1,2,'4',78,78,78,'jjaua',11),(88,103,1,2,'9',89,89,89,'Pues esta estable',0),(89,104,1,2,'5',8,8,8,'jajaja',13),(90,105,1,2,'6',777,666,666,'La consulta ha sido modificada dos veces',16),(91,106,1,2,'6',16,58,2,'Anotaciones prueba',3),(92,107,1,2,'4',40,78,155,'Prueba final para alta ya modificada',13),(93,108,1,2,'5',888,888,888,'jjjj',15),(94,109,1,2,'10',15,23,78,'Eras mi amor platÃ?Â³nico pero modifique esta seccion y ahora no lo eres',1),(95,110,1,2,'10',7,7,7,'Consulta express nueva con uno que ya tenia y es sharon',0),(96,111,1,2,'10',9,9,9,'ya correji express y estado=1',0);
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contactos` (
  `id_contacto` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 NOT NULL,
  `correo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `telefono` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion_cliente`
--

DROP TABLE IF EXISTS `direccion_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion_cliente` (
  `id_direccion` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 NOT NULL,
  `tipo` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'Direccion secundaria',
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion_cliente`
--

LOCK TABLES `direccion_cliente` WRITE;
/*!40000 ALTER TABLE `direccion_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `direccion_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direcciones` (
  `id_direccion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT 'Sin Especificar Dirección :/',
  `tipo` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'Dirección principal',
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergencia`
--

DROP TABLE IF EXISTS `emergencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emergencia` (
  `id_emergencia` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ubicacion` varchar(500) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_emergencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergencia`
--

LOCK TABLES `emergencia` WRITE;
/*!40000 ALTER TABLE `emergencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `emergencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `grado_estudios` varchar(100) CHARACTER SET utf8 NOT NULL,
  `especialidad` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT 'Ninguna',
  `institucion` varchar(100) CHARACTER SET utf8 NOT NULL,
  `cedula_profesional` varchar(120) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (2,'Universidad','Ninguna','IPN','Cedula Admi 1');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfermedades`
--

DROP TABLE IF EXISTS `enfermedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfermedades` (
  `id_enfermedad` int(11) NOT NULL,
  `enfermedad` varchar(30) CHARACTER SET utf8 NOT NULL,
  `descripcion` varchar(300) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_enfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermedades`
--

LOCK TABLES `enfermedades` WRITE;
/*!40000 ALTER TABLE `enfermedades` DISABLE KEYS */;
INSERT INTO `enfermedades` VALUES (0,'Sano','Sin enfermedad riesgosa'),(1,'Accidentes y lesiones','Existen una gran variedad de lesiones como consecuencia de accidentes, tales como quemaduras, intoxicaciones, traumatismos, etc., constituyendo en ocasiones, importantes problemas para la salud.'),(2,'Aparato Digestivos','Cirrosis, hepatitis, estreñimiento.'),(3,'Aparato Respitratorio','Las enfermedades que afectan a la vía respiratoria, desde los procesos de vías altas hasta los más graves por afectar al árbol bronquial y los pulmones, suponen una gran parte de las consultas médicas...'),(4,'Cardiovasculares','Las enfermedades cardiovasculares son las que pueden afectar a nuestro corazón y al sistema circulatorio: venas, arterias, etc.'),(5,'Dematologia','La Piel es nuestro órgano más grande, nos protege contra la luz, el sol el frío, por ello debemos protegerla.'),(6,'Endocrinologia y Nutricion','Enfermedades habitualmente englobadas en trastornos de hormonas o del metabolismo se exponen en este capítulo para avanzar en el conocimiento de sus síntomas más frecuentes, los procedimientos diagnósticos y terapéuticos habituales y los consejos de prevención que pueden evitar el desarrollo de este'),(7,'ETSs','Las enfermedades de transmisión sexual son infecciones que se adquieren por tener relaciones sexuales con alguien que esté infectado. Pueden afectar tanto a hombres como a mujeres.'),(8,'Enfermedades Infecciones','Nuestro organismo tiene mecanismos de defensa (sistema inmunológico) para defenderse de agentes como bacterias, virus, hongos. A veces éstos encuentran en el organismo condiciones favorables, y provocan enfermedades infecciosas.'),(9,'Ematologia','Muchas son las funciones que tiene la sangre, y muchas las alteraciones que puede sufrir, como alteraciones de los glóbulos rojos (anemias), glóbulos blancos y plaquetas. La hematología además, también abarca enfermedades oncológicas (linfomas, mielomas, leucemias...)'),(10,'Huesos, articulaciones y muscu','Patologías como la osteoporosis, las artritis, la espondilitis anquilopoyética, etc merecen un espacio donde se describan sus síntomas, las pruebas diagnósticas más habituales y las opciones de tratamiento más actuales y eficaces para cada paciente.'),(11,'Oftalmologia','Es la especialidad que estudia las enfermedades oculares y sus tratamientos'),(12,'Otorrinolaringologia','Es la especialidad de la garganta, nariz y odio que trata enfermedades tan comunes como la otitis, hasta los cánceres de cuello y laringe'),(13,'Psiquiatria','Depresión, manía, esquizofrenia... son términos que utilizamos todos los día para referirnos a las alteraciones anímicas y de comportamiento. A continuación se exponen conceptos de interés sobre estas y otras enfermedades que afectan a la salud mental.'),(14,'Sistema Nervioso','Patologías como parkinson, hemorragia intracraneal, trastornos del sueño, accidente cerebrovascular, etc..'),(15,'Urologia','La insuficiencia renal aguda es un deterioro brusco del funcionamiento del riñón. Dicha alteración provoca que la capacidad de filtrado de la sangre se vea alterada y que, consecuentemente, en la sangre se acumulen sustancias nitrogenadas,'),(16,'Cancer','Los tratamientos para esta enfermedad varían de acuerdo con el tipo de cáncer y con su estadio.'),(17,'Enfermedades Raras','Las enfermedades raras son aquellas que afectan a menos de 5 personas por cada 10.000 habitantes.');
/*!40000 ALTER TABLE `enfermedades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `justificantes`
--

DROP TABLE IF EXISTS `justificantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `justificantes` (
  `id_justificante` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `telefono` varchar(30) CHARACTER SET utf8 NOT NULL,
  `edad` int(11) NOT NULL,
  `fecha_expedicion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `justificacion` varchar(250) CHARACTER SET utf8 NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_justificante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `justificantes`
--

LOCK TABLES `justificantes` WRITE;
/*!40000 ALTER TABLE `justificantes` DISABLE KEYS */;
INSERT INTO `justificantes` VALUES (1,1,1,'27471243',90,'2015-03-18 02:12:22','Justificacion escrita por el doctor yeah',1),(2,1,0,'27471243',90,'2015-03-25 01:03:16','Justificacion escrita por el doctor yeah',0),(3,1,1,'27471243',90,'2015-03-18 02:28:53','Justificacion escrita por el doctor yeah',1),(4,1,1,'27471243',90,'2015-03-18 03:54:06','Justificacion escrita por el doctor yeah',1),(8,2,1,'777777',7,'2015-03-18 04:51:00','lo justifco chiddo',1),(9,2,5,'445524122232',45,'2015-03-19 04:15:03','yeah dangerous!!',1),(10,2,8,'27471243',90,'2015-03-25 01:10:21','Justificacion escrita por el doctor yeah',0),(11,2,8,'27471243',90,'2015-03-19 20:10:40','Justificacion escrita por el doctor yeah',1),(12,1,8,'27471243',90,'2015-03-19 20:11:00','Justificacion escrita por el doctor yeah',1),(14,2,6,'8',8,'2015-03-20 20:45:58','8',1),(16,2,4,'77',777,'2015-03-23 03:17:42','v7 modificado',1),(17,2,6,'4455666',777,'2015-03-25 01:13:55','vvhoahoahoaha modificado2',0),(18,2,1,'88888888',66,'2015-03-23 03:22:50','ves ta guapa y es rocio',1),(19,2,1,'7878787878',787,'2015-03-25 01:03:46','vEta chida y es roci',0),(20,2,8,'898',67,'2015-03-25 01:12:05','Jutifiacion a leminar',0),(22,2,5,'76867',78,'2015-03-25 01:34:54','vjutificante fianal no unciona el mouse creo que debo esperar a que responda esta cosa, haber si no me llevo mucho tiempo aqui por que debo modifirarlo',0),(23,2,10,'888',1,'2015-03-25 01:46:06','Me gustaba en la primaria',1);
/*!40000 ALTER TABLE `justificantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id_login` int(11) NOT NULL,
  `correo` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `plataforma` int(11) NOT NULL,
  PRIMARY KEY (`id_login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admi2@yahoo.com','2015-03-12 22:46:30',0),(2,'admi2@yahoo.com','2015-03-13 02:02:08',0),(3,'admi2@yahoo.com','2015-03-13 02:09:35',0),(4,'admi2@yahoo.com','2015-03-13 15:55:56',0),(5,'admi2@yahoo.com','2015-03-13 18:11:15',0),(6,'admi2@yahoo.com','2015-03-13 18:11:27',0),(7,'admi2@yahoo.com','2015-03-13 18:44:29',0),(8,'admi2@yahoo.com','2015-03-13 18:52:26',0),(9,'admi2@yahoo.com','2015-03-15 05:01:24',0),(10,'admi2@yahoo.com','2015-03-15 05:57:21',0),(11,'admi2@yahoo.com','2015-03-15 07:32:59',0),(12,'admi2@yahoo.com','2015-03-15 23:16:25',0),(13,'admi2@yahoo.com','2015-03-15 23:18:09',0),(14,'admi2@yahoo.com','2015-03-16 00:05:39',0),(15,'admi2@yahoo.com','2015-03-16 00:28:52',0),(16,'admi2@yahoo.com','2015-03-16 00:31:51',0),(17,'admi2@yahoo.com','2015-03-16 00:38:54',0),(18,'admi2@yahoo.com','2015-03-16 01:13:34',0),(19,'admi2@yahoo.com','2015-03-16 01:18:50',0),(20,'admi2@yahoo.com','2015-03-16 01:21:26',0),(21,'admi2@yahoo.com','2015-03-16 01:57:24',0),(22,'admi2@yahoo.com','2015-03-16 18:09:24',0),(23,'admi2@yahoo.com','2015-03-16 20:56:13',0),(24,'admi2@yahoo.com','2015-03-16 21:49:31',0),(25,'admi2@yahoo.com','2015-03-17 18:27:20',0),(26,'admi2@yahoo.com','2015-03-18 02:35:49',0),(27,'admi2@yahoo.com','2015-03-18 18:10:43',0),(28,'admi2@yahoo.com','2015-03-18 20:28:14',0),(29,'admi2@yahoo.com','2015-03-18 20:33:23',0),(30,'admi2@yahoo.com','2015-03-19 02:24:22',0),(31,'admi2@yahoo.com','2015-03-19 20:11:35',0),(32,'admi2@yahoo.com','2015-03-19 22:48:36',0),(33,'admi2@yahoo.com','2015-03-20 17:26:28',0),(34,'admi2@yahoo.com','2015-03-22 02:24:28',0),(35,'admi2@yahoo.com','2015-03-23 03:04:33',0),(36,'admi2@yahoo.com','2015-03-25 01:08:42',0),(37,'castilloreyesjuan@gmail.com','2015-03-26 03:55:43',0),(38,'castilloreyesjuan@gmail.com','2015-03-26 04:00:11',0),(39,'admi2@yahoo.com','2015-04-01 03:59:01',0),(40,'admi2@yahoo.com','2015-04-01 04:06:37',0);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensaje` (
  `id_mensaje` int(11) NOT NULL AUTO_INCREMENT,
  `id_chat` int(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  `texto` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_mensaje`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (0),(1),(3),(4),(5),(6),(7),(8),(9),(10),(11);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_contactos`
--

DROP TABLE IF EXISTS `paciente_contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente_contactos` (
  `id_paciente` int(11) NOT NULL,
  `id_contacto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_contactos`
--

LOCK TABLES `paciente_contactos` WRITE;
/*!40000 ALTER TABLE `paciente_contactos` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente_contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_doctor`
--

DROP TABLE IF EXISTS `paciente_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente_doctor` (
  `id_paciente` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_doctor`
--

LOCK TABLES `paciente_doctor` WRITE;
/*!40000 ALTER TABLE `paciente_doctor` DISABLE KEYS */;
INSERT INTO `paciente_doctor` VALUES (1,2),(4,2),(5,2),(3,1),(3,2),(6,2),(7,2),(8,2),(8,1),(9,2),(10,2);
/*!40000 ALTER TABLE `paciente_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_enfermedad`
--

DROP TABLE IF EXISTS `paciente_enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente_enfermedad` (
  `id_paciente` int(11) NOT NULL,
  `id_enfermedad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_enfermedad`
--

LOCK TABLES `paciente_enfermedad` WRITE;
/*!40000 ALTER TABLE `paciente_enfermedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente_enfermedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receta` (
  `id_receta` int(11) NOT NULL,
  `id_consulta` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '1',
  `descripcion_receta` varchar(500) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_receta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,1,1,1,1,'Descripion de la receta modificada'),(5,60,4,2,1,'Descripion de la receta modificada'),(6,79,1,1,1,'Descripion de la receta modificada'),(7,80,4,2,1,'receta del dia de cumple de brenda modificad'),(8,87,4,2,1,'Receta para consulta recetas desde Mis Recetas'),(9,88,9,2,1,'Receta con un nuevo paciente '),(10,89,5,2,1,'Este wey esta bien pinche loco'),(11,92,4,2,1,'Receta final para modificar y eliminar'),(12,94,10,2,1,'Yo te amaba sharon'),(13,95,10,2,1,'Receta a shroan dbole\r\n');
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `nombre_sucursal` varchar(50) CHARACTER SET utf8 NOT NULL,
  `fecha_registro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_cliente`
--

DROP TABLE IF EXISTS `telefono_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono_cliente` (
  `id_telefono` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `telefono` varchar(50) CHARACTER SET utf8 NOT NULL,
  `tipo` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'Telefono secundario',
  PRIMARY KEY (`id_telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_cliente`
--

LOCK TABLES `telefono_cliente` WRITE;
/*!40000 ALTER TABLE `telefono_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefonos` (
  `id_telefono` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `telefono` varchar(30) CHARACTER SET utf8 NOT NULL DEFAULT 'Sin Especificar Telefono :/',
  `tipo` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'Telefono principal',
  PRIMARY KEY (`id_telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonos`
--

LOCK TABLES `telefonos` WRITE;
/*!40000 ALTER TABLE `telefonos` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `contraseña` varchar(100) CHARACTER SET utf8 NOT NULL,
  `tipo` int(11) NOT NULL,
  `curp` varchar(100) CHARACTER SET utf8 NOT NULL,
  `correo` varchar(100) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `apellido_p` varchar(50) CHARACTER SET utf8 NOT NULL,
  `apellido_m` varchar(50) CHARACTER SET utf8 NOT NULL,
  `fecha_nacimiento` varchar(50) CHARACTER SET utf8 NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `sexo` tinyint(1) NOT NULL,
  `tipo_sangre` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (0,'contrapaciente',4,'Curpaciente5','admi2@yahoo.com','ROCIO','Castillo','Reyes','Nacimiento no dado de alta',1,0,'Missing'),(1,'paciente5',4,'CurpPaciente5','paciente5@yahoo.com','Pa','Ciente','Dos','2015-03-12',1,1,'A+'),(2,'admi2',0,'CurpAdmi2','admi2@yahoo.com','Admi','Nistrador','DOS','2015-03-12',1,0,'A+'),(3,'contrapaciente',4,'CurpPaciente9','paciente58@yahoo.com','ROCIO','Castillo','Reyes','Nacimiento no dado de alta',0,0,'Missing'),(4,'normita',4,'Curp1','norma@yahoo.com','Norma','Reyes','Taboada','Nacimiento no dado de alta',1,0,'Missing'),(5,'Curp2',4,'Curp2','castillo1@gmail.com','uan','kakak','jjjj','Nacimiento no dado de alta',1,1,'Missing'),(6,'paciente6',4,'CurpPaciente6','paciente5@yahoo.com','Pa','Ciente','Seis','2015-03-19',1,1,'A+'),(7,'paciente7',4,'CurpPaciente7','paciente5@yahoo.com','Pa','Ciente','Siete','2015-03-19',1,1,'A+'),(8,'paciente8',4,'CurpPaciente8','paciente5@yahoo.com','Pa','Ciente','Ocho','2015-03-19',1,1,'A+'),(9,'receta',4,'CurpReceta','receta@gmail.com','Receta','Pruba','Apellido','Nacimiento no dado de alta',1,1,'Missing'),(10,'contraseÃ±a',4,'Curp3','jhony@gmail.com','Sharon','Carbajal','Heredia','Nacimiento no dado de alta',1,0,'Missing'),(11,'monica',4,'CurpPaciente10','castilloreyesjuan@gmail.com','Juan','Castillo','Reyes','2015-03-25',1,1,'A+');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-12 22:36:22
