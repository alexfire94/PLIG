-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-03-2017 a las 18:38:37
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `limpieza_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProductos` int(10) UNSIGNED NOT NULL,
  `clave_prod` bigint(20) UNSIGNED DEFAULT NULL,
  `nombre_prod` varchar(30) NOT NULL,
  `descrip_prod` varchar(70) DEFAULT NULL,
  `estatus_prod` varchar(20) DEFAULT NULL,
  `cant_prod` decimal(5,0) UNSIGNED DEFAULT NULL,
  `stock_max` decimal(10,0) UNSIGNED DEFAULT NULL,
  `stock_min` decimal(10,0) UNSIGNED DEFAULT NULL,
  `marca_prod` varchar(30) DEFAULT NULL,
  `prov_idProv` varchar(30) DEFAULT NULL,
  `precio_compra` decimal(9,0) UNSIGNED DEFAULT NULL,
  `precio_venta` decimal(9,0) UNSIGNED DEFAULT NULL,
  `precio_mayoreo` decimal(9,0) UNSIGNED DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  `iva` decimal(9,0) UNSIGNED DEFAULT NULL,
  `mu_pv` varchar(10) DEFAULT NULL,
  `mu_pm` varchar(10) DEFAULT NULL,
  `unidad_medida` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProductos`, `clave_prod`, `nombre_prod`, `descrip_prod`, `estatus_prod`, `cant_prod`, `stock_max`, `stock_min`, `marca_prod`, `prov_idProv`, `precio_compra`, `precio_venta`, `precio_mayoreo`, `img`, `iva`, `mu_pv`, `mu_pm`, `unidad_medida`) VALUES
(12, 123234134, 'Escoba Madera', 'Madera', 'Disponible', '16', '50', '5', 'Escobar', 'Escobedo', '15', '19', '17', NULL, '16', '150', NULL, 'Pieza'),
(13, 12345, 'JABON LIQUIDO', 'JABON PARA LAVAR TRASTES', 'Disponible', '4', '50', '5', 'AXIÓN', 'ABARROTES SAN PEDRO', '5', '10', '8', NULL, '16', '5', NULL, 'Litro'),
(14, 132, 'JABON LIQUIDO', 'DE ROPA', 'Disponible', '15', '50', '5', 'MAS COLOR', 'COLORES', '5', '9', '7', NULL, '16', '4', NULL, 'Litro'),
(15, 123, 'JABON LIQUIDO', 'LAVA TRASTES', 'Disponible', '50', '50', '5', 'AXION', 'JABONES COLORES', '5', '10', '8', NULL, '16', '5', NULL, 'Litro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProductos`),
  ADD UNIQUE KEY `idProductos_UNIQUE` (`idProductos`),
  ADD UNIQUE KEY `clave_p_UNIQUE` (`clave_prod`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProductos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
