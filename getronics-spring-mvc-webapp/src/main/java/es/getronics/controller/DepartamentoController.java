package es.getronics.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.DepartamentoDto;
import es.getronics.services.DepartamentoService;


@RequestMapping("/departamento")
@Controller
public class DepartamentoController {
	
	private final String LIST_VIEW = "departamento/list";
	private final String DEPARTAMENTO_VIEW = "departamento/departamento";
	private final String ERROR_VIEW = "departamento/error";
	
	@Autowired
	DepartamentoService departamentoService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarDept(Model model) {
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}	

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView mostrarNuevaPagina(Model model) {
		model.addAttribute("departamento", new DepartamentoDto());
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView mostrarActualizarDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento",departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}
	
	
	
	@RequestMapping(value="new",method=RequestMethod.POST)
	public String insertarDepartamento(@ModelAttribute DepartamentoDto departamento, Model model) {
		System.out.println("FECHAAAAAAA : "+departamento.getFecha());
		LocalDate fecha = LocalDate.now();
		if(departamento.getId() != null) {
			departamento.setFecha(fecha);
			departamentoService.update(departamento);
		}else {
			departamento.setFecha(fecha);
			departamentoService.insert(departamento);
		}
		return "redirect:/departamento";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarDepartamento(@PathVariable Long id, Model model) {
		departamentoService.remove(id);
		return "redirect:/departamento";
	}
}