package es.getronics.bom;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {

	private static final long serialVersionUID = -9054047698877645200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//Solo he añadido estas 2 restricciones que el nombre tenga que estar entre (1,25) y que no sea vacio
	
	//@Length(min=1,max=25) @NotBlank
	@Column(name = "NOMBRE")
	private String nombre;
	//Y aquí que la descripcion tenga un máximo de 100 caracteres y que no sea vacia
	
	//@Length(max=100) @NotBlank
	@Column(name = "DESCRIPCION")
	private String desc;
	
	@Column(name = "ALTA")
	private Date alta;
	
	@Column(name="NOMBRE_EMPLEADO")
	private String nombreEmpleado;
	
	
	@ManyToMany(mappedBy="departamentos", cascade = CascadeType.ALL)
	private Set<Tecnologias> tecnologia;
	
	private Empleado empleadoJefe;
	


	@OneToMany(mappedBy = "departamento")
	private Set<Empleado> empleados;

	
	public Empleado getEmpleadoJefe() {
		return empleadoJefe;
	}

	public void setEmpleadoJefe(Empleado empleadoJefe) {
		this.empleadoJefe = empleadoJefe;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
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

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Set<Tecnologias> getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Set<Tecnologias> tecnologia) {
		this.tecnologia = tecnologia;
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
