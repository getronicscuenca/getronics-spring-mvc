package es.getronics.bom;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;



//esto es el remoto Pruebas de departamento

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {



	private static final long serialVersionUID = -7046998948409771669L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "ALTA")
	private Date alta;
	
	@OneToMany(mappedBy = "departamento")
	private Set<Empleado> empleados;
	
	@OneToOne
	@JoinColumn(name="jefe")
	private Empleado jefe;
	@JoinTable(
			name="TECNOLOGIA_DEPARTAMENTO",
			joinColumns=@JoinColumn(name = "FK_DEPARTAMENTO"),
			inverseJoinColumns= @JoinColumn(name="FK_TECNOLOGIA")
	)
	@ManyToMany
	private Set<Tecnologia> tecnologias;

	
	
	
	
	
	
	

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

	public Empleado getJefe() {
		return jefe;
	}

	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String desc) {
		this.descripcion = desc;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
 
	

}
