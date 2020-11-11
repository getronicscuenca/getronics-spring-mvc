package es.getronics.controller;

import java.awt.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.TecnologiasDto;
import es.getronics.services.DepartamentoService;
import es.getronics.services.TecnologiasService;

@Controller
@RequestMapping("/tecnologia")
public class TecnologiaController {
	
	private final String INICIO="tecnologia.lista";
	private final String TECNOLOGIA="tecnologia.tecnologia";
	
	@Autowired
	private TecnologiasService tecnologiasService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView inicio(Model model) {
		model.addAttribute("tecnologias",tecnologiasService.findAll());
		return new ModelAndView(INICIO, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String tecnologia(Model model) {
		model.addAttribute("tecnologia",new TecnologiasDto());
		model.addAttribute("departamentos", departamentoService.findAll());
		return TECNOLOGIA;
	}
	
	@RequestMapping(value="guardar", method=RequestMethod.POST)
	public String guardarActualizar(@ModelAttribute("tecnologia") TecnologiasDto tecnologia) {
		
		tecnologiasService.insert(tecnologia);
		return "redirect:/tecnologia";
	}
	
	@RequestMapping(value="eliminar/{id}", method=RequestMethod.GET)
	public String eliminar(@PathVariable Long id, Model model) {
		tecnologiasService.remove(id);
		return "redirect:/tecnologia";
	}
	
}
