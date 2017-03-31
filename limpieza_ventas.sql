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
  `id_detalle` int(10) NOT NULL,
  `productos_idProductos` int(10) unsigned NOT NULL,
  `ventas_idVentas` int(10) NOT NULL,
  `cantidad_detalle` float NOT NULL,
  `preciounitario_detalle` float NOT NULL,
  `preciototal_detalle` float NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `fk_detalle_ventas_productos_idx` (`productos_idProductos`),
  KEY `fk_detalle_ventas_ventas1_idx` (`ventas_idVentas`),
  CONSTRAINT `fk_detalle_ventas_productos` FOREIGN KEY (`productos_idProductos`) REFERENCES `productos` (`idProductos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_ventas_ventas1` FOREIGN KEY (`ventas_idVentas`) REFERENCES `ventas` (`idVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `cant_prod` float unsigned DEFAULT NULL,
  `stock_max` float unsigned DEFAULT NULL,
  `stock_min` float unsigned DEFAULT NULL,
  `marca_prod` varchar(30) DEFAULT NULL,
  `prov_idProv` varchar(30) DEFAULT NULL,
  `precio_compra` float unsigned DEFAULT NULL,
  `precio_venta` float unsigned DEFAULT NULL,
  `precio_mayoreo` float unsigned DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  `iva` int(10) unsigned DEFAULT NULL,
  `mu_pv` varchar(10) DEFAULT NULL,
  `mu_pm` varchar(10) DEFAULT NULL,
  `unidad_medida` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idProductos`),
  UNIQUE KEY `idProductos_UNIQUE` (`idProductos`),
  UNIQUE KEY `clave_p_UNIQUE` (`clave_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `subtotal_venta` float NOT NULL,
  `iva` int(11) NOT NULL,
  `total_venta` float NOT NULL,
  `recibido_venta` float NOT NULL,
  `cambio_venta` float NOT NULL,
  PRIMARY KEY (`idVentas`),
  UNIQUE KEY `id_UNIQUE` (`idVentas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-30 21:15:04
