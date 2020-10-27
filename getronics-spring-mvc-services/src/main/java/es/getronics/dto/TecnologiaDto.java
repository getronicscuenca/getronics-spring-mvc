package es.getronics.dto;

import java.util.List;


public class TecnologiaDto {

	
	private Long id;
	private String nombre;
	private String Descripcion;
	private List<DepartamentoDto> departamentos;
	
	
	
	public List<DepartamentoDto> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<DepartamentoDto> departamentos) {
		this.departamentos = departamentos;
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
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	

	
}
