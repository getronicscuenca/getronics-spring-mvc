package es.getronics.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class DateMaker extends PropertyEditorSupport {
	
	@SuppressWarnings("deprecation")
	public Date createDate(String dia, String mes, String ano)
	{
		int d= Integer.parseInt(dia);
		int m= Integer.parseInt(mes);
		int y= Integer.parseInt(ano);
		System.out.println("HOLAAAAAAAAAAAA\\n\\n\\n\\n\\n\\n++++++++++++++++++++++++++++++++++++++");
		Date date= new Date(d,m,y);
		System.out.println(date+"\n\n\n\n\n\n++++++++++++++++++++++++++++++++++++++");
		
		return date;
		
	}
	
	public String createString(Date d)
	{
		String s=d.getDay()+"-"+d.getMonth()+"-"+d.getYear();
		return s;
	}

}
