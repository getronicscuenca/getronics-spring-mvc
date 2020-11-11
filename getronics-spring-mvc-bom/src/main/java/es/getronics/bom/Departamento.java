package es.getronics.bom;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {

	private static final long serialVersionUID = -9054047698877645200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "NOMBRE")
	@NotBlank
	private String nombre;
	@Column(name = "DESCRIPCION")
	@NotBlank
	private String desc;
	
	//@Column(name = "ALTA")
	//private Date alta;
	
	//@Column(name="ID_JEFE") <<<<<FALTA>>>>
	//@OneToOne(mappedBy="id")
	private Empleado jefe;
	
	@OneToMany(mappedBy = "departamento")
	private Set<Empleado> empleados;
	
	@ManyToMany(cascade = CascadeType.ALL)
    private Set<Tecnologia> tecnologias;

	public Empleado getJefe() {
		return jefe;
	}

	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}

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

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	public Set<Tecnologia> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(Set<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Departamento other = (Departamento) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
