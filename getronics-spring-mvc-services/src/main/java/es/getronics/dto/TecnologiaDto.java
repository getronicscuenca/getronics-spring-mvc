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
	
	private Long idDepartamento;
	//private String departamento;
	
	private Set<Long> idDepartamentos;
			
	private Set<DepartamentoDto> departamentos;
	
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

	
	public Set<DepartamentoDto> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Set<DepartamentoDto> departamentos) {
		this.departamentos = departamentos;
	}

	public Set<Long> getIdDepartamentos() {
		return idDepartamentos;
	}

	public void setIdDepartamentos(Set<Long> idDepartamentos) {
		this.idDepartamentos = idDepartamentos;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	

			
}
