CREATE DATABASE  IF NOT EXISTS `saclife` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `saclife`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: saclife
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
  `id_creador` varchar(100) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descripcion` text NOT NULL,
  `tipo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
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
  `tabla_cambio` varchar(50) NOT NULL,
  `id_cosa` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `email` varchar(100) NOT NULL,
  `contra` varchar(200) NOT NULL,
  `nombre_cliente` varchar(50) NOT NULL,
  `tipo` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_registro` date NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `logo` varchar(200) NOT NULL,
  `slogan` varchar(50) NOT NULL DEFAULT '#SACyourhealth',
  `premium` int(11) NOT NULL DEFAULT '2',
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `config` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('clinica1@yahoo.com','clinica1','ClÃ­nica 1',1,'2015-06-16','DirecciÃ³n ClÃ­nica 1','TelÃ©fono ClÃ­nica 1','F:/GitHub/SAC/SAC/src/Images/clinica1@yahoo.com.png','#SomosClÃ­nica1',2,1,0);
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
  `id_paciente` varchar(100) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `peso` float NOT NULL,
  `estatura` float NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `id_enfermedad` int(11) NOT NULL,
  PRIMARY KEY (`id_consulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
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
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  PRIMARY KEY (`id_contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `direccion` varchar(200) NOT NULL,
  `tipo` varchar(50) NOT NULL DEFAULT 'Direccion secundaria',
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `direccion` varchar(200) NOT NULL DEFAULT 'Sin Especificar Dirección :/',
  `tipo` varchar(50) NOT NULL DEFAULT 'Dirección principal',
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `ubicacion` varchar(500) NOT NULL,
  PRIMARY KEY (`id_emergencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `grado_estudios` varchar(100) NOT NULL DEFAULT 'Sin especificar',
  `especialidad` varchar(100) NOT NULL DEFAULT 'Ninguna',
  `institucion` varchar(100) NOT NULL DEFAULT 'Sin especificar',
  `cedula_profesional` varchar(120) NOT NULL DEFAULT 'Sin especificar',
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
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
  `enfermedad` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  PRIMARY KEY (`id_enfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermedades`
--

LOCK TABLES `enfermedades` WRITE;
/*!40000 ALTER TABLE `enfermedades` DISABLE KEYS */;
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
  `telefono` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `fecha_expedicion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `justificacion` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_justificante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `justificantes`
--

LOCK TABLES `justificantes` WRITE;
/*!40000 ALTER TABLE `justificantes` DISABLE KEYS */;
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
  `correo` varchar(100) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `plataforma` int(11) NOT NULL,
  PRIMARY KEY (`id_login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'clinica1@yahoo.com','2015-06-17 02:14:40',0),(2,'clinica1@yahoo.com','2015-06-17 02:54:45',0),(3,'clinica1@yahoo.com','2015-06-17 03:41:30',0);
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
  `texto` varchar(300) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_mensaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `curp` varchar(100) NOT NULL,
  `fecha_nacimiento` varchar(50) NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  `tipo_sangre` varchar(10) NOT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_contactos`
--

LOCK TABLES `paciente_contactos` WRITE;
/*!40000 ALTER TABLE `paciente_contactos` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente_contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_correo`
--

DROP TABLE IF EXISTS `paciente_correo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente_correo` (
  `id_paciente` int(11) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `id_parentesco` int(11) NOT NULL,
  `solicitud` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_correo`
--

LOCK TABLES `paciente_correo` WRITE;
/*!40000 ALTER TABLE `paciente_correo` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente_correo` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_doctor`
--

LOCK TABLES `paciente_doctor` WRITE;
/*!40000 ALTER TABLE `paciente_doctor` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_enfermedad`
--

LOCK TABLES `paciente_enfermedad` WRITE;
/*!40000 ALTER TABLE `paciente_enfermedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente_enfermedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parentescos`
--

DROP TABLE IF EXISTS `parentescos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parentescos` (
  `id_parentesco` int(11) NOT NULL,
  `parentesco` varchar(50) NOT NULL,
  PRIMARY KEY (`id_parentesco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parentescos`
--

LOCK TABLES `parentescos` WRITE;
/*!40000 ALTER TABLE `parentescos` DISABLE KEYS */;
/*!40000 ALTER TABLE `parentescos` ENABLE KEYS */;
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
  `descripcion_receta` varchar(500) NOT NULL,
  PRIMARY KEY (`id_receta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
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
  `nombre_sucursal` varchar(50) NOT NULL,
  `fecha_registro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `telefono` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL DEFAULT 'Telefono secundario',
  PRIMARY KEY (`id_telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `telefono` varchar(30) NOT NULL DEFAULT 'Sin Especificar Telefono :/',
  `tipo` varchar(50) NOT NULL DEFAULT 'Telefono principal',
  PRIMARY KEY (`id_telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `contraseña` varchar(100) NOT NULL,
  `tipo` int(11) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido_p` varchar(50) NOT NULL,
  `apellido_m` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'saclife'
--
/*!50003 DROP PROCEDURE IF EXISTS `contraseña` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contraseña`(in email nvarchar(100), in accion int, in contra nvarchar(100))
begin
	declare existe int;
	declare activo int;
#Si la accion es 0  se hace una consulta
	if accion=0 then
		set existe=(select count(*) from usuario where correo=email);
		if existe !=0 then
			set  activo=(select count(*) from usuario where correo=email and estado=1);
			if activo !=0 then
				select 1 valido, ('El correo ingresado es válido.') ms;
			else
				select 0 valido, ('El usuario ha sido dado de baja.')msj;
			end if;
		else
			select 2 valido, ('El correo ingresado no esta registrado') msj;
		end if;
	else
#Si la accion=1 se hace un cambio de la contraseña
	update usuario set contraseña=contra where correo=email;
	select 3 valido, ('La contraseña ha sido modificada con éxito.')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `existecorreo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `existecorreo`(in correos nvarchar(100))
begin
	declare existe int;
	declare contra nvarchar(100);
	set existe=(select count(correo) from usuario where correo=correos);
	if existe=0 then
		select 1 valido,('El correo esta disponible') msj;
	else
		set contra=(select contraseña from usuario where correo=correos limit 1);
		select 0 valido, ('El correo ingresado ya esta ocupado, para continuar deberá indicar una relación familiar!') msj, contra contraseña;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `llenar_parentescos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `llenar_parentescos`()
begin
	insert into parentescos values(0,'PADRE');
	insert into parentescos values(1,'MADRE');
	insert into parentescos values(2,'HIJO');
	insert into parentescos values(3,'PAREJA');
	insert into parentescos values(4,'OTRO');
	insert into parentescos values(5,'TITULAR DEL CORREO');
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_aceptarSolicitud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_aceptarSolicitud`(in email nvarchar(100), in id int)
begin
	declare existe int;
	set existe=(select count(*) from paciente_correo where correo=email and id_paciente=id);
	if existe!=0 then
		update paciente_correo set solicitud=1 where correo=email and id_paciente=id;
		select 1 valido,('Has aceptado la solicitud, para guardar el cambio Inicia Sesión de nuevo.');
	else
		select 0 valido, ('La solicitud fue cancelada!')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_AltaCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaCliente`(in email nvarchar(100), 
in contra nvarchar(200), in nombre_cliente nvarchar(50),
in tipo bool, in direccion nvarchar(200), 
in telefono nvarchar(100), in logo nvarchar(200),
in slogan nvarchar(50))
begin
	declare existe int;
    declare id_cliente int;
    declare id_usuario int;
    select count(*) into existe from cliente where cliente.email=email;
    if existe=0 then
        if slogan='' then
			insert into cliente values(email, contra, nombre_cliente, tipo, current_timestamp, direccion, telefono, logo, default, default, default, default);
        else
			insert into cliente values(email, contra, nombre_cliente, tipo, current_timestamp, direccion, telefono, logo, slogan, default, default, default);
        end if;
        select 1 valido, ('Cliente registrado con éxito') msj;
    else
		select 0 valido, ('Email en uso :/') msj;
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_AltaDireccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaDireccion`(in id_usuario int, in direccion nvarchar(200), in tipo nvarchar(50))
begin
	declare id int;
    set id=(select ifnull(max(id_direccion), 0)+1 from direcciones);
    insert into direcciones values(id, id_usuario, direccion, tipo);
	select 1 valido, ('Direccion Registrada con exito') msj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_AltaEvento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaEvento`(
in id_creador nvarchar(100), in fecha timestamp, in descripcion text, in tipo int,
in tipo_consulta int, in id_doctor nvarchar(100), in id_paciente nvarchar(100), in edad int, in peso int, in estatura float,
in anotaciones text
)
begin
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_AltaTelefono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaTelefono`(in id_usuario int, in telefono nvarchar(30), in tipo nvarchar(50))
begin
	declare id int;
    set id=(select ifnull(max(id_telefono), 0)+1 from telefonos);
    insert into direcciones values(id, id_usuario, telefono, tipo);
	select 1 valido, ('Telefono Registrado con exito') msj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_AltaUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaUsuario`(
in contraseña nvarchar(100), in tipo int, in curp nvarchar(100), in correo nvarchar(100), in nombre nvarchar(50), in apellido_p nvarchar(50), in apellido_m nvarchar(50), in fecha_nacimiento date, in sexo bool, in tipo_sangre nvarchar(10), 
in grado_estudios nvarchar(100), in especialidad nvarchar(100), in institucion nvarchar(100), in cedula_profesional nvarchar(120))
begin
	declare existe int;#Variable que sirve para saber si el usuario ya esta registrado o no.
	declare id int;
	select count(*) into existe from usuario where usuario.curp=curp; #Hacemos un conteo de los registros a partir del curp
    if existe=0 then #Si no hay registros
		set id=(select ifnull(max(id_usuario), 0)+1 from usuario);
		if tipo!=4 then #Si el tipo no es 4, significa que se va a registrar a un empleado.
			insert into usuario values(id, contraseña, tipo, curp, correo, nombre, apellido_p, apellido_m, fecha_nacimiento, default, sexo, tipo_sangre);
			insert into empleado values(id, grado_estudios, especialidad, institucion, cedula_profesional);
            #Realizamos inserts a tablas correspondientes.
            select 1 valido, ('Empleado Registrado con Exito') msj;
            #Regresamos mensaje de confimarcion exitosa.
        else #Si el tipo no es 0 entonces:
			if tipo=4 then #Si el tipo es igual a 1, entonces es un paciente.
				insert into usuario values(id, contraseña, tipo, curp, correo, nombre, apellido_p, apellido_m, fecha_nacimiento, default, sexo, tipo_sangre);
				insert into paciente values(id);
                #Realizamos inserts correspondientes.
                select 1 valido, ('Paciente Registrado con Exito') msj,id paciente;
                #Regresamos mensaje de confirmacion.
            else #Si el tipo no es igual a 1
				select 0 valido, ('Tipo invalido de usuario') msj;
                #Entonces nno es ningun tipo de usuario valido, por lo cual regresamos un mensaje de rechazo.
			end if; #Cierre del if de tipo=1;
		end if;# Cierre del if tipo=0.
	else #Si existe no es igual a 1 entonces:
		select 0 valido, ('Usuario ya registrado') msj;#Significa que el usuario ya esta registrado en el sistema.
	end if;	#Cierre del if de existe=0
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_bajaConsulta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_bajaConsulta`(in id_even int)
begin
	declare correcto int;
	set correcto=(select count(*) from agenda where id_evento=id_even);
	if correcto!=0 then
		update agenda set estado=0 where id_evento=id_even;
		select 1 valido, ('La consulta y receta correspondientes has sido eliminadas con éxito.') msj;
	else
		select 0 valido, ('El Evento ya fue dado de baja.') msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_bajaJustificante` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_bajaJustificante`(in id_just int)
begin
	declare correcto int;
	set correcto=(select count(*) from justificantes where id_justificante=id_just);
	if correcto!=0 then
		update justificantes set estado=0 where id_justificante=id_just;
		select 1 valido, ('El justificante ha sido eliminado con éxito.') msj;
	else
		select 0 valido, ('El Justificante ya habia sido eliminado') msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_BajaReceta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_BajaReceta`(in id_recetas int, in id_doctor int)
begin
	update receta set estado=0 where id_receta=id_recetas;
	select 1 valido, ('Receta Eliminada') msj;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_BajaUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_BajaUsuario`(in id_empleado int, in curp nvarchar(100))
begin
	declare existe1 int;
    declare existe2 int;
    declare tipe int;
    declare id int;
	select count(*) into existe1 from empleado where empleado.id_empleado=id_empleado;
    if existe1=1 then
        set tipe=(select tipo from usuario where usuario.id_usuario=id_empleado);
        select id_usuario into id from usuario where usuario.curp=curp;
        if tipe=1 or tipe=0 then
			select count(*) into existe2 from usuario where usuario.id_usuario=id;
			if existe2=1 then
				update usuario set usuario.estado=0 where usuario.id_usuario=id;
				insert into cambios values(id_empleado,'usuario', id, default);
				select 1 valido, ('Usuario Dado de Baja') msj;
			else
				select 0 valido, ('Usuario Inexistente :/') msj;
			end if;
		else
			select 0 valido, ('Usted no esta autorizado para esto 1:/') msj;
		end if;
	else
		select 0 valido, ('Usted no esta autorizado para esto 2:/') msj;
    end if;   
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_borrarparentescos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_borrarparentescos`(in correos nvarchar(100),in nuevo nvarchar(100), in contra nvarchar(50),in usuario int)
begin
	declare existe int;
	declare user int;
	declare validacion int;
	set existe=(select count(*)from paciente_correo where correo=correos);
	if existe!=0 then
		set user=(select count(*)from paciente_correo where id_paciente=usuario);
		if user!=0 then
			set validacion=(select  STRCMP(correos, nuevo));
			if validacion !=0 then
				delete from paciente_correo where id_paciente=usuario and correo=correos;
				update usuario set correo=nuevo, contraseña=contra where id_usuario=usuario;
				select 1 valido, ('El paciente seleccionado tiene su correo individual ahora.') msj;
			else
				select 0 valido, ('El correo electrónico debe ser distinto al usado actualmente para desvincular las cuentas.')  msj;
			end if;
		else
			select 0 valido, ('Usuario Invalido')  msj;
		end if;
	else
		select 0 valido, ('Correo invalido')  msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_CambiarDireccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CambiarDireccion`(in id_direccion int, direccion nvarchar(200), tipo nvarchar(50))
begin
	declare val int;
    select count(*) into val from direcciones where direcciones.id_direccion=id_direccion;
    if val=1 then
		update direcciones set direcciones.direccion=direccion, direcciones.tipo=tipo where direcciones.id_direccion=id_direccion;
        select 1 valido, ('Direccion modificada exitosamente') msj;
	else
		select 0 valido, ('Direccion no existe') msj;
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_CambiarTelefono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CambiarTelefono`(in id_telefono int, telefono nvarchar(200), tipo nvarchar(50))
begin
	declare val int;
    select count(*) into val from telefono where telefonos.id_telefono=id_telefono;
    if val=1 then
		update telefonos set telefonos.telefono=telefono, telefonos.tipo=tipo where telefonos.id_telefono=id_telefono;
        select 1 valido, ('Telefono modificado exitosamente') msj;
	else
		select 0 valido, ('Telefono no existe') msj;
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_CambiaUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CambiaUsuario`(in id_usuario int, in contraseña nvarchar(100), in curp nvarchar(100), in correo nvarchar(100), in nombre nvarchar(50), in apellido_p nvarchar(50), 
in apellido_m nvarchar(50), in fecha_nacimiento date, in tipo_sangre nvarchar(10), 
in grado_estudios nvarchar(100), in especialidad nvarchar(100), in institucion nvarchar(100), in cedula_profesional nvarchar(120), in id_empleado int)
begin
	declare existe1 int;
    declare existe2 int;
    declare tip int;
    declare tipo int;
	select count(*) into existe1 from empleado where empleado.id_empleado=id_empleado;
    if existe1=1 then
        set tip=(select usuario.tipo from usuario where usuario.id_usuario=id_empleado);
        if tip=1 or tip=0 then
			select count(*) into existe2 from usuario where usuario.id_usuario=id_usuario;
            set tipo=(select usuario.tipo from usuario where usuario.id_usuario=id_usuario);
			if existe2=1 then
				update usuario 
					set usuario.contraseña=contraseña, usuario.curp=curp, 
					usuario.correo=correo, usuario.nombre=nombre, usuario.apellido_p=apellido_p, usuario.apellido_m=apellido_m,
					usuario.fecha_nacimiento=fecha_nacimiento, usuario.tipo_sangre=tipo_sangre
					where usuario.id_usuario=id_usuario;
				if tipo!=4 then
					update empleado set empleado.grado_estudios=grado_estudios,
					empleado.especialidad=especialidad, empleado.institucion=institucion, empleado.cedula_profesional=cedula_profesional
                    where empleado.id_empleado=id_usuario;
				end if;
				insert into cambios values(id_empleado,'usuario', id_usuario, default);
				select 1 valido, ('Usuario Modificado correctamente') msj;
			else
				select 0 valido, ('Usuario Inexistente :/') msj;
			end if;
		else
			select 0 valido, ('Usted no esta autorizado para esto 1 :/') msj, tip as tiposs;
		end if;
	else
		select 0 valido, ('Usted no es un empleado :/') msj;
    end if;   
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaAltaModificacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaAltaModificacion`(in anotaciones nvarchar(300), in curps nvarchar(100),in tipo int, in id_doctor nvarchar(100),in estaturas int(4), in pesos int(4), in edads int, in accion int, in enfermedads int, in id_modif int)
begin 
	declare consulta_id int;
	declare evento_id int;
	declare paciente_id int;
	declare datec timestamp;
	declare activo int;
	declare existe int(1);
	declare existe_relacion int;
	set paciente_id=(select id_usuario from usuario where curp=curps);
	set consulta_id=(select ifnull(max(id_consulta), 0)+1 from consulta);
	set evento_id=(select ifnull(max(id_evento), 0)+1 from agenda);
	set datec=(curtime());
	set existe=(select count(*) from usuario where usuario.curp=curps);
	if accion=1 then
		if existe=1 then 
			#verificando que el usuario este activo
			set activo=(select count(*) from usuario where estado=1 and curp=curps);
			if activo!=0 then
			#Crando un vento de tipo especial
				insert into agenda values(evento_id,id_doctor,datec,'Consulta creada a un usuario registrado pero sin agenda',1,1);
				#Ese evento de tipo especial es una consulta asi que la agregamos
				insert into consulta values(consulta_id,evento_id,tipo,id_doctor,paciente_id,edads,pesos,estaturas,anotaciones,enfermedads);
				#Como no hay un id para obtener los datos de la tabla usuario hacemos un insert a la tabla conuslta externa
					#Haciendo el alta a la tabla paciente_doctor
						set existe_relacion=(select count(*)from paciente_doctor where id_paciente=paciente_id and id_empleado=id_doctor);
						if existe_relacion =0 then
							insert into paciente_doctor values(paciente_id,id_doctor);
						end if;
				select 1 valido, ('Consulta Creada')msj, paciente_id paciente, consulta_id consulta;
			else
				select 0 valido, ('La consulta no pudo ser Creada. El Curp ingresado pertenece a un Paciente dado de baja, para darlo de alta ingresa a Sección Modificar Usuario.') msj;
			end if;
		else
			select 0 valido, ('La Consulta no pudo ser Creada. El Curp ingresado es incorrecto.') msj;
		end if;
	else
		update consulta set descripcion=anotaciones, edad=edads, peso=pesos, estatura=estaturas, id_enfermedad=enfermedads where id_consulta=id_modif;
		select 2 valido, ('La Consulta ha sido Modificada con Éxito')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaCliente`(in email nvarchar(100))
BEGIN
	select * from cliente where cliente.email=email;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaDireccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaDireccion`(in id_usuario int)
begin
	declare val int;
    declare val2 int;
    select count(*) into val from usuario where usuario.id_usuario=id_usuario;
    if val=1 then 
		select count(*) into val2 from direcciones where direcciones.id_usuario=id_usuario;
		if val2 !=0 then
			select * from direcciones where direcciones.id_usuario=id_usuario;
		else
			select ('Sin direcciones aun :/') direccion;
		end if;
	else
		select 0 direccion;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaDoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaDoc`(in id_consultas int)
begin 
	declare existe int;
	#Datos de la Consulta 
	declare id_eventos int;
	declare tipos int;
	declare edads int;
	declare pesos int;
	declare estaturas int;
	declare anotaciones nvarchar(300);
	declare id_enf int;
	declare enfermedads nvarchar(30);
	#Datos del Evento
	declare fechas timestamp;
	declare estados int;
	#Receta
	declare receta int;
	declare id_recetas int;
	#Agregando los valores la consulta
	set existe=(select count(*)from consulta where id_consulta=id_consultas);
	if existe!=0 then
		set tipos=(select tipo from consulta where id_consulta=id_consultas);
		set edads=(select edad from consulta where id_consulta=id_consultas);
		set pesos=(select peso from consulta where id_consulta=id_consultas);
		set estaturas=(select estatura from consulta where id_consulta=id_consultas);
		set anotaciones=(select descripcion from consulta where id_consulta=id_consultas);
		set id_enf=(select id_enfermedad from consulta where id_consulta=id_consultas);
		#Obteniendo valor de enfermedad en texto
		set enfermedads=(select enfermedad from enfermedades where id_enfermedad=id_enf);
		#Obteniendo datos del evento agendado
		set id_eventos=(select id_evento from consulta where id_consulta=id_consultas);
		set fechas=(select fecha from agenda where id_evento=id_eventos);
		set estados=(select estado from agenda where id_evento=id_eventos);
		#Obteniendo los datos de la receta
		set receta=(select count(*) from receta where id_consulta=id_consultas);
		if receta !=0 then
		set id_recetas=(select id_receta from receta where id_consulta=id_consultas);
			select tipos tipo, edads edad, pesos pes, estaturas estatura, anotaciones anotacion, enfermedads enf, fechas fec, estados est,receta receta, id_recetas id_rec,id_eventos evento;
		else
			select tipos tipo, edads edad, pesos pes, estaturas estatura, anotaciones anotacion, enfermedads enf, fechas fec, estados est,receta receta, id_eventos evento;
		end if;
	else 
	select ('Inicia sesión de nuevo') msj;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaDoctor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaDoctor`(in doctor int, in tipo int)
begin
	declare existe int(1);
	if tipo=1 then 	#Consulta de CONSULTAS
		set existe=(select count(*) from consulta where id_doctor=doctor);
		#Revisamos si ya tenemos consulta registradas a nombre de este doctor
		if existe!=0 then
			select * from consulta where id_doctor=doctor;
		else
			select 0 valido, ('No has realizado ninguna Consulta') msj;
		end if;
	end if;
	if tipo=2 then	#Consulta de RECETAS

		set existe=(select count(*) from receta where id_doctor=doctor);
		#Revisamos si ya tenemos recetas registradas a nombre de este doctor
		if existe!=0 then
			select * from receta where id_doctor=doctor;
		else
			select 0 valido, ('No has expedido ninguna Receta') msj;
		end if;
	end if;
	if tipo=3 then	#Consulta de JUSTIFICANTES
	set existe=(select count(*) from justificantes where id_doctor=doctor);
		#Revisamos si ya tenemos jusntificantes registradas a nombre de este doctor
		if existe!=0 then
			select * from justificantes where id_doctor=doctor;
		else
			select 0 valido, ('No has expedido ningun Justificante') msj;
		end if;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaExpressAM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaExpressAM`(in curps nvarchar(100),in sexo int, in contra nvarchar(100), in anotaciones nvarchar(300), in email nvarchar(100), 
in id_doctor nvarchar(100),in estatura int(4), in peso int(4), in edad int, in nombres nvarchar(50),
in apellido_ps nvarchar(50), in apellido_ms nvarchar(50),in accion int, in id_modif int,in id_enfermedad int)
begin 
	declare id_consultas int;
	declare id_usuarios int;
	declare id_pacientes int;
	declare id_eventos int;
	declare datec timestamp;
	declare existe int;
	declare activo int;
	declare existe_relacion int;
	set id_consultas=(select ifnull(max(id_consulta), 0)+1 from consulta);
	set id_eventos=(select ifnull(max(id_evento), 0)+1 from agenda);
	set datec=(curtime());
	if accion=1 then
		#validando si el usuario ya existe o no
			set existe=(select count(*) from usuario where curp=curps);
			if existe =1 then
			#Si el usuario ya existe obtengo su id y hago una consulta normal
				set activo=(select  count(*) from usuario where curp=curps and estado=1);
				#Valido que el usuario este activo
				if activo!=0 then
					set id_pacientes=(select id_usuario from usuario where curp=curps);
					#alta de una consulta normal
					insert into agenda values(id_eventos,id_doctor,datec,'Dar de alta un usuario y crear su primer consulta',1,1);
					#Ese evento de tipo especial es una consulta asi que la agregamos
					insert into consulta values(id_consultas,id_eventos,1,id_doctor,id_pacientes,edad,peso,estatura,anotaciones,id_enfermedad);
					#Como no hay un id para obtener los datos de la tabla usuario hacemos un insert a la tabla conuslta externa
						#Haciendo el alta a la tabla paciente_doctor
					set existe_relacion=(select count(*)from paciente_doctor where id_paciente=id_pacientes and id_empleado=id_doctor);
					if existe_relacion = 0 then
						insert into paciente_doctor values(id_pacientes,id_doctor);
					end if;
				select 2 valido, ('Este paciente ya habia sido dado de alta, la consulta sera creada con los datos que ya teniamos.')msj, id_pacientes paciente, id_consultas consulta;
				else
				select 0 valido, ('Este paciente fue dado de baja, poder activarlo de nuevo visita la sección Usuarios')msj;
				end if;
			else
				#Si el usuario no existe hago una alta a usuario obtengo el id creado y hago una consulta normal
					#creando a un nuevo usuario
					set id_usuarios=(select ifnull(max(id_usuario), 0)+1 from usuario);
					insert into usuario values (id_usuarios,contra,4,curps,email,nombres,apellido_ps,apellido_ms,'Nacimiento no dado de alta',1,sexo,'Missing');
					#Asignando el nuevo id_paciente
					set id_pacientes=(select id_usuarios from usuario where curp=curps);
					#creando un nuevo paciente
					insert into paciente values (id_pacientes);
				#Hacemos una consulta normal
				insert into agenda values(id_eventos,id_doctor,datec,'Dar de alta un usuario y crear su primer consulta',1,1);
				#Ese evento de tipo especial es una consulta asi que la agregamos
				insert into consulta values(id_consultas,id_eventos,1,id_doctor,id_pacientes,edad,peso,estatura,anotaciones,id_enfermedad);
				#Como no hay un id para obtener los datos de la tabla usuario hacemos un insert a la tabla conuslta externa
					#Haciendo el alta a la tabla paciente_doctor
					set existe_relacion=(select count(*)from paciente_doctor where id_paciente=id_pacientes and id_empleado=id_doctor);
					if existe_relacion =0 then
						insert into paciente_doctor values(id_pacientes,id_doctor);
					end if;
				select 1 valido, ('El paciente ha sido dado de alta, y su primer consulta fue creada') msj, id_pacientes paciente, id_consultas consulta;
			end if;
		else
		update consulta_express set correo=email, nombre=nombres,apellido_p=apellido_ps, apellido_m=apellido_ms where id_consulta=id_modif;
		select 3 valido, ('Consulta Modificada')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaTelefono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaTelefono`(in id_usuario int)
begin
	declare val int;
    declare val2 int;
    select count(*) into val from usuario where usuario.id_usuario=id_usuario;
    if val=1 then 
		select count(*) into val2 from telefonos where telefonos.id_usuario=id_usuario;
		if val2 !=0 then
			select * from telefonos where telefonos.id_usuario=id_usuario;
		else
			select ('Sin telefonos aun :/') telefono;
		end if;
	else
		select 0 telefono;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ConsultaUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ConsultaUsuario`(in curp nvarchar(100))
begin
	declare existe int;
    declare existe1 int;
    declare id int;
    select count(*) into existe from usuario where usuario.curp=curp and estado=1;
    if existe=1 then
		select id_usuario into id from usuario where usuario.curp=curp;
        select count(*) into existe1 from empleado where empleado.id_empleado=id;
        if existe1=1 then
			select * from usuario, empleado where usuario.id_usuario=id and empleado.id_empleado=id;
		else
			select * from usuario where usuario.id_usuario=id;
		end if;
    else
		select 0 id_usuario;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_DatosAuxiliares` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DatosAuxiliares`(id_pacientes int, id_doctors int,id_consultas int)
begin
		#declaracion de valores
		#PACIENTE
			declare nombre_p nvarchar(50);
			declare paterno_p nvarchar(50);
			declare materno_p nvarchar(50);
			declare nacimientos nvarchar(50);
			declare sexos int;
		#DOCTOR
			declare nombre_d nvarchar(50);
			declare paterno_d nvarchar(50);
			declare materno_d nvarchar(50);
			declare grados nvarchar(100);
			declare institucions nvarchar(100);
			declare cedulas nvarchar(120);
			declare especialidads nvarchar(100);
		#CONSULTA
			declare tipo_enfermedad int;
			declare enfermedads nvarchar(30);
			declare fechas timestamp;
			declare tipo_consulta int;
			declare edads int;
			declare pesos int;
			declare estaturas int;
			declare descripcions nvarchar(300);
		#Añadiendo valores
			declare id_eventos int;
			set id_eventos=(select id_evento from consulta where id_consulta=id_consultas);
			#nombre del paciente
			set nombre_p=(select nombre from usuario where id_usuario=id_pacientes);
			#apellido paterno del paciente
			set paterno_p=(select apellido_p from usuario where id_usuario=id_pacientes);
			#apellido amterno del paciente
			set materno_p=(select apellido_m from usuario where id_usuario=id_pacientes);
			#nombre del doctor
			set nombre_d=(select nombre from usuario where id_usuario=id_doctors);
			#apellido paterno del paciente
			set paterno_d=(select apellido_p from usuario where id_usuario=id_doctors);
			#apellido amterno del paciente
			set materno_d=(select apellido_m from usuario where id_usuario=id_doctors);
			
			set sexos=(select sexo from usuario where id_usuario=id_pacientes);
			set nacimientos=(select fecha_nacimiento from usuario where id_usuario=id_pacientes);
			set grados=(select grado_estudios from empleado where id_empleado=id_doctors);
			set institucions=(select institucion from empleado where id_empleado=id_doctors);
			set cedulas=(select cedula_profesional from empleado where id_empleado=id_doctors);
			set especialidads=(select especialidad from empleado where id_empleado=id_doctors);
			
			set fechas=(select fecha from agenda where id_evento=id_eventos);
			set tipo_enfermedad=(select id_enfermedad from consulta where id_consulta=id_consultas);
			set enfermedads=(select enfermedad from enfermedades where id_enfermedad=tipo_enfermedad);
			set tipo_consulta=(select tipo from consulta where id_consulta=id_consultas);
			set edads=(select edad from consulta where id_consulta=id_consultas);
			set pesos=(select peso from consulta where id_consulta=id_consultas);
			set estaturas=(select estatura from consulta where id_consulta=id_consultas);
			set descripcions=(select descripcion from consulta where id_consulta=id_consultas);
			
			select 1 valido,nombre_p nombre_paciente,paterno_p paterno_paciente, materno_p materno_paciente,
					nombre_d nombre_doctor, paterno_d paterno_doctor, materno_d materno_doctor,sexos sexo,nacimientos fecha_nac,
					grados grado_estudios,institucions instituto,cedulas cedula_profesional,especialidads especialidades,
					fechas fecha_exp,enfermedads id_enf,tipo_consulta tipo_con,edads edades,pesos peso,estaturas estatura,descripcions descripcion;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_DatosPersonales` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DatosPersonales`(in id_usuarios int)
begin 
	declare existe int;
	declare tipo int;
		#PACIENTE
			declare nombres nvarchar(150);
			declare nacimientos nvarchar(50);
			declare sexos int;
			declare curps nvarchar(100);
			declare correos nvarchar(100);
		#DOCTOR
			declare grados nvarchar(100);
			declare institucions nvarchar(100);
			declare cedulas nvarchar(120);
			declare especialidads nvarchar(100);
	set existe=(select count(*) from usuario where estado=1 and id_usuario=id_usuarios);
	if existe!=0 then
			set nombres=(concat_ws(' ',(select nombre from usuario where id_usuario=id_usuarios),
									   (select apellido_p from usuario where id_usuario=id_usuarios),
									   (select apellido_m from usuario where id_usuario=id_usuarios)));
			set nacimientos=(select fecha_nacimiento from usuario where id_usuario=id_usuarios);
			set sexos=(select sexo from usuario where id_usuario=id_usuarios);
			set curps=(select curp from usuario where id_usuario=id_usuarios);
			set correos=(select correo from usuario where id_usuario=id_usuarios);
		#Obteniendo el tipo de usuario que es doctor/paciente
		set tipo=(select count(*)from empleado where id_empleado=id_usuarios);
		if tipo!=0 then
		#Doctor
			set grados=(select grado_estudios from empleado where id_empleado=id_usuarios);
			set institucions=(select institucion from empleado where id_empleado=id_usuarios);
			set cedulas=(select cedula_profesional from empleado where id_empleado=id_usuarios);
			set especialidads=(select especialidad from empleado where id_empleado=id_usuarios);
			select curps curp,correos correo,nombres nombre, nacimientos fecha_nac,sexos sexo, grados grado, institucions inst, cedulas ced, especialidads esp;
		else
		#Paciente
			select curps curp,correos correo,nombres nombre, nacimientos fecha_nac,sexos sexo;
		end if;
	else
		select 0 valido, ('El usuario ha sido dado de baja') msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_DropDatabase` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DropDatabase`()
begin
	drop database saclife;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_EliminarDireccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminarDireccion`(in id_direccion int)
begin
	declare val int;
	select count(*) into val from direcciones where direcciones.id_direccion=id_direccion;
    if val=1 then
		delete from direcciones where direcciones.id_direccion=id_direccion;
        select 1 valido, ('Direccion eliminada exitosamente') msj;
	else
		select 0 valido, ('Direccion no existe :/') msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_EliminarTelefono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminarTelefono`(in id_telefono int)
begin
	declare val int;
	select count(*) into val from telefonos where telefonos.id_telefono=id_telefono;
    if val=1 then
		delete from telefonos where telefonos.id_telefono=id_telefono;
        select 1 valido, ('Telefono eliminado exitosamente') msj;
	else
		select 0 valido, ('Telefono no existe :/') msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Enfermedades` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Enfermedades`()
begin
	insert into enfermedades values(0,'Sano', 'Sin enfermedad riesgosa');
	insert into enfermedades values(1,'Accidentes y lesiones', 'Existen una gran variedad de lesiones como consecuencia de accidentes, tales como quemaduras, intoxicaciones, traumatismos, etc., constituyendo en ocasiones, importantes problemas para la salud.');
	insert into enfermedades values(2, 'Aparato Digestivos', 'Cirrosis, hepatitis, estreñimiento.');
	insert into enfermedades values(3, 'Aparato Respitratorio', 'Las enfermedades que afectan a la vía respiratoria, desde los procesos de vías altas hasta los más graves por afectar al árbol bronquial y los pulmones, suponen una gran parte de las consultas médicas...');
	insert into enfermedades values(4,'Cardiovasculares','Las enfermedades cardiovasculares son las que pueden afectar a nuestro corazón y al sistema circulatorio: venas, arterias, etc.');
	insert into enfermedades values(5,'Dematologia','La Piel es nuestro órgano más grande, nos protege contra la luz, el sol el frío, por ello debemos protegerla.');
	insert into enfermedades values(6,'Endocrinologia y Nutricion','Enfermedades habitualmente englobadas en trastornos de hormonas o del metabolismo se exponen en este capítulo para avanzar en el conocimiento de sus síntomas más frecuentes, los procedimientos diagnósticos y terapéuticos habituales y los consejos de prevención que pueden evitar el desarrollo de este tipo de patologías');
	insert into enfermedades values(7,'ETSs','Las enfermedades de transmisión sexual son infecciones que se adquieren por tener relaciones sexuales con alguien que esté infectado. Pueden afectar tanto a hombres como a mujeres.');
	insert into enfermedades values(8,'Enfermedades Infecciones','Nuestro organismo tiene mecanismos de defensa (sistema inmunológico) para defenderse de agentes como bacterias, virus, hongos. A veces éstos encuentran en el organismo condiciones favorables, y provocan enfermedades infecciosas.');
	insert into enfermedades values(9,'Ematologia','Muchas son las funciones que tiene la sangre, y muchas las alteraciones que puede sufrir, como alteraciones de los glóbulos rojos (anemias), glóbulos blancos y plaquetas. La hematología además, también abarca enfermedades oncológicas (linfomas, mielomas, leucemias...)');
	insert into enfermedades values(10,'Huesos, articulaciones y musculos','Patologías como la osteoporosis, las artritis, la espondilitis anquilopoyética, etc merecen un espacio donde se describan sus síntomas, las pruebas diagnósticas más habituales y las opciones de tratamiento más actuales y eficaces para cada paciente.');
	insert into enfermedades values(11,'Oftalmologia','Es la especialidad que estudia las enfermedades oculares y sus tratamientos');
	insert into enfermedades values(12,'Otorrinolaringologia','Es la especialidad de la garganta, nariz y odio que trata enfermedades tan comunes como la otitis, hasta los cánceres de cuello y laringe');
	insert into enfermedades values(13,'Psiquiatria','Depresión, manía, esquizofrenia... son términos que utilizamos todos los día para referirnos a las alteraciones anímicas y de comportamiento. A continuación se exponen conceptos de interés sobre estas y otras enfermedades que afectan a la salud mental.');
	insert into enfermedades values(14,'Sistema Nervioso','Patologías como parkinson, hemorragia intracraneal, trastornos del sueño, accidente cerebrovascular, etc..');
	insert into enfermedades values(15,'Urologia','La insuficiencia renal aguda es un deterioro brusco del funcionamiento del riñón. Dicha alteración provoca que la capacidad de filtrado de la sangre se vea alterada y que, consecuentemente, en la sangre se acumulen sustancias nitrogenadas,');
	insert into enfermedades values(16,'Cancer','Los tratamientos para esta enfermedad varían de acuerdo con el tipo de cáncer y con su estadio.');
	insert into enfermedades values(17,'Enfermedades Raras','Las enfermedades raras son aquellas que afectan a menos de 5 personas por cada 10.000 habitantes.');
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_familia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_familia`(in email nvarchar(100))
begin
	select * from paciente_correo where correo=email;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_JustAM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_JustAM`(in id_doctors int, in curps nvarchar(50), in tel nvarchar(18), in edads int, in just nvarchar(250), in accion int, in id_modif int)
begin
	declare id_just int;
	declare id_pac int;
	declare existe int;
	declare existe_relacion int;
	declare datec timestamp;
	declare activo int;
	set datec=(curtime());
	set id_just=(select ifnull(max(id_justificante), 0)+1 from justificantes);
	set id_pac=(select id_usuario from usuario where usuario.curp=curps);
	set existe=(select count(*) from usuario where curp=curps);
	if existe!=0 then
		if accion=1 then
			set activo=(select count(*)from usuario where curp=curps and estado=1);
			#Valido que el usuario este activo
			if activo !=0 then
				insert into justificantes values(id_just,id_doctors,id_pac, tel,edads,datec,just,1);
				select 1 valido, ('Justificante Creado')msj;
				#Haciendo el alta a la tabla paciente_doctor
					set existe_relacion=(select count(*)from paciente_doctor where id_paciente=id_pac and id_empleado=id_doctors);
					if existe_relacion =0 then
						insert into paciente_doctor values(id_pac,id_doctors);
					end if;
			else
				select 2 valido, ('El Justificante no pudo ser creado. El paciente fue dado de baja, para activarlo de nuevo visita la Sección Usuarios')msj;
			end if;
		else
			update justificantes set id_justificante=id_just,id_doctor=id_doctors,id_paciente=id_pac,telefono=tel, edad=edads, justificacion=just where id_justificante=id_modif;
			select 2 valido, ('Justificante Modificado')msj;
		end if;
	else
		select 0 valido, ('El justificante no pudo ser creado. El curp que ingresaste no es válido.') msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_JustificanteDoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_JustificanteDoc`(in id_justificantes int)
begin
	declare existe int;
	set existe=(select count(*) from justificantes where id_justificante=id_justificantes);
	if existe!=0 then
	select * from justificantes where id_justificante=id_justificantes;
	else
	select 0 valido, ('El justificante fue dado de baja')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_login`(in email nvarchar(100), pass nvarchar(100), in platform int(2))
begin 
	declare id_log int(4);
	declare existe int(1);
	declare existe2 int(1);
	declare datec timestamp;
	set datec=(curtime());
	set existe=(select count(*) from usuario where usuario.correo=email and usuario.contraseña=pass);
	if existe=1 then
		set id_log=(select ifnull(max(id_login), 0)+1 from login);
		insert into login(id_login,correo,fecha, plataforma) values(id_log, email, datec,platform);
		select 1 valido, ('Bienvenido Usuario') msj;
		else
			set existe2=(select count(*) from cliente where cliente.email=email and cliente.contra=pass);
            if existe2=1 THEN
				set id_log=(select ifnull(max(id_login), 0)+1 from login);
				insert into login(id_login,correo,fecha, plataforma) values(id_log, email, datec,platform);
				select 2 valido, ('Bienvenido Cliente') msj;
            else
				select 0 valido, ('No estas registrado :/') msj;
            end if;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Nombres` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Nombres`(in id_usuarios int)
begin
	declare existe int;
	set existe=(select count(*) from usuario where id_usuario=id_usuarios);
	if existe!=0 then
		select nombre, apellido_p, apellido_m from usuario where id_usuario=id_usuarios;
	else
		select ('No') nombre, ('Existe') apellido_p, ('El Usuario') apellido_m;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtenercorreos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtenercorreos`(in email nvarchar(100))
begin
	select id_usuario from usuario where correo=email;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtenerparentescos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtenerparentescos`(in correos nvarchar(100))
begin
	declare nombre nvarchar(100);
	declare existe int;
	set existe=(select count(*)from paciente_correo where correo=correos);
	if existe!=0 then
		select id_paciente, id_parentesco from paciente_correo where correo=correos;
	else
		select 0 valido, ('El usuario ingresado no tiene parentescos')  msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ObtenerRecetas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ObtenerRecetas`(in id_paciente int)
begin
	declare existe int;
	select count(*) into existe from recetas where recetas.id_paciente=id_paciente and recetas.estado=1;
	if existe!=0 then
		select * from recetas where recetas.id_paciente=id_paciente and recetas.estado=1;
	else
		select 0 id_receta;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_PacienteDoctor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_PacienteDoctor`(in relacion int, in id_usuario int)
begin
	#Si relacion=0 obtengo los pacientes para cada doctor
	if relacion=0 then
		select id_paciente from paciente_doctor where id_empleado=id_usuario;
	end if;
	#Si relacion=1 obtengo los doctores para cada paciente
	if relacion=1 then
		select id_empleado from paciente_doctor where id_paciente=id_usuario;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_RecetaAltaModificacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_RecetaAltaModificacion`(in descrip nvarchar(300), in id_consultas int,in id_paciente nvarchar(100), in id_doctor int,in accion int, in id_modif int)
begin
	declare id_recetas int;
	declare existe_consulta int;
	set id_recetas=(select ifnull(max(id_receta), 0)+1 from receta);
	if accion=1 then
		set existe_consulta=(select count(*) from consulta where id_consulta=id_consultas);
		if existe_consulta!=0 then
			insert into receta values(id_recetas,id_consultas,id_paciente,id_doctor,1,descrip);
			select 1 valido, ('Receta Creada, para poder imprimir la receta, visita la sección Mis recetas.')msj;
		else
			select 2 valido, ('La receta no pudo ser creada debido a un error en la consulta. Cierra la sesión y vuleve a ingresar el sistema para poder arreglar este problema.')msj;
		end if;
	else
		update receta set descripcion_receta=descrip where id_receta=id_modif;
		select 0 valido, ('Receta Modificada')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_RecetaDoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_RecetaDoc`(in id_recetas int)
begin
	declare existe int;
	set existe=(select count(*) from receta where id_receta=id_recetas);
	if existe!=0 then
	select * from receta where id_receta=id_recetas;
	else
	select 0 valido, ('La receta fue dada de baja')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_rechazarSolicitud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_rechazarSolicitud`(in email nvarchar(100), in id int)
begin
	declare existe int;
	set existe=(select count(*) from paciente_correo where correo=email and id_paciente=id);
	if existe!=0 then
		delete from paciente_correo where id_paciente=id and correo=email;
		update usuario set correo='No registrado',contraseña='Sin Contraseña' where id_usuario=id;
		select 1 valido,('Has rechazado la solicitud, para guardar el cambio Inicia Sesión de nuevo.')msj;
	else
		select 0 valido, ('La solicitud fue cancelada!')msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sesiones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_sesiones`(in email nvarchar(100), pass nvarchar(100))
begin 
	select * from usuario where usuario.correo=email and usuario.contraseña=pass;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_vincularcorreos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_vincularcorreos`(in email nvarchar(100),in id int, in id_relacion int)
begin
	#VALIDACIÓN para ver que no exista la misma relación ya en la tabla
	declare existe int;
	set existe=(select count(*) from paciente_correo where correo=email and id_paciente=id);
	if existe!=0 then
		select 0 valido, ('La relación ya existe')msj;
	else
		update usuario set correo=email where id_usuario=id;
		insert into paciente_correo values(id,email,id_relacion,0); 
		select 1 valido,('Vinculación realizada con éxito');
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_vistaConsulta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_vistaConsulta`(in id_pacientes int, in id_doctors int, in id_consultas int)
begin
	declare id_eventos int;
	declare activo int;
	#tabla agenda
	declare fechas nvarchar(50);
	#tabla consulta
	declare tipox int;
	#tabla consulta
	declare enfermedads int;
	declare tipo_enf nvarchar(50);
	declare paciente nvarchar(200);
	declare doctor nvarchar(200);
	declare receta int;
	declare existe_r int;
	#Estaod activo de la consulta
	set id_eventos=(select id_evento from consulta where id_consulta=id_consultas);
	set activo=(select count(*) from agenda where id_evento=id_eventos and estado=1);
	if activo!=0 then
		#obteniendo valores
		set doctor=(concat_ws(' ',(select nombre from usuario where id_usuario=id_doctors),
						   (select apellido_p from usuario where id_usuario=id_doctors),
						   (select apellido_m from usuario where id_usuario=id_doctors)));
		set paciente=(concat_ws(' ',(select nombre from usuario where id_usuario=id_pacientes),
						   (select apellido_p from usuario where id_usuario=id_pacientes),
						   (select apellido_m from usuario where id_usuario=id_pacientes)));
		set enfermedads=(select id_enfermedad from consulta where  id_consulta=id_consultas);
		set tipo_enf=(select enfermedad from enfermedades where id_enfermedad=enfermedads);
		set tipox=(select tipo from consulta where  id_consulta=id_consultas);
		set fechas=(select fecha from agenda where id_evento=id_eventos);
		set receta=(select count(*)from receta where id_consulta=id_consultas);
		if receta!=0 then
			set existe_r=1;
		else
			set existe_r=0;
		end if;
		select 1 valido, fechas fecha_exp,tipox tipos,tipo_enf enfermedad, paciente nombrep,doctor nombred, existe_r receta,id_consultas consulta;
	else
		select 0 valido,('La consulta fue dada de baja') msj;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vistaExpedientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vistaExpedientes`(in id_paciente int)
begin
	declare curps nvarchar(100);
	declare correos nvarchar(100);
	declare nombres nvarchar(50);
	declare paternos nvarchar(50);
	declare maternos nvarchar(50);
	declare sexos int;
	declare estados int;
	set estados=(select estado from usuario where id_usuario=id_paciente);
	if estados=1 then
		set curps=(select curp from usuario where id_usuario=id_paciente);
		set nombres=(select nombre from usuario where id_usuario=id_paciente);
		set paternos=(select apellido_p from usuario where id_usuario=id_paciente);
		set maternos=(select apellido_m from usuario where id_usuario=id_paciente);
		set sexos=(select sexo from usuario where id_usuario=id_paciente);
		select 1 valido,id_paciente paciente, curps curp,nombres nombres, paternos paterno, maternos materno, sexos sexo;
	else
		select 0 valido;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-16 23:39:58
