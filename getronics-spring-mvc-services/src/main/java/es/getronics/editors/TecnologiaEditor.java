package es.getronics.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.services.TecnologiaService;

@Component
public class TecnologiaEditor extends PropertyEditorSupport{
	
	@Autowired 
	TecnologiaService tecnologiaService;
	
	public void setAsText(String id)
	{
		this.setValue(tecnologiaService.findById(Long.parseLong(id)));
	}
	

}
