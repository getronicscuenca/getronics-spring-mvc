package es.getronics.controller;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.base.exceptions.DepartamentoExisteException;
import es.getronics.base.exceptions.FechaPasadaException;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.converter.TecnoConverter;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.editors.TecnologiaEditor;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;
import es.getronics.services.TecnologiaService;
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
	private TecnologiaService tecnologiaService;
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private DepartamentoValidator departamentoValidator;
	@Autowired 
	private TecnologiaEditor tecnologiaEditor;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarDepartamentos(Model model) {
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("departamento", new DepartamentoDto());
		model.addAttribute("tecnologias", tecnologiaService.findAll());
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		model.addAttribute("tecnologias", tecnologiaService.findAll());
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());

	}

	@RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
	public ModelAndView showDepartamento(@PathVariable Long id, Model model) {
		DepartamentoDto dpt = departamentoService.findById(id);
		dpt.setEmpleados(empleadoService.findAll(id));
		model.addAttribute("departamento", dpt);
		return new ModelAndView(DEPARTAMENTO_DETALLE, model.asMap());

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public ModelAndView insertarDepartmento(@ModelAttribute("departamento") @Valid DepartamentoDto departamento,
			BindingResult bindingResult, Model model) {

		Date fecha = new Date();
//		redireccionamos en aso de que haya errores
		if (bindingResult.hasErrors()) {
			model.addAttribute("departamento", departamento);
			model.addAttribute("tecnologias", tecnologiaService.findAll());
			return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
		}
//		si tiene un id actualizamos
		if (departamento.getId() != null) {
			try {
				departamentoService.updateDepartamento(departamento);
			} catch (FechaPasadaException e) {

				model.addAttribute("departamento", departamento);
				return new ModelAndView(DEPARTAMENTO_ALTA, model.asMap());
			}
		} else {
//			insertamos
			departamento.setAlta(fecha);
			try {
				departamentoService.insertDepartamento(departamento);
			} catch (DepartamentoExisteException e) {
				model.addAttribute("departamento", departamento);
				model.addAttribute("tecnologias", tecnologiaService.findAll());
				model.addAttribute("errores", e.getMessage());
				return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
				
			}
		}
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@RequestMapping("delete/{id}")
	public String eliminarDepartamento(@PathVariable long id, Model model) {

		departamentoService.remove(id);
		return "redirect:/departamento";

	}

	@RequestMapping(value = "alta/{id}", method = RequestMethod.GET)
	public ModelAndView editarFecha(@PathVariable long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_ALTA, model.asMap());
	}

	@RequestMapping(value = "ascenso/{did}/{eid}")
	public ModelAndView ascender(@PathVariable long eid, @PathVariable long did, Model model) {

		departamentoService.link(did, eid);
		DepartamentoDto dpt = departamentoService.findById(did);
		dpt.setEmpleados(empleadoService.findAll(did));
		model.addAttribute("departamento", dpt);
		return new ModelAndView(DEPARTAMENTO_DETALLE, model.asMap());

	}

	@RequestMapping(value = "chAlta/{id}", method = RequestMethod.POST)
	public ModelAndView guardarFecha(@PathVariable long id, @ModelAttribute DepartamentoDto departamento,
			@RequestParam Date date, Model model) {

		departamento = departamentoService.findById(id);
		departamento.setAlta(date);

		try {
			departamentoService.updateDepartamento(departamento);
		} catch (FechaPasadaException e) {

			model.addAttribute("departamento", departamentoService.findById(id));
			model.addAttribute("errores", e.getMessage());
			return new ModelAndView(DEPARTAMENTO_ALTA, model.asMap());

		}

		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(departamentoValidator);
		binder.registerCustomEditor(TecnologiaDto.class, tecnologiaEditor);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}

	@ModelAttribute("departamento")
	public DepartamentoDto createDepartamentoDtoModel() {
		return new DepartamentoDto();
	}

}
