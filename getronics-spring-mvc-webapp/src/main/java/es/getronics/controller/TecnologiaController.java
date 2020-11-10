/**
 * 
 */
package es.getronics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.bom.Tecnologia;
import es.getronics.dto.TecnologiaDTO;
import es.getronics.services.TecnologiaService;

/**
 * Este es el controlador de endpoints para la gestión de tecnologías.
 * 
 * @author jgarcia7
 *
 */
@RequestMapping("tecnologia")
@Controller
public class TecnologiaController {
	
	@Autowired
	private TecnologiaService tecnologiaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView findAllTechnologies() {
		List<TecnologiaDTO> technologies = tecnologiaService.findAllTechnologies();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("technologies", technologies);
		return new ModelAndView("tecnologia.list", model);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertarTecnologia(@ModelAttribute("tecnologia") TecnologiaDTO tecnologia) {
		
		tecnologiaService.insert(tecnologia);
		return new ModelAndView("tecnologia.nuevo");
	
		
	}

}
