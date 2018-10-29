-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2018 a las 12:53:23
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sysventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aut_historial`
--

CREATE TABLE `aut_historial` (
  `idHistorial` int(11) NOT NULL,
  `usuario` varchar(80) NOT NULL,
  `programa` varchar(200) NOT NULL,
  `hora` time NOT NULL,
  `fecha` date NOT NULL,
  `ip` varchar(30) NOT NULL,
  `accion` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comp_compras`
--

CREATE TABLE `comp_compras` (
  `id_mov_compra` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `fecha_registro` date NOT NULL,
  `serie` varchar(10) NOT NULL,
  `numdoc` varchar(15) NOT NULL,
  `idComprobante` int(11) NOT NULL,
  `idVoucher` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idTipomoneda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comp_compra_detalles`
--

CREATE TABLE `comp_compra_detalles` (
  `idCompraDetalle` int(11) NOT NULL,
  `id_mov_compra` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `preciounit` double NOT NULL,
  `igv` double NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `idAlmacenProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comp_despachos`
--

CREATE TABLE `comp_despachos` (
  `idProbDespachos` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comp_proveedores`
--

CREATE TABLE `comp_proveedores` (
  `idProveedor` int(11) NOT NULL,
  `razonsocial` varchar(150) NOT NULL,
  `ruc` varchar(12) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `estado` int(11) NOT NULL,
  `idPersona` int(11) DEFAULT NULL COMMENT '--Representante legal',
  `idTipoProveedor` int(11) NOT NULL,
  `direccion_fiscal` varchar(80) NOT NULL,
  `idCodigoPostal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comp_tipo_proveedor`
--

CREATE TABLE `comp_tipo_proveedor` (
  `idTipoProveedor` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comp_voucher`
--

CREATE TABLE `comp_voucher` (
  `idVoucher` int(11) NOT NULL,
  `idCompra` int(11) NOT NULL,
  `libro` varchar(4) NOT NULL,
  `voucher` varchar(22) NOT NULL,
  `nivel` varchar(12) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(5) NOT NULL,
  `modulo` varchar(20) NOT NULL,
  `lote` varchar(30) NOT NULL,
  `idAperturaPeriodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cont_cuenta`
--

CREATE TABLE `cont_cuenta` (
  `idCuenta` int(11) NOT NULL,
  `cuenta` varchar(12) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `idElemento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cont_division`
--

CREATE TABLE `cont_division` (
  `idDivision` int(11) NOT NULL,
  `cuenta` varchar(12) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `idSubCuenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cont_elemento`
--

CREATE TABLE `cont_elemento` (
  `idElemento` int(11) NOT NULL,
  `cuenta` varchar(12) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cont_subdiv_cuenta`
--

CREATE TABLE `cont_subdiv_cuenta` (
  `idSubdivCuenta` int(11) NOT NULL,
  `cuenta` varchar(14) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `idDivision` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cont_sub_cuenta`
--

CREATE TABLE `cont_sub_cuenta` (
  `idSubCuenta` int(11) NOT NULL,
  `cuenta` varchar(12) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `idCuenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_almacen`
--

CREATE TABLE `glo_almacen` (
  `idAlmacen` int(11) NOT NULL,
  `nombreAlmacen` varchar(20) NOT NULL,
  `descripcion` varchar(40) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `idSucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_almacen_producto`
--

CREATE TABLE `glo_almacen_producto` (
  `idAlmacenProducto` int(11) NOT NULL,
  `idAlmacen` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `precio_producto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_apertura_periodo`
--

CREATE TABLE `glo_apertura_periodo` (
  `idAperturaPeriodo` int(11) NOT NULL,
  `idConfiguracion` int(11) NOT NULL,
  `idAlmacen` int(11) NOT NULL,
  `idPeriodo` int(11) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `ip` varchar(30) NOT NULL,
  `idTrabajador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_area_usuario`
--

CREATE TABLE `glo_area_usuario` (
  `idAreaUsuario` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_cargo`
--

CREATE TABLE `glo_cargo` (
  `idCargo` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `estado` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_categoriamanufact`
--

CREATE TABLE `glo_categoriamanufact` (
  `idCategoriamanufactura` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL COMMENT '--ejecutivo, simple,---otros',
  `estado` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_categoria_producto`
--

CREATE TABLE `glo_categoria_producto` (
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_codigopostal`
--

CREATE TABLE `glo_codigopostal` (
  `idCodigoPostal` int(11) NOT NULL,
  `ubigeo` varchar(20) NOT NULL,
  `distrito` varchar(60) NOT NULL,
  `provincia` varchar(60) NOT NULL,
  `departamento` varchar(60) NOT NULL,
  `pais` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_companhia`
--

CREATE TABLE `glo_companhia` (
  `idCompanhia` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `razonsocial` varchar(80) NOT NULL,
  `direccionlegal` varchar(80) NOT NULL,
  `direccionref` varchar(80) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `celular` varchar(12) NOT NULL,
  `ruc` varchar(12) NOT NULL,
  `paginaweb` varchar(100) NOT NULL,
  `email` varchar(60) NOT NULL,
  `logo` varchar(80) NOT NULL,
  `siglas` varchar(30) NOT NULL,
  `replegal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_comprobante`
--

CREATE TABLE `glo_comprobante` (
  `idComprobante` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `codigo` varchar(6) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_configuracion`
--

CREATE TABLE `glo_configuracion` (
  `idConfiguracion` int(11) NOT NULL,
  `id_cuenta_igv` varchar(22) NOT NULL,
  `igv_porcent` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_empresa`
--

CREATE TABLE `glo_empresa` (
  `idEmpresa` int(11) NOT NULL,
  `razonsocial` varchar(80) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `direccionlegal` varchar(80) NOT NULL,
  `direccionref` varchar(80) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `celular` varchar(12) NOT NULL,
  `ruc` varchar(12) NOT NULL,
  `paginaweb` varchar(80) NOT NULL,
  `email` varchar(60) NOT NULL,
  `logo` varchar(80) NOT NULL,
  `siglas` varchar(30) NOT NULL,
  `repLegal` varchar(100) NOT NULL,
  `docidentReplegal` varchar(12) NOT NULL,
  `nombreAnho` varchar(200) NOT NULL,
  `gradoReplegal` varchar(20) NOT NULL,
  `idCompanhia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_manufactura`
--

CREATE TABLE `glo_manufactura` (
  `idManufactura` int(11) NOT NULL,
  `idTipomanufact` int(11) NOT NULL,
  `idCategoriamanufactura` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `descripcion` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_manufactura_almacen`
--

CREATE TABLE `glo_manufactura_almacen` (
  `idManufactAlmacen` int(11) NOT NULL,
  `idManufactura` int(11) NOT NULL,
  `precio` double NOT NULL,
  `stockdia` double NOT NULL,
  `idAlmacen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_periodo`
--

CREATE TABLE `glo_periodo` (
  `idPeriodo` int(11) NOT NULL,
  `periodo` varchar(20) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_personas`
--

CREATE TABLE `glo_personas` (
  `idPersona` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `nombre2` varchar(30) NOT NULL,
  `apell_paterno` varchar(60) NOT NULL,
  `apell_materno` varchar(60) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `usuario` varchar(30) NOT NULL,
  `clave` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `idioma` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `glo_personas`
--

INSERT INTO `glo_personas` (`idPersona`, `nombre`, `nombre2`, `apell_paterno`, `apell_materno`, `dni`, `fecha_nacimiento`, `sexo`, `direccion`, `celular`, `usuario`, `clave`, `email`, `idioma`) VALUES
(1, 'David', '-', 'mamani', 'pari', '43631917', '2018-10-01', 'M', 'Juliaca', '951782520', 'davidmp', '4545', 'mamanipari@gmail.com', 'en'),
(5, 'Elias', 'Ramon', 'Mamani', 'Pari', '65988754', '2018-10-06', 'M', 'Av. Selva alegre Mz-G Lt-14', '951782520', 'eliasmp', 'dds', 'elias@upeu.edu.pe', 'es'),
(6, 'Raul', 'Paul', 'Mendoza', 'Peredo', '21548765', '2014-11-01', 'M', 'Av. Selva alegre Mz-G Lt-14', '951782520', 'peredo', '}7}7', 'peredo@upeu.edu.pe', 'en'),
(7, 'Harley', '-', 'Sancho', 'Perez', '65847121', '2008-02-28', 'M', 'Av. Selva alegre Mz-G Lt-14', '951782520', 'sancho', 'sd', 'sancho@upeu.edu.pe', 'en'),
(8, 'Moises', '-', 'Mamani', 'Pari', '98548754', '2018-10-04', 'M', 'Av. Los Angeles', '951782520', 'moisesmp', '215487', 'mosises@upeu.edu.pe', 'es'),
(9, 'Raul', 'Ramon', 'Mendoza', 'Pari', '26251447', '2018-10-24', 'M', 'Av. Selva alegre Mz-G Lt-14', '951782520', 'peredo2', 'fgfdg', 'peredo@upeu.edu.pe', 'es');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_productos`
--

CREATE TABLE `glo_productos` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `preciounitario` double NOT NULL,
  `estado` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_sucursal`
--

CREATE TABLE `glo_sucursal` (
  `idSucursal` int(11) NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  `lugar` varchar(80) NOT NULL,
  `direccion` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_tipodocidentidad`
--

CREATE TABLE `glo_tipodocidentidad` (
  `idTipodocidentidad` int(11) NOT NULL,
  `codigo` varchar(2) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_tipomanufact`
--

CREATE TABLE `glo_tipomanufact` (
  `idTipomanufact` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL COMMENT '--Almuerzo--Cena--Desayuno',
  `estado` int(11) NOT NULL,
  `tipo` varchar(15) DEFAULT NULL COMMENT '--Almuerzo, Cena, Desayuno'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_tipomoneda`
--

CREATE TABLE `glo_tipomoneda` (
  `idTipomoneda` int(11) NOT NULL,
  `codigo` varchar(2) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `simbolo` varchar(5) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `tipocambio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_unidadmed_manufact`
--

CREATE TABLE `glo_unidadmed_manufact` (
  `idUnidadManufact` int(11) NOT NULL,
  `idUnidadMedida` int(11) NOT NULL,
  `idManufactura` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `orden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_unidadmed_producto`
--

CREATE TABLE `glo_unidadmed_producto` (
  `idUnidMedProducto` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idUnidadMedida` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  `unidadmin` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_unidad_medida`
--

CREATE TABLE `glo_unidad_medida` (
  `idUnidadMedida` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `simbolo` varchar(4) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_usuario`
--

CREATE TABLE `glo_usuario` (
  `idUsuario` int(11) NOT NULL,
  `fecha_acceso` date NOT NULL,
  `fecha_alta` datetime NOT NULL,
  `ip` varchar(30) NOT NULL,
  `estado` int(11) DEFAULT NULL COMMENT '--1=Activo---0=Desactivo',
  `idPersona` int(11) NOT NULL,
  `idAreaUsuario` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `idCargo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `glo_usuarioalmacen`
--

CREATE TABLE `glo_usuarioalmacen` (
  `idUsuarioAlamacen` int(11) NOT NULL,
  `idAlmacen` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `estado` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sys_accesos`
--

CREATE TABLE `sys_accesos` (
  `idAccesos` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `nombre` varchar(22) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `url` varchar(200) NOT NULL,
  `codigo_seg` varchar(4) NOT NULL,
  `nro_orden` int(11) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `imagen` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sys_accesos_perfiles`
--

CREATE TABLE `sys_accesos_perfiles` (
  `idAccesosPerfiles` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `idAccesos` int(11) NOT NULL,
  `estado` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sys_grupo`
--

CREATE TABLE `sys_grupo` (
  `idGrupo` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `etiqueta` varchar(3) NOT NULL,
  `imagen` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sys_menu`
--

CREATE TABLE `sys_menu` (
  `idMenu` int(11) NOT NULL,
  `idGrupo` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `etiqueta` varchar(3) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `imagen` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sys_perfiles`
--

CREATE TABLE `sys_perfiles` (
  `idPerfil` int(11) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `codigo` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sys_privilegios`
--

CREATE TABLE `sys_privilegios` (
  `idPrivilegios` int(11) NOT NULL,
  `idAccesos` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL,
  `ip` varchar(30) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `idPersonaUser` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_clientes`
--

CREATE TABLE `vent_clientes` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `paterno` varchar(60) NOT NULL,
  `materno` varchar(60) NOT NULL,
  `estado` int(11) NOT NULL,
  `idTipoCliente` int(11) NOT NULL,
  `ruc` varchar(12) NOT NULL,
  `numdoc_ident` varchar(20) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `idTipodocidentidad` int(11) NOT NULL,
  `celularcontacto` varchar(10) NOT NULL,
  `idCodigoPostal` int(11) NOT NULL,
  `direccion_fiscal` varchar(80) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_cotordenventa`
--

CREATE TABLE `vent_cotordenventa` (
  `idCotordenventa` int(11) NOT NULL,
  `idComprobante` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idTipomoneda` int(11) NOT NULL,
  `tipo_venta` varchar(6) DEFAULT NULL COMMENT '--Manufactura--Retail',
  `fecha_venta` datetime NOT NULL,
  `fecha_venc` datetime NOT NULL,
  `glosa` varchar(80) NOT NULL,
  `export_import` double NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `isc` double NOT NULL,
  `importe` double NOT NULL,
  `descuento` double NOT NULL,
  `anticipo` double NOT NULL,
  `saldo` double NOT NULL,
  `tipo_cambio` double NOT NULL,
  `estado` varchar(5) DEFAULT NULL COMMENT '--Cotizacion--Orden pedido',
  `ip` varchar(30) NOT NULL,
  `comentario` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_despachos`
--

CREATE TABLE `vent_despachos` (
  `idDespachos` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_detalle_cotordenventa`
--

CREATE TABLE `vent_detalle_cotordenventa` (
  `idDetallecotordenventa` int(11) NOT NULL,
  `idCotordenventa` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL,
  `dc` varchar(2) NOT NULL,
  `detalle` varchar(80) NOT NULL,
  `cantidad` double NOT NULL,
  `preciounit` double NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `importe` double NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `impuestoigv` double NOT NULL,
  `fecha_entrega` date NOT NULL,
  `idTrabajador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_detalle_guiaremision`
--

CREATE TABLE `vent_detalle_guiaremision` (
  `idDetalleguiaremision` int(11) NOT NULL,
  `idGuiaremision` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL,
  `dc` varchar(2) NOT NULL,
  `detalle` varchar(80) NOT NULL,
  `cantidad` double NOT NULL,
  `preciounit` double NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `importe` double NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `impuestoigv` double NOT NULL,
  `fecha_entrega` date NOT NULL,
  `idTrabajador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_guiaremision`
--

CREATE TABLE `vent_guiaremision` (
  `idGuiaremision` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `idComprobante` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `idTipomoneda` int(11) NOT NULL,
  `tipo_venta` varchar(10) DEFAULT NULL COMMENT '--manufactura --retail',
  `fecha_guia` date NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `glosa` varchar(80) NOT NULL,
  `export_import` double NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `isc` double NOT NULL,
  `importante` double NOT NULL,
  `descuento` double NOT NULL,
  `anticipo` double NOT NULL,
  `saldo` double NOT NULL,
  `tipo_cambio` double NOT NULL,
  `estado` varchar(5) NOT NULL,
  `ip` varchar(30) NOT NULL,
  `comentario` varchar(40) NOT NULL,
  `orden` varchar(10) DEFAULT NULL COMMENT '--PosVenta---PreVenta',
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_salidadiv_detalles`
--

CREATE TABLE `vent_salidadiv_detalles` (
  `idDetalleSalDiv` int(11) NOT NULL,
  `idSalidaDiversa` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `preciounit` double NOT NULL,
  `importe` double NOT NULL,
  `idAlmacenProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_salida_diversa`
--

CREATE TABLE `vent_salida_diversa` (
  `idSalidaDiversa` int(11) NOT NULL,
  `fecha_salida` date NOT NULL,
  `motivo` varchar(100) NOT NULL,
  `serie` varchar(10) NOT NULL,
  `numdoc` varchar(15) NOT NULL,
  `estado` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_tipo_cliente`
--

CREATE TABLE `vent_tipo_cliente` (
  `idTipoCliente` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_ventas`
--

CREATE TABLE `vent_ventas` (
  `id_mov_vnt` int(11) NOT NULL,
  `idVoucher` int(11) NOT NULL,
  `idTipomoneda` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idComprobante` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `tipo_venta` varchar(6) NOT NULL,
  `fecha_venta` date NOT NULL,
  `fecha_doc` datetime NOT NULL,
  `fecha_venc` datetime NOT NULL,
  `serie` varchar(10) NOT NULL,
  `numvnt` varchar(15) NOT NULL,
  `export_import` double NOT NULL,
  `glosa` varchar(80) NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `isc` double NOT NULL,
  `importe` double NOT NULL,
  `descuento` double NOT NULL,
  `anticipo` double NOT NULL,
  `saldo` double NOT NULL,
  `tipo_cambio` double NOT NULL,
  `estado` varchar(5) NOT NULL,
  `ip` varchar(30) NOT NULL,
  `mod_fecha` datetime NOT NULL,
  `mod_tipo` varchar(6) NOT NULL,
  `mod_serie` varchar(10) NOT NULL,
  `mod_numdoc` varchar(10) NOT NULL,
  `comentario` varchar(40) NOT NULL,
  `obscredito` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_ventas_detalles`
--

CREATE TABLE `vent_ventas_detalles` (
  `idVentaDetalle` int(11) NOT NULL,
  `idAlmacenProducto` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `dc` varchar(2) NOT NULL,
  `detalle` varchar(80) NOT NULL,
  `cantidad` double NOT NULL,
  `preciounit` double NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `importe` double NOT NULL,
  `estado` varchar(5) NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `impuestoigv` double NOT NULL,
  `fecha_entrega` date NOT NULL,
  `idTrabajador` int(11) DEFAULT NULL,
  `id_mov_vnt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_venta_servicio`
--

CREATE TABLE `vent_venta_servicio` (
  `idVentaServicio` int(11) NOT NULL,
  `idComprobante` int(11) NOT NULL,
  `idVoucher` int(11) NOT NULL,
  `idTipomoneda` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `tipo_venta` varchar(6) NOT NULL,
  `fecha_venta` date NOT NULL,
  `fecha_doc` datetime NOT NULL,
  `fecha_venc` datetime NOT NULL,
  `seria` varchar(10) NOT NULL,
  `numvnt` varchar(15) NOT NULL,
  `export_import` double NOT NULL,
  `glosa` varchar(80) NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `isc` double NOT NULL,
  `importe` double NOT NULL,
  `descuento` double NOT NULL,
  `anticipo` double NOT NULL,
  `saldo` double NOT NULL,
  `tipo_cambio` double NOT NULL,
  `estado` varchar(5) NOT NULL,
  `ip` varchar(30) NOT NULL,
  `mod_fecha` datetime NOT NULL,
  `mod_tipo` varchar(6) NOT NULL,
  `mod_serie` varchar(10) NOT NULL,
  `mod_numdoc` varchar(10) NOT NULL,
  `comentario` varchar(40) NOT NULL,
  `obscredito` varchar(40) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_venta_servicio_detalle`
--

CREATE TABLE `vent_venta_servicio_detalle` (
  `idVentaServicioDetalle` int(11) NOT NULL,
  `idVentaServicio` int(11) NOT NULL,
  `idManufactAlmacen` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `dc` varchar(2) NOT NULL,
  `detalle` varchar(80) NOT NULL,
  `cantidad` double NOT NULL,
  `preciounit` double NOT NULL,
  `base_imp` double NOT NULL,
  `igv` double NOT NULL,
  `importe` double NOT NULL,
  `exonerados` double NOT NULL,
  `inafectos` double NOT NULL,
  `impuestoigv` double NOT NULL,
  `estado` varchar(5) NOT NULL,
  `fecha_entrega` date NOT NULL,
  `idTrabajador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vent_voucher`
--

CREATE TABLE `vent_voucher` (
  `idVoucher` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `voucher` varchar(12) NOT NULL,
  `libro` varchar(4) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(5) NOT NULL,
  `modulo` varchar(20) NOT NULL,
  `lote` varchar(30) NOT NULL,
  `idAperturaPeriodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aut_historial`
--
ALTER TABLE `aut_historial`
  ADD PRIMARY KEY (`idHistorial`);

--
-- Indices de la tabla `comp_compras`
--
ALTER TABLE `comp_compras`
  ADD PRIMARY KEY (`id_mov_compra`),
  ADD KEY `glo_tipomoneda_comp_compras_fk` (`idTipomoneda`),
  ADD KEY `comp_voucher_comp_compras_fk` (`idVoucher`),
  ADD KEY `tipodocumento_compras_fk` (`idComprobante`),
  ADD KEY `glo_usuario_comp_compras_fk` (`idUsuario`),
  ADD KEY `proveedores_compras_fk` (`idProveedor`);

--
-- Indices de la tabla `comp_compra_detalles`
--
ALTER TABLE `comp_compra_detalles`
  ADD PRIMARY KEY (`idCompraDetalle`),
  ADD KEY `compras_compra_detalles_fk` (`id_mov_compra`),
  ADD KEY `almacen_producto_compra_detalles_fk` (`idAlmacenProducto`);

--
-- Indices de la tabla `comp_despachos`
--
ALTER TABLE `comp_despachos`
  ADD PRIMARY KEY (`idProbDespachos`),
  ADD KEY `comp_proveedores_comp_despachos_fk` (`idProveedor`);

--
-- Indices de la tabla `comp_proveedores`
--
ALTER TABLE `comp_proveedores`
  ADD PRIMARY KEY (`idProveedor`),
  ADD KEY `glo_codigopostal_comp_proveedores_fk` (`idCodigoPostal`),
  ADD KEY `tipo_proveedor_proveedores_fk` (`idTipoProveedor`),
  ADD KEY `personas_proveedores_fk` (`idPersona`);

--
-- Indices de la tabla `comp_tipo_proveedor`
--
ALTER TABLE `comp_tipo_proveedor`
  ADD PRIMARY KEY (`idTipoProveedor`);

--
-- Indices de la tabla `comp_voucher`
--
ALTER TABLE `comp_voucher`
  ADD PRIMARY KEY (`idVoucher`),
  ADD KEY `glo_apertura_periodo_comp_voucher_fk` (`idAperturaPeriodo`);

--
-- Indices de la tabla `cont_cuenta`
--
ALTER TABLE `cont_cuenta`
  ADD PRIMARY KEY (`idCuenta`),
  ADD KEY `cont_elemento_cont_cuenta_fk` (`idElemento`);

--
-- Indices de la tabla `cont_division`
--
ALTER TABLE `cont_division`
  ADD PRIMARY KEY (`idDivision`),
  ADD KEY `cont_sub_cuenta_cont_division_fk` (`idSubCuenta`);

--
-- Indices de la tabla `cont_elemento`
--
ALTER TABLE `cont_elemento`
  ADD PRIMARY KEY (`idElemento`);

--
-- Indices de la tabla `cont_subdiv_cuenta`
--
ALTER TABLE `cont_subdiv_cuenta`
  ADD PRIMARY KEY (`idSubdivCuenta`),
  ADD KEY `cont_division_cont_subdiv_cuenta_fk` (`idDivision`);

--
-- Indices de la tabla `cont_sub_cuenta`
--
ALTER TABLE `cont_sub_cuenta`
  ADD PRIMARY KEY (`idSubCuenta`),
  ADD KEY `cont_cuenta_cont_sub_cuenta_fk` (`idCuenta`);

--
-- Indices de la tabla `glo_almacen`
--
ALTER TABLE `glo_almacen`
  ADD PRIMARY KEY (`idAlmacen`),
  ADD KEY `glo_sucursal_almacen_fk` (`idSucursal`);

--
-- Indices de la tabla `glo_almacen_producto`
--
ALTER TABLE `glo_almacen_producto`
  ADD PRIMARY KEY (`idAlmacenProducto`),
  ADD KEY `almacen_almacen_producto_fk` (`idAlmacen`),
  ADD KEY `productos_almacen_producto_fk` (`idProducto`);

--
-- Indices de la tabla `glo_apertura_periodo`
--
ALTER TABLE `glo_apertura_periodo`
  ADD PRIMARY KEY (`idAperturaPeriodo`),
  ADD KEY `glo_periodo_glo_apertura_periodo_fk` (`idPeriodo`),
  ADD KEY `glo_configuracion_glo_apertura_periodo_fk` (`idConfiguracion`),
  ADD KEY `almacen_glo_apertura_periodo_fk` (`idAlmacen`);

--
-- Indices de la tabla `glo_area_usuario`
--
ALTER TABLE `glo_area_usuario`
  ADD PRIMARY KEY (`idAreaUsuario`);

--
-- Indices de la tabla `glo_cargo`
--
ALTER TABLE `glo_cargo`
  ADD PRIMARY KEY (`idCargo`);

--
-- Indices de la tabla `glo_categoriamanufact`
--
ALTER TABLE `glo_categoriamanufact`
  ADD PRIMARY KEY (`idCategoriamanufactura`);

--
-- Indices de la tabla `glo_categoria_producto`
--
ALTER TABLE `glo_categoria_producto`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `glo_codigopostal`
--
ALTER TABLE `glo_codigopostal`
  ADD PRIMARY KEY (`idCodigoPostal`);

--
-- Indices de la tabla `glo_companhia`
--
ALTER TABLE `glo_companhia`
  ADD PRIMARY KEY (`idCompanhia`);

--
-- Indices de la tabla `glo_comprobante`
--
ALTER TABLE `glo_comprobante`
  ADD PRIMARY KEY (`idComprobante`);

--
-- Indices de la tabla `glo_configuracion`
--
ALTER TABLE `glo_configuracion`
  ADD PRIMARY KEY (`idConfiguracion`);

--
-- Indices de la tabla `glo_empresa`
--
ALTER TABLE `glo_empresa`
  ADD PRIMARY KEY (`idEmpresa`),
  ADD KEY `glo_companhia_glo_empresa_fk` (`idCompanhia`);

--
-- Indices de la tabla `glo_manufactura`
--
ALTER TABLE `glo_manufactura`
  ADD PRIMARY KEY (`idManufactura`),
  ADD KEY `categoria_categor_menus_fk` (`idCategoriamanufactura`),
  ADD KEY `menus_categor_menus_fk` (`idTipomanufact`);

--
-- Indices de la tabla `glo_manufactura_almacen`
--
ALTER TABLE `glo_manufactura_almacen`
  ADD PRIMARY KEY (`idManufactAlmacen`),
  ADD KEY `almacen_menus_almacen_fk` (`idAlmacen`),
  ADD KEY `categor_menus_menus_almacen_fk` (`idManufactura`);

--
-- Indices de la tabla `glo_periodo`
--
ALTER TABLE `glo_periodo`
  ADD PRIMARY KEY (`idPeriodo`);

--
-- Indices de la tabla `glo_personas`
--
ALTER TABLE `glo_personas`
  ADD PRIMARY KEY (`idPersona`),
  ADD UNIQUE KEY `personas_idx` (`dni`);

--
-- Indices de la tabla `glo_productos`
--
ALTER TABLE `glo_productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `categoria_productos_fk` (`idCategoria`);

--
-- Indices de la tabla `glo_sucursal`
--
ALTER TABLE `glo_sucursal`
  ADD PRIMARY KEY (`idSucursal`),
  ADD KEY `glo_empresa_glo_sucursal_fk` (`idEmpresa`);

--
-- Indices de la tabla `glo_tipodocidentidad`
--
ALTER TABLE `glo_tipodocidentidad`
  ADD PRIMARY KEY (`idTipodocidentidad`);

--
-- Indices de la tabla `glo_tipomanufact`
--
ALTER TABLE `glo_tipomanufact`
  ADD PRIMARY KEY (`idTipomanufact`);

--
-- Indices de la tabla `glo_tipomoneda`
--
ALTER TABLE `glo_tipomoneda`
  ADD PRIMARY KEY (`idTipomoneda`);

--
-- Indices de la tabla `glo_unidadmed_manufact`
--
ALTER TABLE `glo_unidadmed_manufact`
  ADD PRIMARY KEY (`idUnidadManufact`),
  ADD KEY `unidad_medida_unidadmed_manufact_fk` (`idUnidadMedida`),
  ADD KEY `manufactura_unidadmed_manufact_fk` (`idManufactura`);

--
-- Indices de la tabla `glo_unidadmed_producto`
--
ALTER TABLE `glo_unidadmed_producto`
  ADD PRIMARY KEY (`idUnidMedProducto`),
  ADD KEY `unidad_medida_unidadmed_producto_fk` (`idUnidadMedida`),
  ADD KEY `productos_unidadmed_producto_fk` (`idProducto`);

--
-- Indices de la tabla `glo_unidad_medida`
--
ALTER TABLE `glo_unidad_medida`
  ADD PRIMARY KEY (`idUnidadMedida`);

--
-- Indices de la tabla `glo_usuario`
--
ALTER TABLE `glo_usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `glo_cargo_glo_usuario_fk` (`idCargo`),
  ADD KEY `sys_perfiles_glo_usuario_fk` (`idPerfil`),
  ADD KEY `area_trabajador_trabajador_fk` (`idAreaUsuario`),
  ADD KEY `personas_trabajador_fk` (`idPersona`);

--
-- Indices de la tabla `glo_usuarioalmacen`
--
ALTER TABLE `glo_usuarioalmacen`
  ADD PRIMARY KEY (`idUsuarioAlamacen`),
  ADD KEY `glo_almacen_glo_usuarioalmacen_fk` (`idAlmacen`),
  ADD KEY `glo_usuario_glo_usuarioalmacen_fk` (`idUsuario`);

--
-- Indices de la tabla `sys_accesos`
--
ALTER TABLE `sys_accesos`
  ADD PRIMARY KEY (`idAccesos`),
  ADD KEY `sys_menu_sys_accesos_fk` (`idMenu`);

--
-- Indices de la tabla `sys_accesos_perfiles`
--
ALTER TABLE `sys_accesos_perfiles`
  ADD PRIMARY KEY (`idAccesosPerfiles`),
  ADD KEY `sys_accesos_sys_accesos_perfiles_fk` (`idAccesos`),
  ADD KEY `sys_perfiles_sys_accesos_perfiles_fk` (`idPerfil`);

--
-- Indices de la tabla `sys_grupo`
--
ALTER TABLE `sys_grupo`
  ADD PRIMARY KEY (`idGrupo`);

--
-- Indices de la tabla `sys_menu`
--
ALTER TABLE `sys_menu`
  ADD PRIMARY KEY (`idMenu`),
  ADD KEY `sys_grupo_sys_menu_fk` (`idGrupo`);

--
-- Indices de la tabla `sys_perfiles`
--
ALTER TABLE `sys_perfiles`
  ADD PRIMARY KEY (`idPerfil`);

--
-- Indices de la tabla `sys_privilegios`
--
ALTER TABLE `sys_privilegios`
  ADD PRIMARY KEY (`idPrivilegios`),
  ADD KEY `sys_accesos_sys_privilegios_fk` (`idAccesos`),
  ADD KEY `glo_usuario_sys_privilegios_fk` (`idUsuario`);

--
-- Indices de la tabla `vent_clientes`
--
ALTER TABLE `vent_clientes`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `glo_codigopostal_vent_clientes_fk` (`idCodigoPostal`),
  ADD KEY `tipodocidentidad_clientes_fk` (`idTipodocidentidad`),
  ADD KEY `tipo_cliente_clientes_fk` (`idTipoCliente`);

--
-- Indices de la tabla `vent_cotordenventa`
--
ALTER TABLE `vent_cotordenventa`
  ADD PRIMARY KEY (`idCotordenventa`);

--
-- Indices de la tabla `vent_despachos`
--
ALTER TABLE `vent_despachos`
  ADD PRIMARY KEY (`idDespachos`),
  ADD KEY `vent_clientes_vent_despachos_fk` (`idCliente`);

--
-- Indices de la tabla `vent_detalle_cotordenventa`
--
ALTER TABLE `vent_detalle_cotordenventa`
  ADD PRIMARY KEY (`idDetallecotordenventa`),
  ADD KEY `cotordenventa_detalle_cotordenventa_fk` (`idCotordenventa`);

--
-- Indices de la tabla `vent_detalle_guiaremision`
--
ALTER TABLE `vent_detalle_guiaremision`
  ADD PRIMARY KEY (`idDetalleguiaremision`),
  ADD KEY `guiaremision_detalle_guiaremision_fk` (`idGuiaremision`);

--
-- Indices de la tabla `vent_guiaremision`
--
ALTER TABLE `vent_guiaremision`
  ADD PRIMARY KEY (`idGuiaremision`);

--
-- Indices de la tabla `vent_salidadiv_detalles`
--
ALTER TABLE `vent_salidadiv_detalles`
  ADD PRIMARY KEY (`idDetalleSalDiv`),
  ADD KEY `salida_diversa_salidadiv_detalles_fk` (`idSalidaDiversa`),
  ADD KEY `almacen_producto_salidadiv_detalles_fk` (`idAlmacenProducto`);

--
-- Indices de la tabla `vent_salida_diversa`
--
ALTER TABLE `vent_salida_diversa`
  ADD PRIMARY KEY (`idSalidaDiversa`),
  ADD KEY `glo_usuario_vent_salida_diversa_fk` (`idUsuario`);

--
-- Indices de la tabla `vent_tipo_cliente`
--
ALTER TABLE `vent_tipo_cliente`
  ADD PRIMARY KEY (`idTipoCliente`);

--
-- Indices de la tabla `vent_ventas`
--
ALTER TABLE `vent_ventas`
  ADD PRIMARY KEY (`id_mov_vnt`),
  ADD KEY `tipomoneda_ventas_fk` (`idTipomoneda`),
  ADD KEY `vent_voucher_ventas_fk` (`idVoucher`),
  ADD KEY `glo_comprobante_vent_ventas_fk` (`idComprobante`),
  ADD KEY `glo_usuario_vent_ventas_fk` (`idUsuario`),
  ADD KEY `vent_clientes_vent_ventas_fk` (`idCliente`);

--
-- Indices de la tabla `vent_ventas_detalles`
--
ALTER TABLE `vent_ventas_detalles`
  ADD PRIMARY KEY (`idVentaDetalle`),
  ADD KEY `almacen_producto_venta_detalles_fk` (`idAlmacenProducto`),
  ADD KEY `vent_ventas_vent_ventas_detalles_fk` (`id_mov_vnt`);

--
-- Indices de la tabla `vent_venta_servicio`
--
ALTER TABLE `vent_venta_servicio`
  ADD PRIMARY KEY (`idVentaServicio`),
  ADD KEY `glo_tipomoneda_vent_venta_servicio_fk` (`idTipomoneda`),
  ADD KEY `vent_voucher_vent_venta_servicio_fk` (`idVoucher`),
  ADD KEY `tipodocumento_venta_servicio_fk` (`idComprobante`),
  ADD KEY `glo_usuario_vent_venta_servicio_fk` (`idUsuario`),
  ADD KEY `vent_clientes_vent_venta_servicio_fk` (`idCliente`);

--
-- Indices de la tabla `vent_venta_servicio_detalle`
--
ALTER TABLE `vent_venta_servicio_detalle`
  ADD PRIMARY KEY (`idVentaServicioDetalle`),
  ADD KEY `venta_servicio_venta_servicio_detalle_fk` (`idVentaServicio`),
  ADD KEY `menus_almacen_venta_servicio_detalle_fk` (`idManufactAlmacen`);

--
-- Indices de la tabla `vent_voucher`
--
ALTER TABLE `vent_voucher`
  ADD PRIMARY KEY (`idVoucher`),
  ADD KEY `glo_apertura_periodo_vent_voucher_fk` (`idAperturaPeriodo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aut_historial`
--
ALTER TABLE `aut_historial`
  MODIFY `idHistorial` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `comp_compras`
--
ALTER TABLE `comp_compras`
  MODIFY `id_mov_compra` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `comp_compra_detalles`
--
ALTER TABLE `comp_compra_detalles`
  MODIFY `idCompraDetalle` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `comp_despachos`
--
ALTER TABLE `comp_despachos`
  MODIFY `idProbDespachos` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `comp_proveedores`
--
ALTER TABLE `comp_proveedores`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `comp_tipo_proveedor`
--
ALTER TABLE `comp_tipo_proveedor`
  MODIFY `idTipoProveedor` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `comp_voucher`
--
ALTER TABLE `comp_voucher`
  MODIFY `idVoucher` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cont_cuenta`
--
ALTER TABLE `cont_cuenta`
  MODIFY `idCuenta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cont_division`
--
ALTER TABLE `cont_division`
  MODIFY `idDivision` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cont_elemento`
--
ALTER TABLE `cont_elemento`
  MODIFY `idElemento` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cont_subdiv_cuenta`
--
ALTER TABLE `cont_subdiv_cuenta`
  MODIFY `idSubdivCuenta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cont_sub_cuenta`
--
ALTER TABLE `cont_sub_cuenta`
  MODIFY `idSubCuenta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_almacen`
--
ALTER TABLE `glo_almacen`
  MODIFY `idAlmacen` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_almacen_producto`
--
ALTER TABLE `glo_almacen_producto`
  MODIFY `idAlmacenProducto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_apertura_periodo`
--
ALTER TABLE `glo_apertura_periodo`
  MODIFY `idAperturaPeriodo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_area_usuario`
--
ALTER TABLE `glo_area_usuario`
  MODIFY `idAreaUsuario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_cargo`
--
ALTER TABLE `glo_cargo`
  MODIFY `idCargo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_categoriamanufact`
--
ALTER TABLE `glo_categoriamanufact`
  MODIFY `idCategoriamanufactura` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_categoria_producto`
--
ALTER TABLE `glo_categoria_producto`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_codigopostal`
--
ALTER TABLE `glo_codigopostal`
  MODIFY `idCodigoPostal` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_companhia`
--
ALTER TABLE `glo_companhia`
  MODIFY `idCompanhia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_comprobante`
--
ALTER TABLE `glo_comprobante`
  MODIFY `idComprobante` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_configuracion`
--
ALTER TABLE `glo_configuracion`
  MODIFY `idConfiguracion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_empresa`
--
ALTER TABLE `glo_empresa`
  MODIFY `idEmpresa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_manufactura`
--
ALTER TABLE `glo_manufactura`
  MODIFY `idManufactura` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_manufactura_almacen`
--
ALTER TABLE `glo_manufactura_almacen`
  MODIFY `idManufactAlmacen` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_periodo`
--
ALTER TABLE `glo_periodo`
  MODIFY `idPeriodo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_personas`
--
ALTER TABLE `glo_personas`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `glo_productos`
--
ALTER TABLE `glo_productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_sucursal`
--
ALTER TABLE `glo_sucursal`
  MODIFY `idSucursal` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_tipodocidentidad`
--
ALTER TABLE `glo_tipodocidentidad`
  MODIFY `idTipodocidentidad` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_tipomanufact`
--
ALTER TABLE `glo_tipomanufact`
  MODIFY `idTipomanufact` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_tipomoneda`
--
ALTER TABLE `glo_tipomoneda`
  MODIFY `idTipomoneda` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_unidadmed_manufact`
--
ALTER TABLE `glo_unidadmed_manufact`
  MODIFY `idUnidadManufact` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_unidadmed_producto`
--
ALTER TABLE `glo_unidadmed_producto`
  MODIFY `idUnidMedProducto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_unidad_medida`
--
ALTER TABLE `glo_unidad_medida`
  MODIFY `idUnidadMedida` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_usuario`
--
ALTER TABLE `glo_usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `glo_usuarioalmacen`
--
ALTER TABLE `glo_usuarioalmacen`
  MODIFY `idUsuarioAlamacen` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sys_accesos`
--
ALTER TABLE `sys_accesos`
  MODIFY `idAccesos` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sys_accesos_perfiles`
--
ALTER TABLE `sys_accesos_perfiles`
  MODIFY `idAccesosPerfiles` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sys_grupo`
--
ALTER TABLE `sys_grupo`
  MODIFY `idGrupo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sys_menu`
--
ALTER TABLE `sys_menu`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sys_perfiles`
--
ALTER TABLE `sys_perfiles`
  MODIFY `idPerfil` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sys_privilegios`
--
ALTER TABLE `sys_privilegios`
  MODIFY `idPrivilegios` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_clientes`
--
ALTER TABLE `vent_clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_cotordenventa`
--
ALTER TABLE `vent_cotordenventa`
  MODIFY `idCotordenventa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_despachos`
--
ALTER TABLE `vent_despachos`
  MODIFY `idDespachos` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_detalle_cotordenventa`
--
ALTER TABLE `vent_detalle_cotordenventa`
  MODIFY `idDetallecotordenventa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_detalle_guiaremision`
--
ALTER TABLE `vent_detalle_guiaremision`
  MODIFY `idDetalleguiaremision` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_guiaremision`
--
ALTER TABLE `vent_guiaremision`
  MODIFY `idGuiaremision` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_salidadiv_detalles`
--
ALTER TABLE `vent_salidadiv_detalles`
  MODIFY `idDetalleSalDiv` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_salida_diversa`
--
ALTER TABLE `vent_salida_diversa`
  MODIFY `idSalidaDiversa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_tipo_cliente`
--
ALTER TABLE `vent_tipo_cliente`
  MODIFY `idTipoCliente` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_ventas`
--
ALTER TABLE `vent_ventas`
  MODIFY `id_mov_vnt` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_ventas_detalles`
--
ALTER TABLE `vent_ventas_detalles`
  MODIFY `idVentaDetalle` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_venta_servicio`
--
ALTER TABLE `vent_venta_servicio`
  MODIFY `idVentaServicio` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_venta_servicio_detalle`
--
ALTER TABLE `vent_venta_servicio_detalle`
  MODIFY `idVentaServicioDetalle` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `vent_voucher`
--
ALTER TABLE `vent_voucher`
  MODIFY `idVoucher` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comp_compras`
--
ALTER TABLE `comp_compras`
  ADD CONSTRAINT `comp_voucher_comp_compras_fk` FOREIGN KEY (`idVoucher`) REFERENCES `comp_voucher` (`idVoucher`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_tipomoneda_comp_compras_fk` FOREIGN KEY (`idTipomoneda`) REFERENCES `glo_tipomoneda` (`idTipomoneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_usuario_comp_compras_fk` FOREIGN KEY (`idUsuario`) REFERENCES `glo_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `proveedores_compras_fk` FOREIGN KEY (`idProveedor`) REFERENCES `comp_proveedores` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipodocumento_compras_fk` FOREIGN KEY (`idComprobante`) REFERENCES `glo_comprobante` (`idComprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comp_compra_detalles`
--
ALTER TABLE `comp_compra_detalles`
  ADD CONSTRAINT `almacen_producto_compra_detalles_fk` FOREIGN KEY (`idAlmacenProducto`) REFERENCES `glo_almacen_producto` (`idAlmacenProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `compras_compra_detalles_fk` FOREIGN KEY (`id_mov_compra`) REFERENCES `comp_compras` (`id_mov_compra`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comp_despachos`
--
ALTER TABLE `comp_despachos`
  ADD CONSTRAINT `comp_proveedores_comp_despachos_fk` FOREIGN KEY (`idProveedor`) REFERENCES `comp_proveedores` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comp_proveedores`
--
ALTER TABLE `comp_proveedores`
  ADD CONSTRAINT `glo_codigopostal_comp_proveedores_fk` FOREIGN KEY (`idCodigoPostal`) REFERENCES `glo_codigopostal` (`idCodigoPostal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `personas_proveedores_fk` FOREIGN KEY (`idPersona`) REFERENCES `glo_personas` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipo_proveedor_proveedores_fk` FOREIGN KEY (`idTipoProveedor`) REFERENCES `comp_tipo_proveedor` (`idTipoProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `comp_voucher`
--
ALTER TABLE `comp_voucher`
  ADD CONSTRAINT `glo_apertura_periodo_comp_voucher_fk` FOREIGN KEY (`idAperturaPeriodo`) REFERENCES `glo_apertura_periodo` (`idAperturaPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cont_cuenta`
--
ALTER TABLE `cont_cuenta`
  ADD CONSTRAINT `cont_elemento_cont_cuenta_fk` FOREIGN KEY (`idElemento`) REFERENCES `cont_elemento` (`idElemento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cont_division`
--
ALTER TABLE `cont_division`
  ADD CONSTRAINT `cont_sub_cuenta_cont_division_fk` FOREIGN KEY (`idSubCuenta`) REFERENCES `cont_sub_cuenta` (`idSubCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cont_subdiv_cuenta`
--
ALTER TABLE `cont_subdiv_cuenta`
  ADD CONSTRAINT `cont_division_cont_subdiv_cuenta_fk` FOREIGN KEY (`idDivision`) REFERENCES `cont_division` (`idDivision`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cont_sub_cuenta`
--
ALTER TABLE `cont_sub_cuenta`
  ADD CONSTRAINT `cont_cuenta_cont_sub_cuenta_fk` FOREIGN KEY (`idCuenta`) REFERENCES `cont_cuenta` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_almacen`
--
ALTER TABLE `glo_almacen`
  ADD CONSTRAINT `glo_sucursal_almacen_fk` FOREIGN KEY (`idSucursal`) REFERENCES `glo_sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_almacen_producto`
--
ALTER TABLE `glo_almacen_producto`
  ADD CONSTRAINT `almacen_almacen_producto_fk` FOREIGN KEY (`idAlmacen`) REFERENCES `glo_almacen` (`idAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `productos_almacen_producto_fk` FOREIGN KEY (`idProducto`) REFERENCES `glo_productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_apertura_periodo`
--
ALTER TABLE `glo_apertura_periodo`
  ADD CONSTRAINT `almacen_glo_apertura_periodo_fk` FOREIGN KEY (`idAlmacen`) REFERENCES `glo_almacen` (`idAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_configuracion_glo_apertura_periodo_fk` FOREIGN KEY (`idConfiguracion`) REFERENCES `glo_configuracion` (`idConfiguracion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_periodo_glo_apertura_periodo_fk` FOREIGN KEY (`idPeriodo`) REFERENCES `glo_periodo` (`idPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_empresa`
--
ALTER TABLE `glo_empresa`
  ADD CONSTRAINT `glo_companhia_glo_empresa_fk` FOREIGN KEY (`idCompanhia`) REFERENCES `glo_companhia` (`idCompanhia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_manufactura`
--
ALTER TABLE `glo_manufactura`
  ADD CONSTRAINT `categoria_categor_menus_fk` FOREIGN KEY (`idCategoriamanufactura`) REFERENCES `glo_categoriamanufact` (`idCategoriamanufactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `menus_categor_menus_fk` FOREIGN KEY (`idTipomanufact`) REFERENCES `glo_tipomanufact` (`idTipomanufact`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_manufactura_almacen`
--
ALTER TABLE `glo_manufactura_almacen`
  ADD CONSTRAINT `almacen_menus_almacen_fk` FOREIGN KEY (`idAlmacen`) REFERENCES `glo_almacen` (`idAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `categor_menus_menus_almacen_fk` FOREIGN KEY (`idManufactura`) REFERENCES `glo_manufactura` (`idManufactura`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_productos`
--
ALTER TABLE `glo_productos`
  ADD CONSTRAINT `categoria_productos_fk` FOREIGN KEY (`idCategoria`) REFERENCES `glo_categoria_producto` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_sucursal`
--
ALTER TABLE `glo_sucursal`
  ADD CONSTRAINT `glo_empresa_glo_sucursal_fk` FOREIGN KEY (`idEmpresa`) REFERENCES `glo_empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_unidadmed_manufact`
--
ALTER TABLE `glo_unidadmed_manufact`
  ADD CONSTRAINT `manufactura_unidadmed_manufact_fk` FOREIGN KEY (`idManufactura`) REFERENCES `glo_manufactura` (`idManufactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `unidad_medida_unidadmed_manufact_fk` FOREIGN KEY (`idUnidadMedida`) REFERENCES `glo_unidad_medida` (`idUnidadMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_unidadmed_producto`
--
ALTER TABLE `glo_unidadmed_producto`
  ADD CONSTRAINT `productos_unidadmed_producto_fk` FOREIGN KEY (`idProducto`) REFERENCES `glo_productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `unidad_medida_unidadmed_producto_fk` FOREIGN KEY (`idUnidadMedida`) REFERENCES `glo_unidad_medida` (`idUnidadMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_usuario`
--
ALTER TABLE `glo_usuario`
  ADD CONSTRAINT `area_trabajador_trabajador_fk` FOREIGN KEY (`idAreaUsuario`) REFERENCES `glo_area_usuario` (`idAreaUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_cargo_glo_usuario_fk` FOREIGN KEY (`idCargo`) REFERENCES `glo_cargo` (`idCargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `personas_trabajador_fk` FOREIGN KEY (`idPersona`) REFERENCES `glo_personas` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `sys_perfiles_glo_usuario_fk` FOREIGN KEY (`idPerfil`) REFERENCES `sys_perfiles` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `glo_usuarioalmacen`
--
ALTER TABLE `glo_usuarioalmacen`
  ADD CONSTRAINT `glo_almacen_glo_usuarioalmacen_fk` FOREIGN KEY (`idAlmacen`) REFERENCES `glo_almacen` (`idAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_usuario_glo_usuarioalmacen_fk` FOREIGN KEY (`idUsuario`) REFERENCES `glo_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sys_accesos`
--
ALTER TABLE `sys_accesos`
  ADD CONSTRAINT `sys_menu_sys_accesos_fk` FOREIGN KEY (`idMenu`) REFERENCES `sys_menu` (`idMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sys_accesos_perfiles`
--
ALTER TABLE `sys_accesos_perfiles`
  ADD CONSTRAINT `sys_accesos_sys_accesos_perfiles_fk` FOREIGN KEY (`idAccesos`) REFERENCES `sys_accesos` (`idAccesos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `sys_perfiles_sys_accesos_perfiles_fk` FOREIGN KEY (`idPerfil`) REFERENCES `sys_perfiles` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sys_menu`
--
ALTER TABLE `sys_menu`
  ADD CONSTRAINT `sys_grupo_sys_menu_fk` FOREIGN KEY (`idGrupo`) REFERENCES `sys_grupo` (`idGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sys_privilegios`
--
ALTER TABLE `sys_privilegios`
  ADD CONSTRAINT `glo_usuario_sys_privilegios_fk` FOREIGN KEY (`idUsuario`) REFERENCES `glo_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `sys_accesos_sys_privilegios_fk` FOREIGN KEY (`idAccesos`) REFERENCES `sys_accesos` (`idAccesos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_clientes`
--
ALTER TABLE `vent_clientes`
  ADD CONSTRAINT `glo_codigopostal_vent_clientes_fk` FOREIGN KEY (`idCodigoPostal`) REFERENCES `glo_codigopostal` (`idCodigoPostal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipo_cliente_clientes_fk` FOREIGN KEY (`idTipoCliente`) REFERENCES `vent_tipo_cliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipodocidentidad_clientes_fk` FOREIGN KEY (`idTipodocidentidad`) REFERENCES `glo_tipodocidentidad` (`idTipodocidentidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_despachos`
--
ALTER TABLE `vent_despachos`
  ADD CONSTRAINT `vent_clientes_vent_despachos_fk` FOREIGN KEY (`idCliente`) REFERENCES `vent_clientes` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_detalle_cotordenventa`
--
ALTER TABLE `vent_detalle_cotordenventa`
  ADD CONSTRAINT `cotordenventa_detalle_cotordenventa_fk` FOREIGN KEY (`idCotordenventa`) REFERENCES `vent_cotordenventa` (`idCotordenventa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_detalle_guiaremision`
--
ALTER TABLE `vent_detalle_guiaremision`
  ADD CONSTRAINT `guiaremision_detalle_guiaremision_fk` FOREIGN KEY (`idGuiaremision`) REFERENCES `vent_guiaremision` (`idGuiaremision`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_salidadiv_detalles`
--
ALTER TABLE `vent_salidadiv_detalles`
  ADD CONSTRAINT `almacen_producto_salidadiv_detalles_fk` FOREIGN KEY (`idAlmacenProducto`) REFERENCES `glo_almacen_producto` (`idAlmacenProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `salida_diversa_salidadiv_detalles_fk` FOREIGN KEY (`idSalidaDiversa`) REFERENCES `vent_salida_diversa` (`idSalidaDiversa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_salida_diversa`
--
ALTER TABLE `vent_salida_diversa`
  ADD CONSTRAINT `glo_usuario_vent_salida_diversa_fk` FOREIGN KEY (`idUsuario`) REFERENCES `glo_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_ventas`
--
ALTER TABLE `vent_ventas`
  ADD CONSTRAINT `glo_comprobante_vent_ventas_fk` FOREIGN KEY (`idComprobante`) REFERENCES `glo_comprobante` (`idComprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_usuario_vent_ventas_fk` FOREIGN KEY (`idUsuario`) REFERENCES `glo_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipomoneda_ventas_fk` FOREIGN KEY (`idTipomoneda`) REFERENCES `glo_tipomoneda` (`idTipomoneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vent_clientes_vent_ventas_fk` FOREIGN KEY (`idCliente`) REFERENCES `vent_clientes` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vent_voucher_ventas_fk` FOREIGN KEY (`idVoucher`) REFERENCES `vent_voucher` (`idVoucher`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_ventas_detalles`
--
ALTER TABLE `vent_ventas_detalles`
  ADD CONSTRAINT `almacen_producto_venta_detalles_fk` FOREIGN KEY (`idAlmacenProducto`) REFERENCES `glo_almacen_producto` (`idAlmacenProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vent_ventas_vent_ventas_detalles_fk` FOREIGN KEY (`id_mov_vnt`) REFERENCES `vent_ventas` (`id_mov_vnt`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_venta_servicio`
--
ALTER TABLE `vent_venta_servicio`
  ADD CONSTRAINT `glo_tipomoneda_vent_venta_servicio_fk` FOREIGN KEY (`idTipomoneda`) REFERENCES `glo_tipomoneda` (`idTipomoneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `glo_usuario_vent_venta_servicio_fk` FOREIGN KEY (`idUsuario`) REFERENCES `glo_usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tipodocumento_venta_servicio_fk` FOREIGN KEY (`idComprobante`) REFERENCES `glo_comprobante` (`idComprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vent_clientes_vent_venta_servicio_fk` FOREIGN KEY (`idCliente`) REFERENCES `vent_clientes` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vent_voucher_vent_venta_servicio_fk` FOREIGN KEY (`idVoucher`) REFERENCES `vent_voucher` (`idVoucher`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_venta_servicio_detalle`
--
ALTER TABLE `vent_venta_servicio_detalle`
  ADD CONSTRAINT `menus_almacen_venta_servicio_detalle_fk` FOREIGN KEY (`idManufactAlmacen`) REFERENCES `glo_manufactura_almacen` (`idManufactAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `venta_servicio_venta_servicio_detalle_fk` FOREIGN KEY (`idVentaServicio`) REFERENCES `vent_venta_servicio` (`idVentaServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vent_voucher`
--
ALTER TABLE `vent_voucher`
  ADD CONSTRAINT `glo_apertura_periodo_vent_voucher_fk` FOREIGN KEY (`idAperturaPeriodo`) REFERENCES `glo_apertura_periodo` (`idAperturaPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
