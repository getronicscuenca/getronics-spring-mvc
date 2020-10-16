package es.getronics.controller;

import java.beans.PropertyEditorSupport;
import java.time.Instant;
import java.util.Date;

@SuppressWarnings("deprecation")
public class DateMaker extends PropertyEditorSupport {
	
	int dia,mes,ano;
	Date value;
	
	
	
	public DateMaker(String dia, String mes, String ano) {
		super();
		System.out.println("CONSTRUCTOOOOOOOOOOOOOOOOR \n\n\n\n\n");
		this.dia = Integer.parseInt(dia);
		this.mes = Integer.parseInt(dia);
		this.ano = Integer.parseInt(dia);
		this.value =new Date(this.dia,this.mes,this.ano);
	}
	

	public DateMaker(Date value) {
		super();
		this.value = value;
		this.dia=value.getDay();
		this.mes=value.getMonth();
		this.ano=value.getYear();
	}


	@Override
	public void setValue(Object value) {
		System.out.println("setValue\n\n\n\n\n");
		// TODO Auto-generated method stub
		super.setValue(value);
	}

	@Override
	public Object getValue() {
		System.out.println("getValue\n\n\n\n\n");
		return this.getValue();
	}

	@Override
	public String getAsText() {
		System.out.println("getAsText\n\n\n\n\n");
		
		return dia+"/"+mes+"/"+ano;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("setAsText\n\n\n\n\n");
		super.setAsText(text);
	}

	

}
