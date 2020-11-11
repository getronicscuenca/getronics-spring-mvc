/**
 * @file CategoriaDto.java
 * @date 11 nov. 2020
 * @time 12:57:29
 * 
 */
package es.getronics.dto;

import java.util.List;

/**
 * @author alatorre
 *
 * 
 */
public class CategoriaDto {

	private Long id;
	private String nombre;
	private List<EmpleadoDto> empleados;
	private int sueldo;
	
	
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
	public List<EmpleadoDto> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EmpleadoDto> empleados) {
		this.empleados = empleados;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
