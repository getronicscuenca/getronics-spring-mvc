package es.getronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.TecnologiaDto;
import es.getronics.services.TecnologiaService;

@RequestMapping("tecnologia")
@Controller
public class TecnologiaController {

	private  final String TECNOLOGIA_VIEW = "tecnologia/tecnologia";
	@Autowired
	private TecnologiaService tecnologiaService;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarTecnologias(Model model)
	{
		List<TecnologiaDto> tecnologias = tecnologiaService.findAll();
		model.addAttribute("tecnologias",tecnologias);
		
		return new ModelAndView(TECNOLOGIA_VIEW, model.asMap());
	}
}
