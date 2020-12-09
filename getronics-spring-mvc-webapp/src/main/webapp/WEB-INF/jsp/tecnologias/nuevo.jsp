<%@ include file="../common/taglibs.jsp"%>
<h3>
	<spring:message code="technology.form"></spring:message>
</h3>
<spring:url value="/tecnologia/new" var="url"></spring:url>

<form:form modelAttribute="tecnologia" action="${url}">

	<h1>${ title }</h1>
	<form:hidden path="id" />
	<spring:message code="technology.name"></spring:message>

	<form:input path="nombre" />
	<form:errors path="nombre" style="color:red" />
	<br />
	<br />

	<spring:message code="technology.description"></spring:message>
	<form:input path="descripcion" />
	<form:errors path="descripcion" style="color:red" />
	<br />
	<form:button value="submit">
		<spring:message code="technology.save"></spring:message>
	</form:button>
</form:form>