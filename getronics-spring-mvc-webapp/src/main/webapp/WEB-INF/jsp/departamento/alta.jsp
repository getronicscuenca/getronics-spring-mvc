<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<spring:url value="/departamento/chAlta/${departamento.id}" var="url"></spring:url>
<form:form  action="${ url }" modelAttribute="departamento">
	
	
	dia:<form:input path="dia"/><br>
	mes:<form:input path="mes"/><br>
	año:<form:input path="ano"/><br>
	<form:button value="submit">Guardar</form:button>
</form:form>