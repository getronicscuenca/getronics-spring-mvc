package es.getronics.dto;

import java.time.LocalDate;

public class DepartamentoDto {
	private Long id;
	private String nombre;
	private LocalDate fecha;
	
	
	

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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
