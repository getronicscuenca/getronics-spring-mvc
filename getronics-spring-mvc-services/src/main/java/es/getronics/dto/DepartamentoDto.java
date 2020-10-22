package es.getronics.dto;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;






public class DepartamentoDto {

	private Long id;
	private String nombre;
	@NotBlank(message="La descripcion no puede estar vacia")
	private String desc;
	private Date alta;
	private List<EmpleadoDto> empleados;


	
	
	
	public List<EmpleadoDto> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoDto> empleados) {
		this.empleados = empleados;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date fecha) {
		this.alta = fecha;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
