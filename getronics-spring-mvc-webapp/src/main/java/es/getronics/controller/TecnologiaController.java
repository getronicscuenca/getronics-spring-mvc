/**
 * 
 */
package es.getronics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.getronics.bom.Tecnologia;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
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

	@RequestMapping(value="new",method = RequestMethod.POST)
	public ModelAndView insertarTecnologia(@ModelAttribute("tecnologia") TecnologiaDTO tecnologia, Model model) {

		if (tecnologia.getId() != null) {
			tecnologiaService.update(tecnologia);
			model.addAttribute("technologies", tecnologiaService.findAllTechnologies());
			return new ModelAndView("tecnologia.list", model.asMap());
		} else {
			tecnologiaService.insert(tecnologia);
			model.addAttribute("technologies", tecnologiaService.findAllTechnologies());
			return new ModelAndView("tecnologia.list", model.asMap());
		}
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateTecnologia(@ModelAttribute("tecnologia") TecnologiaDTO tecnologia,
			@PathVariable Long id, Model model) {
		
		model.addAttribute("technologies", tecnologiaService.findById(id));

		return new ModelAndView("tecnologia.actualizar", model.asMap());
	}

}
