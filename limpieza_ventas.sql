CREATE DATABASE  IF NOT EXISTS `limpieza_ventas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `limpieza_ventas`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: limpieza_ventas
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_ventas` (
  `id_detalle` int(11) NOT NULL AUTO_INCREMENT,
  `productos_idProductos` int(10) unsigned NOT NULL,
  `ventas_idVentas` int(11) NOT NULL,
  `cantidad_detalle` decimal(10,2) NOT NULL,
  `preciounitario_detalle` decimal(10,2) NOT NULL,
  `preciototal_detalle` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `fk_detalle_ventas_productos_idx` (`productos_idProductos`),
  KEY `fk_detalle_ventas_ventas1_idx` (`ventas_idVentas`),
  CONSTRAINT `fk_detalle_ventas_productos` FOREIGN KEY (`productos_idProductos`) REFERENCES `productos` (`idProductos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_ventas_ventas1` FOREIGN KEY (`ventas_idVentas`) REFERENCES `ventas` (`idVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas`
--

LOCK TABLES `detalle_ventas` WRITE;
/*!40000 ALTER TABLE `detalle_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `idProductos` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `clave_prod` bigint(20) unsigned DEFAULT NULL,
  `nombre_prod` varchar(30) NOT NULL,
  `descrip_prod` varchar(70) DEFAULT NULL,
  `estatus_prod` varchar(20) DEFAULT NULL,
  `cant_prod` decimal(10,2) unsigned DEFAULT NULL,
  `stock_max` decimal(10,2) unsigned DEFAULT NULL,
  `stock_min` decimal(10,0) unsigned DEFAULT NULL,
  `marca_prod` varchar(30) DEFAULT NULL,
  `prov_idProv` varchar(30) DEFAULT NULL,
  `precio_compra` decimal(10,2) unsigned DEFAULT NULL,
  `precio_venta` decimal(10,2) unsigned DEFAULT NULL,
  `precio_mayoreo` decimal(10,2) unsigned DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  `iva` decimal(10,2) unsigned DEFAULT NULL,
  `mu_pv` varchar(10) DEFAULT NULL,
  `mu_pm` varchar(10) DEFAULT NULL,
  `unidad_medida` varchar(30) DEFAULT NULL,
  `cant_mayoreo` int(11) NOT NULL,
  PRIMARY KEY (`idProductos`),
  UNIQUE KEY `idProductos_UNIQUE` (`idProductos`),
  UNIQUE KEY `clave_p_UNIQUE` (`clave_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `idVentas` int(11) NOT NULL AUTO_INCREMENT,
  `fechahora_venta` datetime NOT NULL,
  `vendedor_venta` varchar(45) NOT NULL,
  `cliente_Venta` varchar(45) NOT NULL,
  `formapago_venta` varchar(45) NOT NULL,
  `subtotal_venta` varchar(45) DEFAULT NULL,
  `iva` int(11) DEFAULT NULL,
  `total_venta` decimal(10,2) NOT NULL,
  `recibido_venta` decimal(10,2) NOT NULL,
  `cambio_venta` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idVentas`),
  UNIQUE KEY `id_UNIQUE` (`idVentas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-29 22:54:54
