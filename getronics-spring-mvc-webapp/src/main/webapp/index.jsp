<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/empleado" var="url"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java getronics</h2>

<b>Mostrar empleados</b>
<br/>
<a href="${ url }">Mostrar empleados</a>
<br/>
<b>Mostrar departamentos</b>
<a href="departamento">Mostrar departamentos</a>
<br/>
</body>
</html>
