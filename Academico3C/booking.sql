-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-10-2018 a las 18:46:35
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `booking`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(60) DEFAULT NULL,
  `TOKEN` varchar(100) DEFAULT NULL,
  `FECHA_ENTRADA` date DEFAULT NULL,
  `FECHA_SALIDA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`ID`, `NOMBRE`, `EMAIL`, `TOKEN`, `FECHA_ENTRADA`, `FECHA_SALIDA`) VALUES
(1, 'David', 'Mamani', '67569aa3-61d4-4ad6-94ea-92f5e6355d88', '2018-08-20', '2018-08-22'),
(2, 'Elias', 'elias@upeu.edu.pe', 'b4e087db-99f1-4cd3-b1a8-2c5fe520691d', '2018-10-02', '2018-09-06'),
(3, 'Moises', 'moises@gmail.com', '06c11b6f-e9a1-436d-8668-5b1e3a9d5582', '2018-10-05', '2018-10-13'),
(4, 'Raul', 'raul@gmail.com', 'a37b9f54-469e-4eac-90b5-f88a4bff819a', '2018-10-02', '2018-09-06'),
(5, 'Rafael', 'rafael@gmail.com', 'b2455ebf-355a-4816-aede-d9f73d75971a', '2018-10-01', '2018-10-27'),
(6, 'David', 'sad', 'af396714-381a-4f0c-b8e0-9be73aa177f4', '2018-10-03', '2018-08-22'),
(7, 'asadsds', 'sdas@gmail.com', 'bec91fa0-befb-4573-91ed-5098cef684dd', '2018-10-01', '2018-10-19'),
(8, 'David elias', 'ed@gmail.com', 'c55d9625-066a-429b-ada0-2ac32573bdd7', '2018-10-02', '2018-10-23'),
(9, 'David', 'd@gmail.com', '5faf5c9b-8998-464c-9ed8-f30d23eb69b5', '2018-10-29', '2018-10-26');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
