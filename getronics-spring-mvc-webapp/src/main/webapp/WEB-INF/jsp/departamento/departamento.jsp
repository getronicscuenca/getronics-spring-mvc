<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<spring:url value="/departamento/new" var="url"></spring:url>
<spring:message code="departamento.new.title" var="insertTitle"/>
<spring:message code="departamento.update.title" var="updateTitle"/> 


<style>
      .error {
         color: #ff0000;
      }

      .errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }
   </style>

<c:choose>
	<c:when test="${departamento.id == null}">
		<c:set value="${ insertTitle }" var="title"/>
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title"/>
	</c:otherwise>
</c:choose>

<form:errors path="*" cssClass="errorblock" element="div" />

<form:form modelAttribute="departamento" action="${ url }">
	<h1>${ title }</h1>
	
	<form:errors path="*" cssClass="errorblock" element="div" />
	
	<form:hidden path="id"/>
	<spring:message code="departamento.nombre"></spring:message>
	<form:errors path="nombre" cssClass="error" /><br>
	<form:input path="nombre"/><br>
	<spring:message code="departamento.desc"></spring:message>
	<form:errors path="desc" cssClass="error" /><br>
	<form:input path="desc"/><br>
	<form:button value="submit">Guardar</form:button>
</form:form>