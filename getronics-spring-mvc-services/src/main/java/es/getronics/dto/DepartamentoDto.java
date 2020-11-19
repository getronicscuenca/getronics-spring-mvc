package es.getronics.dto;

import java.util.Date;
import java.util.List;

public class DepartamentoDto {

	private Long id;
	private String nombre;
	private String desc;
	private Date alta;
	private Long idEmpleado;
	private String nombreEmpleado;
	private List<Long> tecnologiaId;

	

	public List<Long> getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(List<Long> tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
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
