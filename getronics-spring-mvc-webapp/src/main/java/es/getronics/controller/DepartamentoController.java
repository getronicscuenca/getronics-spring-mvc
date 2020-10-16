package es.getronics.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import es.getronics.services.DepartamentoService;

@RequestMapping("departamento")
@Controller
public class DepartamentoController {

	private final String LIST_VIEW = "departamento/list";
	private final String DEPARTAMENTO_VIEW = "departamento/departamento";
	private final String DEPARTAMENTO_DETALLE = "departamento/detalle";
	private final String ERROR_VIEW = "departamento/error";
	private final String DEPARTAMENTO_ALTA = "departamento/alta";

	@Autowired
	DepartamentoService departamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarDepartamentos(Model model) {
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("departamento", new DepartamentoDto());
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());

	}

	@RequestMapping(value = "ver/{id}", method = RequestMethod.GET)
	public ModelAndView showDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_DETALLE, model.asMap());

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarDepartmento(@ModelAttribute DepartamentoDto departamento, Model model) {
		Date fecha = new Date();

		if (departamento.getId() != null) {
			departamentoService.update(departamento);
		} else {
//			departamento.fechaAlta();
			departamento.setAlta(fecha);
			departamentoService.insert(departamento);
		}
		return "redirect:/departamento";
	}

	@RequestMapping("delete/{id}")
	public String eliminarDepartamento(@PathVariable long id, Model model) {

		departamentoService.remove(id);
		return "redirect:/departamento";

	}
	@RequestMapping(value="alta/{id}",  method = RequestMethod.POST)
	public ModelAndView editarFecha(@PathVariable long id, Model model)
	{
		model.addAttribute("departamento", departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_ALTA, model.asMap());
	}
	

	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
	@RequestMapping(value="chAlta/{id}",method = RequestMethod.POST)
	public String guardarFecha(@PathVariable long id, Model model)
	{
		return "redirect:/departamento";
	}
	@InitBinder
	public void initBinder(@RequestParam(value = "dia", required = false) String dia,
			@RequestParam(value= "mes", required= false) String mes,
			@RequestParam(value="ano", required=false) String ano, 
				WebDataBinder binder)
	{
		dia=(dia==null)?"0":dia;
		mes=(mes==null)?"0":mes;
		ano=(ano==null)?"0":ano;
		
		System.out.println(dia+"/"+mes+"/"+ano+"\n\n\n\n\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		binder.registerCustomEditor(Date.class, new DateMaker(dia,mes,ano));
		
	}
}

