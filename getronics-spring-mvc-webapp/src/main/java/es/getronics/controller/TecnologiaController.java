/**
 * 
 */
package es.getronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.TecnologiaDto;
import es.getronics.services.DepartamentoService;
import es.getronics.services.TecnologiaService;

/**
 * Maneja las peticiones relacionadas con empleados
 * 
 * @author jgarcia
 *
 */
@RequestMapping("tecnologia")
@Controller
public class TecnologiaController {
	
	private final String LIST_VIEW = "tecnologia.list";
	private final String TECNOLOGIA_VIEW = "tecnologia.tecnologia";

	@Autowired
	private TecnologiaService tecnologiaService;
	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarEmpleados(Model model) {
		List<TecnologiaDto> tecnologias = tecnologiaService.findAll();
		model.addAttribute("tecnologias", tecnologias);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("tecnologia", new TecnologiaDto());
		model.addAttribute("departamentos", departamentoService.findAll());
		return new ModelAndView(TECNOLOGIA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateEmpleado(@PathVariable Long id, Model model) {
		TecnologiaDto tecnologia = tecnologiaService.findById(id);
		model.addAttribute("tecnologia", tecnologia);
		model.addAttribute("departamentos", departamentoService.findAll());
		
		return new ModelAndView(TECNOLOGIA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarEmpleado(@ModelAttribute TecnologiaDto tecnologia, Model model) {
		if(tecnologia.getId() != null) {
			tecnologiaService.update(tecnologia);
		} else {
			tecnologiaService.insert(tecnologia);
		}
		return "redirect:/tecnologia";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarEmpleado(@PathVariable Long id, Model model) {
		tecnologiaService.remove(id);
		return "redirect:/tecnologia";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
	}
}
