package es.getronics.bom;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="TECNOLOGIA")
public class Tecnologia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6626304814785914864L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@ManyToMany(mappedBy ="tecnologias")
	Set<Departamento> departamentos;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
