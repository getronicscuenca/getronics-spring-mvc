/**
 * 
 */
package es.getronics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.base.dao.exception.GetronicsDaoException;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionTecnologia;
import es.getronics.services.TecnologiaService;

/**
 * Maneja las peticiones relacionadas con tecnologias
 * 
 * @author jgarcia
 *
 */
@RequestMapping("tecnologia")
@Controller
public class TecnologiaController {
	
	private final String LIST_VIEW = "tecnologia.list";
	private final String TECNOLOGIA_VIEW = "tecnologia.tecnologia";
	
	private final String REDIRECT_TO_TECNOLOGIA = "redirect:/tecnologia";

	private final String MODEL_OBJECT = "tecnologia";
	private final String LIST_MODEL_OBJECT = "tecnologias";
	

	@Autowired
	private TecnologiaService tecnologiaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarTecnologias(Model model) {
		List<TecnologiaDto> tecnologias = tecnologiaService.findAll();
		model.addAttribute(LIST_MODEL_OBJECT, tecnologias);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		return new ModelAndView(TECNOLOGIA_VIEW);
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateTecnologia(@PathVariable Long id, Model model) {
		TecnologiaDto tecnologia = tecnologiaService.findById(id);
		model.addAttribute(MODEL_OBJECT, tecnologia);
		
		return new ModelAndView(TECNOLOGIA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarTecnologia(@ModelAttribute(MODEL_OBJECT) @Valid TecnologiaDto tecnologia, BindingResult bindingResult, Model model) {
		
		try {
			if (tecnologia.getId() != null) {
				tecnologiaService.update(tecnologia);
			} else {
				tecnologiaService.insert(tecnologia);
			}
		} catch(ExcepcionTecnologia ex) {
			bindingResult.reject(ex.getMessage());
			return "tecnologia.error"; 
		}
		return REDIRECT_TO_TECNOLOGIA;
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarTecnologia(@PathVariable Long id, Model model) {
		try {
			tecnologiaService.remove(id);
		}
		catch(ExcepcionTecnologia excepcion) {
			String mensaje= excepcion.getMessage();
			model.addAttribute("mensaje", mensaje);
			return "tecnologia.error";
		}
		return "redirect:/tecnologia";
	}

	
	@ModelAttribute(MODEL_OBJECT)
	public TecnologiaDto createTecnologiaDtoModel() {
		return new TecnologiaDto();
	}
	
	@InitBinder(MODEL_OBJECT)
	public void initBinder(WebDataBinder binder) {
		
	}
}
