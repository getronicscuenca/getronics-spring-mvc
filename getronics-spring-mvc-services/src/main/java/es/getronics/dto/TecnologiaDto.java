package es.getronics.dto;

import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;

public class TecnologiaDto {

	private Long id;
	@NotEmpty (message="Debe poner un nombre")
	@Length(min = 3, max = 15, message="Longitud de nombre incorrecta" )
	private String nombre;
	@NotEmpty(message="La descripcion no puede estar vacia")
	private String desc;
			
	private Set<Departamento> departamentos;

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

	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
