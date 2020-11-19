package es.getronics.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import es.getronics.base.dao.exception.GetronicsDaoException;
import es.getronics.dto.DepartamentoDto;
import es.getronics.exceptions.ExcepcionDepartamento;
import es.getronics.services.DepartamentoService;
import es.getronics.services.TecnologiaService;
//import es.getronics.validators.DepartamentoValidator;

@RequestMapping("departamento")
@Controller
public class DepartamentoController {

	private final String LIST_VIEW = "departamento.list";
	private final String DEPARTAMENTO_VIEW = "departamento.departamento";
	private final String DEPARTAMENTO_DETALLE = "departamento.detalle";
	private final String DEPARTAMENTO_ALTA = "departamento.alta";
	private final String REDIRECT_TO_DEPARTAMENTO = "redirect:/departamento";

	private final String MODEL_OBJECT = "departamento";
	private final String LIST_MODEL_OBJECT = "departamentos";
	private final String TECNOLOGIAS_OBJECT = "tecnologias";
	
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private TecnologiaService tecnologiaService;
	
	/*@Autowired
	private DepartamentoValidator departamentoValidator;*/

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarDepartamentos(Model model) {
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute(LIST_MODEL_OBJECT, departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());

	}

	/**
	 * M�todo de apoyo para retornar la vista DEPARTAMENTO_VIEW inicializada
	 * @param model Model para inicializar los objetos de la vista
	 * @return Departamento View Page
	 */
	private String departamentoViewPage(Model model) {
		model.addAttribute(TECNOLOGIAS_OBJECT, tecnologiaService.findAllAsItems());
		return DEPARTAMENTO_VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String showNewPage(Model model) {
		return departamentoViewPage(model);
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String showUpdateDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute(MODEL_OBJECT, departamentoService.findById(id));
		return departamentoViewPage(model);

	}
	
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarDepartamento(@ModelAttribute("departamento") @Valid DepartamentoDto departamento,
			BindingResult bindingResult, Model model) {
				
		if (bindingResult.hasErrors()) { 
			List<ObjectError> listaErrores = bindingResult.getAllErrors();
			String mensajeError="";
			for(ObjectError error:listaErrores) {
				mensajeError=mensajeError+"<br/>"+error.getCode();
			}
			model.addAttribute("mensaje", mensajeError);
			return "departamento.error";
		}

		if (departamento.getId() != null) {
			departamentoService.update(departamento);
		} else {
			try {
			departamentoService.insert(departamento);
			}
			catch(ExcepcionDepartamento excepcion) {
				String mensaje= excepcion.getMessage();
				model.addAttribute("mensaje", mensaje);
				return "departamento.error";
			}
		
		}
		return "redirect:/departamento";
	}

	@RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
	public ModelAndView showDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute(MODEL_OBJECT, departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_DETALLE, model.asMap());
	}
	

	@RequestMapping("delete/{id}")
	public String eliminarDepartamento(@PathVariable Long id, Model model) {
		try {
		departamentoService.remove(id);
		}
		catch(ExcepcionDepartamento excepcion) {
			String mensaje= excepcion.getMessage();
			model.addAttribute("mensaje", mensaje);
			return "departamento.error";
		}
		return "redirect:/departamento";
	}

	@RequestMapping(value = "alta/{id}", method = RequestMethod.POST)
	public ModelAndView editarFecha(@PathVariable long id, Model model) {
		model.addAttribute(MODEL_OBJECT, departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_ALTA, model.asMap());
	}

	/*@InitBinder(MODEL_OBJECT)
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(departamentoValidator);
	}
	*/
	@ModelAttribute(MODEL_OBJECT)
	public DepartamentoDto createDepartamentoDtoModel() {
		return new DepartamentoDto();
	}

}
