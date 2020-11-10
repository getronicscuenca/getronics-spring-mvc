package es.getronics.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import es.getronics.bom.Empleado;


public class DepartamentoDto {

	private Long id;
	private String nombre;
	@NotBlank(message="La descripcion no puede estar vacia")
	private String desc;
	private Date alta;
	private Long jefe;
	
	
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
	public Long getJefe() {
		return jefe;
	}
	public void setJefe(Long jefe) {
		this.jefe = jefe;
	}
	
	
	
}
