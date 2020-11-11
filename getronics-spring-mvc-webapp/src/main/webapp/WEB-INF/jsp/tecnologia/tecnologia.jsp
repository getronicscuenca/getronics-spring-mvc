<%@ include file="../common/taglibs.jsp"%>

<div class="row justify-content-center mt-5">
	<form:form modelAttribute="tecnologia" action="tecnologia/guardar">
		<form:hidden path="id"/>
		<label for="nombre">Nombre: </label>
		<form:input path="nombre" id="nombre"/>
		<label for="descripcion">Nombre: </label>
		<form:input path="descripcion" id="descripcion"/>
		<form:select path="idDepartamento">
				<form:options items="${departamentos}" itemLabel="nombre" itemValue="id" />
		</form:select>
		<button type="submit">Guardar</button>
	</form:form>
</div>