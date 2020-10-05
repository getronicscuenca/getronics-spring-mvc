<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/empleado" var="url"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java getronics</h2>

<a href="${ url }">Mostrar empleados</a>
</body>
</html>
