/**
 * @file Categoria.java
 * @date 11 nov. 2020
 * @time 12:20:17
 * 
 */
package es.getronics.bom;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
/**
 * @author alatorre
 *
 * 
 */
@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

	
	private static final long serialVersionUID = -4871614700766414269L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@OneToMany(mappedBy = "categoria")
	private Set<Empleado> empleados;
	@Column(name="SUELDO")
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
	public Set<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
}
