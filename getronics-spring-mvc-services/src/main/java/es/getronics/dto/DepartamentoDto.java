package es.getronics.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;


public class DepartamentoDto {
	private Long id;
	@NotEmpty(message="El nombre es requerido (validado con anotaciones)")
	private String nombre;
	private String descripcion;
	private Date fecha;
	
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	
	
}
