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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.DepartamentoDto;
import es.getronics.exceptions.DepartamentoExistenteException;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;
import es.getronics.validators.DepartamentoValidator;

@RequestMapping("departamento")
@Controller
public class DepartamentoController {

	private final String LIST_VIEW = "departamento.list";
	private final String DEPARTAMENTO_VIEW = "departamento.departamento";
	private final String DEPARTAMENTO_DETALLE = "departamento.detalle";
	private final String ERROR_VIEW = "departamento.error";
	private final String DEPARTAMENTO_ALTA = "departamento.alta";

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private DepartamentoValidator departamentoValidator;
	@Autowired
	private EmpleadoService empleadoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarDepartamentos(Model model) {
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("departamento", new DepartamentoDto());
		model.addAttribute("empleados", empleadoService.findAll());
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		model.addAttribute("empleados", empleadoService.findAll());
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());

	}

	@RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
	public ModelAndView showDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_DETALLE, model.asMap());

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarDepartmento(@ModelAttribute("departamento") @Valid DepartamentoDto departamento,
			BindingResult bindingResult, Model model) throws DepartamentoExistenteException {
		if (bindingResult.hasErrors()) {
			return "departamento.departamento";
		}

		if (departamento.getId() != null) {
			departamento.setNombreEmpleado(empleadoService.findById(departamento.getIdEmpleado()).getNombre());
			departamentoService.update(departamento);
		} else {
			departamentoService.validarDepartamento(departamento);

		}
		return "redirect:/departamento";
	}

	@RequestMapping("delete/{id}")
	public String eliminarDepartamento(@PathVariable Long id, Model model) {

		/*
		 * List<Empleado> empleado= empleadoDao.findAll(); for(Empleado todos: empleado)
		 * { if(todos.getDepartamento().getId().equals(id)) { empleadoDao.remove(todos);
		 * } }
		 */
		departamentoService.remove(id);
		return "redirect:/departamento";

	}

	@RequestMapping(value = "alta/{id}", method = RequestMethod.POST)
	public ModelAndView editarFecha(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_ALTA, model.asMap());
	}

	@RequestMapping(value = "chAlta/{id}", method = RequestMethod.POST)
	public String guardarFecha(@PathVariable Long id, @ModelAttribute DepartamentoDto departamento,
			@RequestParam Date date) {

		departamento = departamentoService.findById(id);
		departamento.setAlta(date);
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

	@ExceptionHandler(DepartamentoExistenteException.class)
	public ModelAndView handleException(DepartamentoExistenteException ex) {
		ModelAndView model = new ModelAndView(ERROR_VIEW);
		model.addObject("problema", ex.getMessage());
		return model;
	}

	@ModelAttribute("departamento")
	public DepartamentoDto createDepartamentoDtoModel() {
		return new DepartamentoDto();
	}

}
