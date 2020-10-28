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
	private List<String> tecnologia;
	
	
	
	
	
	
	
	public List<String> getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(List<String> tecnologias) {
		this.tecnologia = tecnologias;
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
