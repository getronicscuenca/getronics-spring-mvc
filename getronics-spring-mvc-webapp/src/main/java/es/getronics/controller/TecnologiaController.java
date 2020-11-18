package es.getronics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionDepartamento;
import es.getronics.exceptions.ExcepcionTecnologia;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;
import es.getronics.services.TecnologiaService;
import es.getronics.services.impl.DepartamentoServiceImpl;
import es.getronics.services.impl.TecnologiaServiceImpl;
import es.getronics.validators.DepartamentoValidator;
import es.getronics.validators.TecnologiaValidator;

@RequestMapping("tecnologia")
@Controller
public class TecnologiaController {

	private final String LIST_VIEW = "tecnologia.list";
	private final String TECNOLOGIA_VIEW = "tecnologia.tecnologia";
	private final String TECNOLOGIA_DETALLE = "tecnologia/detalle";
	private final String ERROR_VIEW = "tecnologia/error";
	
	@Autowired
	private TecnologiaService tecnologiaService;
		
	@Autowired
	private TecnologiaValidator tecnologiaValidator;
	@Autowired
	private DepartamentoService departamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarTecnologias(Model model) {
		List<TecnologiaDto> tecnologias = tecnologiaService.findAll();
		model.addAttribute("tecnologias", tecnologias);
		
		return new ModelAndView(LIST_VIEW, model.asMap());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("departamentos", departamentoService.findAll());
		model.addAttribute("tecnos", tecnologiaService.findAll());
		model.addAttribute("tecnologia", new TecnologiaDto());

		return new ModelAndView(TECNOLOGIA_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateTecnologia(@PathVariable Long id, Model model) {
		model.addAttribute("tecnologia", tecnologiaService.findById(id));
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(TECNOLOGIA_VIEW, model.asMap());

	}

	@RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
	public ModelAndView showTecnologia(@PathVariable Long id, Model model) {
		model.addAttribute("tecnologia", tecnologiaService.findById(id));
		//model.addAttribute("departamentos", departamentoService.findAll());

		return new ModelAndView(TECNOLOGIA_DETALLE, model.asMap());

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarTecnologia(@ModelAttribute("tecnologia") @Valid TecnologiaDto tecnologia,
			BindingResult bindingResult, Model model) {
				
		if (bindingResult.hasErrors()) { 
			List<ObjectError> listaErrores = bindingResult.getAllErrors();
			String mensajeError="";
			for(ObjectError error:listaErrores) {
				mensajeError=mensajeError+"<br/>"+error.getCode();
			}
			model.addAttribute("mensaje", mensajeError);
			return "tecnologia.error";
		}

		if (tecnologia.getId() != null) {
			tecnologiaService.update(tecnologia);
		} else {
			try {
				tecnologiaService.insert(tecnologia);
				departamentoService.nuevaTecnoDepartamento(tecnologia);
			}
			catch(ExcepcionTecnologia excepcion) {
				String mensaje= excepcion.getMessage();
				model.addAttribute("mensaje", mensaje);
				return "tecnologia.error";
			}
		
		}
		return "redirect:/tecnologia";
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

	@ModelAttribute("tecnologia")
	public TecnologiaDto createTecnologiaDtoModel() {
		return new TecnologiaDto();
	}

}
