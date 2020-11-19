package es.getronics.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;



public class DepartamentoDto {

	private Long id;
	@NotEmpty (message="Debe poner un nombre")
	@Length(min = 3, max = 15, message="Longitud de nombre incorrecta" )
	private String nombre;
	@NotEmpty(message="La descripcion no puede estar vacia")
	private String descripcion;
	//private Date alta;
	//private Long jefe;
	private Long idJefe;
	private String jefe;
	
	private List<Long> selectedTecnologias;
	private List<String> tecnologias;
	private List<String> empleados;
		
	/*private Set<Empleado> empleados;
	
	private Set<Tecnologia> tecnologias;*/
		
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
	/*public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}*/
	public Long getIdJefe() {
		return idJefe;
	}
	public void setIdJefe(Long idJefe) {
		this.idJefe = idJefe;
	}
	public String getJefe() {
		return jefe;
	}
	public void setJefe(String jefe) {
		this.jefe = jefe;
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
	
		
		
}
