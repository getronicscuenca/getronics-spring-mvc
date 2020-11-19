package es.getronics.dto;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;

public class TecnologiaDto implements Serializable {
	
	private static final long serialVersionUID = -9054047698877645200L;

	private Long id;
	@NotEmpty (message="Debe poner un nombre")
	@Length(min = 3, max = 15, message="Longitud de nombre incorrecta" )
	private String nombre;
	@NotEmpty(message="La descripcion no puede estar vacia")
	private String descripcion;
	
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
	
				
}
