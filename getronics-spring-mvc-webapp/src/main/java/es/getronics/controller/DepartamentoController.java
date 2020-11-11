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
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;
import es.getronics.services.TecnologiaService;
import es.getronics.validators.DepartamentoValidator;

@RequestMapping("departamento")
@Controller
public class DepartamentoController {

	private final String LIST_VIEW = "departamento.list";
	private final String DEPARTAMENTO_VIEW = "departamento.departamento";
	private final String DEPARTAMENTO_DETALLE = "departamento/detalle";
	private final String ERROR_VIEW = "departamento/error";
	private final String DEPARTAMENTO_ALTA = "departamento/alta";

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private TecnologiaService tecnologiaService;
	@Autowired
	private DepartamentoValidator departamentoValidator;
	@Autowired
	private EmpleadoService empleadoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarDepartamentos(Model model) {
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		//List<EmpleadoDto> empleados= departamentoService.findAllT3(departamento);
		List<TecnologiaDto> tecnologias = tecnologiaService.findAll();
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("tecnologias", tecnologias);

		return new ModelAndView(LIST_VIEW, model.asMap());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("jefe", empleadoService.findAll());
		model.addAttribute("depars", departamentoService.findAll());
		model.addAttribute("departamento", new DepartamentoDto());

		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		List<EmpleadoDto> jefe = empleadoService.findAll();
		model.addAttribute("jefe", jefe);
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());

	}

	@RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
	public ModelAndView showDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		model.addAttribute("jefe", empleadoService.findById(id));

		return new ModelAndView(DEPARTAMENTO_DETALLE, model.asMap());

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarDepartamento(@ModelAttribute("departamento") @Valid DepartamentoDto departamento,
			BindingResult bindingResult, Model model) {
		//Date fecha = new Date();
		//String depar = departamentoService.findByName(departamento);
		
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
			//departamento.setAlta(fecha);
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
		model.addAttribute("departamento", departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_ALTA, model.asMap());
	}

	@RequestMapping(value = "chAlta/{id}", method = RequestMethod.POST)
	public String guardarFecha(@PathVariable long id, @ModelAttribute DepartamentoDto departamento,
			@RequestParam Date date) {

		departamento = departamentoService.findById(id);
		//departamento.setAlta(date);
		departamentoService.update(departamento);

		return "redirect:/departamento";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(departamentoValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ModelAttribute("departamento")
	public DepartamentoDto createDepartamentoDtoModel() {
		return new DepartamentoDto();
	}

}
