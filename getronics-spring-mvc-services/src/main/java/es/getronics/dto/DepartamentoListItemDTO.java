package es.getronics.dto;

import java.util.Set;

public class DepartamentoListItemDTO {

	private String nombre;
	private String desc;
	private String jefe;
	private Long idJefe;
		
	private Set<EmpleadoDto> empleados;
	
	private Set<TecnologiaDto> tecnologias;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	public Long getIdJefe() {
		return idJefe;
	}

	public void setIdJefe(Long idJefe) {
		this.idJefe = idJefe;
	}

	public String getJefe() {
		return jefe;
	}

	public void setJefe(String jefe) {
		this.jefe = jefe;
	}

	public Set<EmpleadoDto> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<EmpleadoDto> empleados) {
		this.empleados = empleados;
	}

	public Set<TecnologiaDto> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(Set<TecnologiaDto> tecnologias) {
		this.tecnologias = tecnologias;
	}
	
	
}
