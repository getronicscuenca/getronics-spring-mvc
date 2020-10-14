--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL
);

CREATE TABLE `departamento` (
  `ID` int(11) NOT NULL,
  `NOMBRE_DEPARTAMENTO` varchar(250) NOT NULL,
  `DESCRIPCION` varchar(250),
  `FECHA` DATE DEFAULT SYSDATE
);


ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);
COMMIT;


ALTER TABLE `departamento`
  ADD PRIMARY KEY (`ID`);
COMMIT;

