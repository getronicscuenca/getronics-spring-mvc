package es.getronics.dto;

import java.util.Date;


public class DepartamentoDto {

	private Long id;
	private String nombre;
	private String desc;
	private Date alta;
	private int dia,mes,ano;
	
	

	
	
	
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date fecha) {
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

//	public void fechaAlta()
//	{
//		java.util.Date date= new java.util.Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		this.alta=dateFormat.format(date);
//	}
}
