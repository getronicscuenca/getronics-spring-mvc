<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<spring:url value="/tecnologia/new" var="url"></spring:url>

<c:choose >
	<c:when test="${ tecnologia.id == null}">
		<c:set value="Insertar nueva tecnologia" var="title" />
	</c:when>
	<c:otherwise>
		<c:set  value="Actualizar tecnologia existente" var="title" />
	</c:otherwise>
</c:choose>

<div class="row justify-content-center mt-5">
	<div class="col-md-8">
		<div class="card card-sm">
			<form:form modelAttribute="tecnologia" action="${ url }">
				<fieldset>
					<legend class="text-center header">${ title }</legend>
					<form:hidden path="id"/>
					<div class="row justify-content-center">	
						<div class="form-group col-md-11">
						<c:if test="${errores != null}">
								<p>${errores}</p>
								</c:if>
							<label for="nombre"><spring:message code="tecnologia.nombre"></spring:message></label>
							<form:input path="nombre" cssClass="form-control"/>
						</div>
						
						<div class="form-group col-md-11">
							<label for="descripcion"><spring:message code="tecnologia.descripcion"></spring:message></label>
							<form:input path="descripcion" cssClass="form-control"/>
						</div>
						<div class="form-group col-md-11">
							<form:button value="submit" class="btn btn-info"><spring:message code="common.button.send"></spring:message></form:button>
						</div>
					</div>	
				</fieldset>
			</form:form>
		</div>
	</div>
</div>