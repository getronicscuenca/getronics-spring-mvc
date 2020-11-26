package es.getronics.converter.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.KeyValueItem;

@Component("departamentoConverter")
public class DepartamentoConverterImpl implements Converter<Departamento, DepartamentoDto> {

	@Autowired
	private TecnologiaDao tecnologiaDao;

	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		//result.setAlta(source.getAlta());
		result.setDescripcion(source.getDescripcion());
		List<Long> selectedTecnologias = new ArrayList<Long>();
		List<String> tecnologias = new ArrayList<String>();
		for(Tecnologia tecnologia : source.getTecnologias()) {
			selectedTecnologias.add(tecnologia.getId());
			tecnologias.add(tecnologia.getNombre());
		}
		result.setTecnologias(tecnologias);
		
		List<String> empleados = new ArrayList<String>();
		if(source.getEmpleados() != null) {
			for(Empleado empleado : source.getEmpleados()) {
				empleados.add(empleado.getNombre() + " " + empleado.getApellido1() + " " + empleado.getApellido2());
			}
		}
		result.setEmpleados(empleados);
		
		result.setSelectedTecnologias(selectedTecnologias);
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento result = new Departamento();
		result.setId(dto.getId());
		result.setNombre(dto.getNombre());
		//result.setAlta(dto.getAlta());
		result.setDescripcion(dto.getDescripcion());
		Set<Tecnologia> tecnologias = new HashSet<Tecnologia>();
		if(dto.getSelectedTecnologias() != null) {
			for(Long tecnologiaId : dto.getSelectedTecnologias()) {
				tecnologias.add(tecnologiaDao.findById(tecnologiaId));
			}
		}
		result.setTecnologias(tecnologias);
		return result;
	}

	@Override
	public KeyValueItem mapToKeyValue(Departamento source) {
		// TODO Auto-generated method stub
		return null;
	}
}
