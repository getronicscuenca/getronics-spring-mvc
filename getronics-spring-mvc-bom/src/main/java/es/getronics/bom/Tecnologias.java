package es.getronics.bom;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TECNOLOGIAS")
public class Tecnologias {
	private static final long serialVersionUID = -9054047698877645200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Length(min=1,max=50) @NotBlank
	@Column(name = "NOMBRE")
	private String nombre;

	@Length(max=100) @NotBlank
	@Column(name = "DESCRIPCION")
	private String descripcion;

	@ManyToMany
	@JoinTable(name = "tecnologias_departamentos", joinColumns = @JoinColumn(name = "tecnologiasId"), inverseJoinColumns = @JoinColumn(name = "departamentoId"))
	private List<Departamento> departamentos;
	
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

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departamentos == null) ? 0 : departamentos.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tecnologias other = (Tecnologias) obj;
		if (departamentos == null) {
			if (other.departamentos != null)
				return false;
		} else if (!departamentos.equals(other.departamentos))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
