<%@ include file="../common/taglibs.jsp"%>
<h3>
	<spring:message code="technology.update.title"></spring:message>
</h3>
<spring:url value="/tecnologia/new" var="url"></spring:url>

<form:form modelAttribute="tecnologia" action="${url}">

	<form:hidden path="id" />
	<spring:message code="technology.name"></spring:message>
	<form:input path="nombre"/>
	<br />
	<spring:message code="technology.description"></spring:message>
	<form:input path="descripcion"/>
	<br />
	<form:button value="submit">
		<spring:message code="technology.update"></spring:message>
	</form:button>
</form:form>