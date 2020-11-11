package es.getronics.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import es.getronics.bom.Empleado;
import es.getronics.exceptions.DepartamentoExistenteException;
import es.getronics.services.DepartamentoService;

public class DepartamentoDto {

	
	
	private Long id;
	private String nombre;
	private String desc;
	private Date alta;
	private Long idEmpleado;
	private String nombreEmpleado;
	private Set<Empleado> empleadoLista;

	public Set<Empleado> getEmpleadoLista() {
		return empleadoLista;
	}

	public void setEmpleadoLista(Set<Empleado> empleadoLista) {
		this.empleadoLista = empleadoLista;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
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
