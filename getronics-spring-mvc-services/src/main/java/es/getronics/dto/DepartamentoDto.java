package es.getronics.dto;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;







public class DepartamentoDto {

	private Long id;
	private String nombre;
	@NotBlank(message="La descripcion no puede estar vacia")
	private String desc;
	private Date alta;
	private List<EmpleadoDto> empleados;
	private EmpleadoDto jefe;
	private String encargado;
	private List<TecnologiaDto> tecnologias;
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentoDto other = (DepartamentoDto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	public List<TecnologiaDto> getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(List<TecnologiaDto> tecnologias) {
		this.tecnologias = tecnologias;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public List<EmpleadoDto> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EmpleadoDto> empleados) {
		this.empleados = empleados;
	}
	public EmpleadoDto getJefe() {
		return jefe;
	}
	public void setJefe(EmpleadoDto jefe) {
		this.jefe = jefe;
	}




}
