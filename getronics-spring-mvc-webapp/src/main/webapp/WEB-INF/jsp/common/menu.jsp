<%@ include file="../common/taglibs.jsp" %>

<spring:url value="/index" var="urlIndex"></spring:url>
<spring:url value="/empleado" var="urlEmpleado"></spring:url>
<spring:url value="/departamento" var="urlDepartamento"></spring:url>
<spring:url value="/tecnologias" var="urlTecnologias"></spring:url>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${ urlIndex }"><spring:message code="common.menu.home"></spring:message></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <spring:message code="common.menu.empleados"></spring:message>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="${ urlEmpleado }"><spring:message code="common.menu.list"></spring:message></a>
          <form:form action="${ urlEmpleado }" >
				<button type="submit" class="dropdown-item"><spring:message code="common.menu.new"></spring:message></button>
		  </form:form>
        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <spring:message code="common.menu.departamentos"></spring:message>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="${ urlDepartamento }"><spring:message code="common.menu.list"></spring:message></a>
          <form:form action="${ urlDepartamento }" >
				<button type="submit" class="dropdown-item"><spring:message code="common.menu.new"></spring:message></button>
		  </form:form>
        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <spring:message code="common.menu.tecnologias"></spring:message>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="${ urlTecnologias }"><spring:message code="common.menu.list"></spring:message></a>
          <form:form action="${ urlTecnologias }" >
				<button type="submit" class="dropdown-item"><spring:message code="common.menu.new"></spring:message></button>
		  </form:form>
        </div>
      </li>
      
    </ul>
  </div>
</nav>