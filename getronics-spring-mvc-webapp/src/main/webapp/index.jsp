<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/empleado" var="url"></spring:url>
<spring:url value="/departamento" var="url2"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java getronics</h2>

<a href="${ url }">Mostrar empleados</a><br>
<a href="${ url2 }">Mostrar departamentos</a>
</body>
</html>
