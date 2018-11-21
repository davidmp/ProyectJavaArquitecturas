/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.34-MariaDB : Database - shopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shopping` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `shopping`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `persona_cliente_fk` (`id_persona`),
  CONSTRAINT `persona_cliente_fk` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`id_cliente`,`id_persona`) values 
(1,2),
(2,3);

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `DNI` decimal(8,0) NOT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`id_persona`,`nombre`,`apellidos`,`DNI`) values 
(1,'paxi','paxi',8785454),
(2,'ronaldo','ronaldo',8787545),
(3,'Hernan','Hernan',87878);

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `precio` double NOT NULL,
  `nombre_producto` varchar(20) NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert  into `producto`(`id_producto`,`precio`,`nombre_producto`) values 
(1,30.3,'alquiler'),
(2,4.5,'Desayuno');

/*Table structure for table `servicios` */

DROP TABLE IF EXISTS `servicios`;

CREATE TABLE `servicios` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `servicios` */

insert  into `servicios`(`idServicio`,`idProducto`,`idCliente`,`cantidad`) values 
(1,1,1,2),
(2,2,1,20),
(3,1,2,3);

/*Table structure for table `vendedor` */

DROP TABLE IF EXISTS `vendedor`;

CREATE TABLE `vendedor` (
  `id_vendedor` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `telefono` decimal(9,0) NOT NULL,
  PRIMARY KEY (`id_vendedor`),
  KEY `persona_vendedor__fk` (`id_persona`),
  CONSTRAINT `persona_vendedor__fk` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `vendedor` */

insert  into `vendedor`(`id_vendedor`,`id_persona`,`direccion`,`telefono`) values 
(1,1,'sdddsf',78878);

/*Table structure for table `venta` */

DROP TABLE IF EXISTS `venta`;

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `importe` double NOT NULL,
  `fecha_venta` date NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `cliente_venta_fk` (`id_cliente`),
  KEY `vendedor__venta_fk` (`id_vendedor`),
  CONSTRAINT `cliente_venta_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vendedor__venta_fk` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`id_vendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `venta` */

insert  into `venta`(`id_venta`,`id_cliente`,`id_vendedor`,`importe`,`fecha_venta`) values 
(8,1,1,151,'2018-11-14'),
(9,1,1,150.6,'2018-11-14');

/*Table structure for table `venta_producto` */

DROP TABLE IF EXISTS `venta_producto`;

CREATE TABLE `venta_producto` (
  `id_ventaProductp` int(11) NOT NULL AUTO_INCREMENT,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_ventaProductp`),
  KEY `producto_venta_producto_fk` (`id_producto`),
  KEY `venta_venta_producto_fk` (`id_venta`),
  CONSTRAINT `producto_venta_producto_fk` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `venta_venta_producto_fk` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `venta_producto` */

/* Procedure structure for procedure `registrarVenta` */

/*!50003 DROP PROCEDURE IF EXISTS  `registrarVenta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarVenta`(IN `idVendedor` BIGINT(20), IN idcliente INT)
BEGIN
    DECLARE regexist BIGINT(20);
    
	SELECT SUM(precio) INTO regexist FROM producto p INNER JOIN (SELECT s.idCliente,s.idServicio,s.idProducto  FROM cliente c, servicios s WHERE  s.idCliente=c.id_cliente AND s.idCliente=idcliente) s ON(p.id_producto=s.idProducto);
    
	/*IF regexist = 1 THEN*/
	INSERT INTO venta(id_cliente, id_vendedor,importe, fecha_venta) VALUES(idcliente,idVendedor, regexist, NOW() );
	/*SET msg_out = 'Eliminado correctamente';*/
	/*ELSE
	SET msg_out = 'No existe el registro asi que no se pudo eliminar';*/
	/*END IF;*/
	
	/*SELECT msg_out;  */
	
    END */$$
DELIMITER ;

/* Procedure structure for procedure `ventaOperacion` */

/*!50003 DROP PROCEDURE IF EXISTS  `ventaOperacion` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `ventaOperacion`(IN `idVendedor` BIGINT(20), IN idcliente INT)
BEGIN

	DECLARE regexist double;
    
	SELECT SUM(precio*cantidad) AS importe INTO regexist FROM producto p INNER JOIN (SELECT s.idCliente,s.idServicio,s.idProducto, s.cantidad FROM cliente c, servicios s WHERE  s.idCliente=c.id_cliente AND s.idCliente=idcliente) s ON(p.id_producto=s.idProducto);
    
	/*IF regexist = 1 THEN*/
	INSERT INTO venta(id_cliente, id_vendedor,importe, fecha_venta) VALUES(idcliente,idVendedor, regexist, NOW() );


	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
