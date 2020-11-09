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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.exceptions.ExcepcionDepartamento;
import es.getronics.exceptions.ExcepcionEmpleado;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;
import es.getronics.services.impl.EmpleadoServiceImpl;

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
	public String insertarEmpleado(@ModelAttribute("empleado") @Valid EmpleadoDto empleado,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) { 
			List<ObjectError> listaErrores = bindingResult.getAllErrors();
			String mensajeError="";
			for(ObjectError error:listaErrores) {
				mensajeError=mensajeError+"</br>"+error.getCode();
			}
			model.addAttribute("mensaje", mensajeError);
			return "empleado.error";
		}
		
		if(empleado.getId() != null) {
			empleadoService.update(empleado);
		} else {
			//departamento.setAlta(fecha);
			try {
				empleadoService.insert(empleado);
				departamentoService.nuevoEmpleDepartamento(empleado);
			}
			catch(ExcepcionEmpleado excepcion) {
				String mensaje= excepcion.getMessage();
				model.addAttribute("mensaje", mensaje);
				return "empleado.error";
			}
		
		}
		return "redirect:/empleado";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarEmpleado(@PathVariable Long id, Model model) {
		try {
			departamentoService.eliminarEmpleDepartamento(id);
			empleadoService.remove(id);
		}
		catch(ExcepcionEmpleado excepcion) {
			String mensaje= excepcion.getMessage();
			model.addAttribute("mensaje", mensaje);
			return "empleado.error";
		}
		return "redirect:/empleado";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
	}
}
