package es.getronics.bom;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {

	private static final long serialVersionUID = -9054047698877645200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "ALTA")
	private Date alta;
	
	@OneToMany(mappedBy = "departamento")
	private Set<Empleado> empleados;
	
	@OneToOne(mappedBy ="jefeDepartamento")
	@JoinColumn(name="empleado_id")
	private Empleado jefe;
	@JoinTable(
			name="TECNOLOGIA_DEPARTAMENTO",
			joinColumns=@JoinColumn(name = "FK_DEPARTAMENTO"),
			inverseJoinColumns= @JoinColumn(name="FK_TECNOLOGIA")
	)
	@ManyToMany
	Set<Tecnologia> tecnologias;

	
	

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

	public String getDesc() {
		return descripcion;
	}

	public void setDesc(String desc) {
		this.descripcion = desc;
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
