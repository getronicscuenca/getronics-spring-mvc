package es.getronics.dto;

/**
 * Objeto de transferenca empleado
 * 
 * @author jgarcia
 *
 */
public class EmpleadoDto {

	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Long idDepartamento;
	private String departamento;
	private Long jefe;
	
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
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Long getJefe() {
		return jefe;
	}
	public void setJefe(Long jefe) {
		this.jefe = jefe;
	}
	
	
}
