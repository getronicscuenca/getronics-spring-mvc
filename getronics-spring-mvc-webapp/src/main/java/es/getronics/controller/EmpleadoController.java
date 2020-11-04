/**
 * 
 */
package es.getronics.controller;

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
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.EmpleadoDto;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;

/**
 * Maneja las peticiones relacionadas con empleados
 * 
 * @author jgarcia
 *
 */
@RequestMapping("empleado")
@Controller
public class EmpleadoController {
	
	private final String LIST_VIEW = "empleado.list";
	private final String EMPLEADO_VIEW = "empleado.empleado";

	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarEmpleados(Model model) {
		List<EmpleadoDto> empleados = empleadoService.findAll();
		model.addAttribute("empleados", empleados);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("empleado", new EmpleadoDto());
		model.addAttribute("departamentos", departamentoService.findAll());
		return new ModelAndView(EMPLEADO_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateEmpleado(@PathVariable Long id, Model model) {
		EmpleadoDto empleado = empleadoService.findById(id);
		model.addAttribute("empleado", empleado);
		model.addAttribute("departamentos", departamentoService.findAll());
		
		return new ModelAndView(EMPLEADO_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarEmpleado(@ModelAttribute EmpleadoDto empleado, Model model) {
		if(empleado.getId() != null) {
			empleadoService.update(empleado);
		} else {
			empleadoService.insert(empleado);
		}
		return "redirect:/empleado";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarEmpleado(@PathVariable Long id, Model model) {
		empleadoService.remove(id);
		return "redirect:/empleado";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
	}
	
}
