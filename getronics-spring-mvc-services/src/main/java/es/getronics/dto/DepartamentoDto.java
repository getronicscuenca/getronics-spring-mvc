package es.getronics.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DepartamentoDto {

	private Long id;
	private String nombre;
	private String desc;
	private String alta;

	
	
	
	
	public String getAlta() {
		return alta;
	}

	public void setAlta(String fecha) {
		this.alta = fecha;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void fechaAlta()
	{
		java.util.Date date= new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.alta=dateFormat.format(date);
	}
}
