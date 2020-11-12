package es.getronics.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import es.getronics.bom.Empleado;


public class DepartamentoDto {

	private Long id;
	private String nombre;
	@NotBlank(message="La descripcion no puede estar vacia")
	private String descripcion;
	private Date alta;
	
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}	
}
