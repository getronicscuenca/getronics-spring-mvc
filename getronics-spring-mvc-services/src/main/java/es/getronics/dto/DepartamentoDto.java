package es.getronics.dto;

import java.util.Date;
import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;


public class DepartamentoDto {

	private Long id;
	@NotEmpty (message="Debe poner un nombre")
	@Length(min = 3, max = 15, message="Longitud de nombre incorrecta" )
	private String nombre;
	@NotEmpty(message="La descripcion no puede estar vacia")
	private String desc;
	//private Date alta;
	//private Long jefe;
	private Long idJefe;
	private String jefe;
		
	private Set<Empleado> empleados;
	
	private Set<Tecnologia> tecnologias;
		
	public Set<Tecnologia> getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(Set<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}
	public Set<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
		
		
}
