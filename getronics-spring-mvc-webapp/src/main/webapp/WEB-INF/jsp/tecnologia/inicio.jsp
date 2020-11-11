<%@ include file="../common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>	
			<th>Id Tecnología</th>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Opciones</th>
		</thead>
		<tbody>
			<c:forEach items="${ tecnologias }" var="tecnologia">
				<tr>
					<td>${tecnologia.id}</td>
					<td>${tecnologia.nombre}</td>
					<td>${tecnologia.descripcion }</td>
					<td><a href="tecnologia/eliminar/${tecnologia.id }" class="btn btn-danger">Eliminar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="./tecnologia" method="post">
		<button class="btn btn-primary" type="submit">Nueva</button>
	</form:form>
</body>
</html>