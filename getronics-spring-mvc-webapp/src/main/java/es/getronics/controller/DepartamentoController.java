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
import org.springframework.web.servlet.ModelAndView;

import es.getronics.dto.DepartamentoDto;
import es.getronics.services.DepartamentoService;
import es.getronics.validadores.ValidadorDepart;


@RequestMapping("/departamento")
@Controller
public class DepartamentoController {
	
	private final String LIST_VIEW = "departamento/list";
	private final String DEPARTAMENTO_VIEW = "departamento/departamento";
	private final String DEPARTAMENTO_DETALLES = "departamento/verdetalles";
	private final String ERROR_VIEW = "departamento/error";
	
	@Autowired
	DepartamentoService departamentoService;
	
	@Autowired
	ValidadorDepart validadorDepart;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		
	}
	
	// LISTADO DE DEPARTAMENTOS
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarDept(Model model) {
		List<DepartamentoDto> departamentos = departamentoService.findAll();
		model.addAttribute("departamentos", departamentos);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}	

	// FORMULARIO ANADIR DEPARTAMENTO
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView mostrarNuevaPagina(Model model) {
		model.addAttribute("departamento", new DepartamentoDto());
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}
	
	// ACTUALIZAR DEPARTAMENTO
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView mostrarActualizarDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento",departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_VIEW, model.asMap());
	}
	
	
	// VISUALIZAR DEPARTAMENTO
	@RequestMapping(value="visualizar/{id}", method=RequestMethod.GET)
	public ModelAndView visualizarDepartamento(@PathVariable Long id, Model model) {
		model.addAttribute("departamento",departamentoService.findById(id));
		return new ModelAndView(DEPARTAMENTO_DETALLES, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
    public String insertarDepartamento( @ModelAttribute("departamento") @Valid DepartamentoDto departamento, BindingResult bindingResult, Model model) {
		validadorDepart.validate(departamento, bindingResult);
        if(bindingResult.hasErrors()) {
            return DEPARTAMENTO_VIEW;
        }
       
        if(departamento.getId() != null) {
           
            departamentoService.update(departamento);
        } else {
            departamentoService.insert(departamento);
        }
        return "redirect:/departamento";
    }
    
	@RequestMapping("delete/{id}")
	public String eliminarDepartamento(@PathVariable Long id, Model model) {
		departamentoService.remove(id);
		return "redirect:/departamento";
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(DEPARTAMENTO_VIEW);
	}
	
}