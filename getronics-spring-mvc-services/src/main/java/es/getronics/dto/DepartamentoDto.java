package es.getronics.dto;

public class DepartamentoDto {

	private Long id;
	private String nombre;
	private String descripcion;
	private String fecha;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
		
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setFecha(String fecha) {
		this.fecha=fecha;
		
	}
	
	public String getFecha() {
		return fecha;
	}
	
}
