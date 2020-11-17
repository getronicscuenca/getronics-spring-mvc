package es.getronics.dto;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;


public class DepartamentoDto {

	private Long id;
	@NotBlank
	private String nombre;
	@NotBlank(message="La descripcion no puede estar vacia")
	private String descripcion;
	private Date alta;
	private List<Long> selectedTecnologias;
	private List<String> tecnologias;
	
	
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
	public List<Long> getSelectedTecnologias() {
		return selectedTecnologias;
	}
	public void setSelectedTecnologias(List<Long> selectedTecnologias) {
		this.selectedTecnologias = selectedTecnologias;
	}
	public List<String> getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(List<String> tecnologias) {
		this.tecnologias = tecnologias;
	}
	
}

