package es.getronics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.TecnologiasDto;
import es.getronics.exceptions.TecnologiasException;
import es.getronics.services.DepartamentoService;
import es.getronics.services.TecnologiasService;
import es.getronics.validators.TecnologiasValidator;

@RequestMapping("tecnologias")
@Controller
public class TecnologiasController {

	private final String LIST_VIEW = "tecnologias.list";
	private final String TECNOLOGIAS_VIEW = "tecnologias.tecnologias";
	private final String TECNOLOGIAS_DETALLE = "tecnologias.detalle";
	private final String ERROR_VIEW="tecnologias.error";

	@Autowired
	private TecnologiasService tecnologiasService;

	@Autowired
	private TecnologiasValidator tecnologiasValidator;

	@Autowired
	private DepartamentoService departamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarTecnologias(Model model) {
		List<TecnologiasDto> tecnologias = tecnologiasService.findAll();
		model.addAttribute("tecnologias", tecnologias);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("tecnologias", new TecnologiasDto());
		model.addAttribute("departamentos", departamentoService.findAll());
		return new ModelAndView(TECNOLOGIAS_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateTecnologias(@PathVariable Long id, Model model) {
		model.addAttribute("tecnologias", tecnologiasService.findById(id));
		model.addAttribute("departamentos", departamentoService.findAll());
		return new ModelAndView(TECNOLOGIAS_VIEW, model.asMap());
	}

	@RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
	public ModelAndView detalleTecnologias(@PathVariable Long id, Model model) {
		model.addAttribute("tecnologia", tecnologiasService.findById(id));
		return new ModelAndView(TECNOLOGIAS_DETALLE, model.asMap());

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarTecnologia(@ModelAttribute("tecnologias") @Valid TecnologiasDto tecnologias,
			BindingResult bindingResult, Model model) throws TecnologiasException {

		if (bindingResult.hasErrors()) {
			return TECNOLOGIAS_VIEW;
		}

		if (tecnologias.getId() != null) {
			tecnologiasService.update(tecnologias);
		} else {
			tecnologiasService.validarTecnologias(tecnologias);

		}
		return "redirect:/tecnologias";
	}

	@RequestMapping("delete/{id}")
	public String eliminarTecnologia(@PathVariable Long id, Model model) {
		tecnologiasService.remove(id);
		return "redirect:/tecnologias";
	}
	
	@ExceptionHandler(TecnologiasException.class)
	public ModelAndView tecnologiasException(TecnologiasException ex) {
		ModelAndView model = new ModelAndView(ERROR_VIEW);
		model.addObject("problema", ex.getMessage());
		return model;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(tecnologiasValidator);
	}
}