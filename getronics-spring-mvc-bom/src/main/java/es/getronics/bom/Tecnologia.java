package es.getronics.bom;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="TECNOLOGIA")
public class Tecnologia implements Serializable{
	

	private static final long serialVersionUID = -6626304814785914864L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="NOMBRE")
	@NotBlank
	private String nombre;
	@Column(name="DESCRIPCION")
	@NotBlank
	private String descripcion;
	@ManyToMany(mappedBy ="tecnologias")
	Set<Departamento> departamentos;
	
//	getters and setters
	
	public long getId() {
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
	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}
