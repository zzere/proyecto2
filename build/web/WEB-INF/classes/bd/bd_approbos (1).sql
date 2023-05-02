-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2023 a las 01:41:42
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_approbos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablaadministrador`
--

CREATE TABLE `tablaadministrador` (
  `id_administrador` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tablaadministrador`
--

INSERT INTO `tablaadministrador` (`id_administrador`, `nombre`, `apellido`, `correo`, `contraseña`) VALUES
(5, 'Juan', 'Barbosa', 'juan@hotmail.com', '1233');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablainformante`
--

CREATE TABLE `tablainformante` (
  `id_informante` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `genero` bit(1) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablarobos`
--

CREATE TABLE `tablarobos` (
  `id_robo` int(11) NOT NULL,
  `arma_utilizada` varchar(100) NOT NULL,
  `cantidad_involucrados` varchar(100) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `vehiculo` varchar(100) NOT NULL,
  `fecha_hora` datetime(6) NOT NULL,
  `lugar` varchar(200) NOT NULL,
  `modus_operandi` varchar(200) NOT NULL,
  `objetos_robados` varchar(300) NOT NULL,
  `id_informante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tablaadministrador`
--
ALTER TABLE `tablaadministrador`
  ADD PRIMARY KEY (`id_administrador`);

--
-- Indices de la tabla `tablainformante`
--
ALTER TABLE `tablainformante`
  ADD PRIMARY KEY (`id_informante`);

--
-- Indices de la tabla `tablarobos`
--
ALTER TABLE `tablarobos`
  ADD PRIMARY KEY (`id_robo`),
  ADD KEY `id_informante` (`id_informante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tablaadministrador`
--
ALTER TABLE `tablaadministrador`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tablainformante`
--
ALTER TABLE `tablainformante`
  MODIFY `id_informante` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tablarobos`
--
ALTER TABLE `tablarobos`
  MODIFY `id_robo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tablarobos`
--
ALTER TABLE `tablarobos`
  ADD CONSTRAINT `tablaRobos_ibfk_1` FOREIGN KEY (`id_informante`) REFERENCES `tablainformante` (`id_informante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
