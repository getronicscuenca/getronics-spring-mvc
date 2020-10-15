--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL
);

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `DESCRIPCION` varchar(250) NOT NULL,
  `ALTA` date
  
);

--
-- apendices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);
COMMIT;

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`ID`);
COMMIT;