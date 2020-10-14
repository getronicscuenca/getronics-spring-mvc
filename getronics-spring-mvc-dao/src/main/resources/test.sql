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
-- dices para tablas volcadas
--
CREATE TABLE `departamentos` (
	`ID_DEPT` int(11) NOT NULL,
	`NOMBRE_DEPT` varchar(250),
	`FECHA` date
);

ALTER TABLE 'departamentos' 
ADD PRIMARY KEY (`ID_DEPT`);
--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);
COMMIT;