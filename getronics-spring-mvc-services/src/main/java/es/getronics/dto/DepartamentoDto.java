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
	private List<TecnologiaItem> tecnologiaItems;
	private List<String> empleados;
	private String jefe;
	
	
	
	
	//hashCode and equals
	
	
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
	
	
	//getters and setters
	
	
	public Long getId() {
		return id;
	}
	public List<TecnologiaItem> getTecnologiaItems() {
		return tecnologiaItems;
	}
	public void setTecnologiaItems(List<TecnologiaItem> tecnologiaItems) {
		this.tecnologiaItems = tecnologiaItems;
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
	public List<String> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<String> empleados) {
		this.empleados = empleados;
	}
	public String getJefe() {
		return jefe;
	}
	public void setJefe(String jefe) {
		this.jefe = jefe;
	}
	
	
	
	
	
	




}
