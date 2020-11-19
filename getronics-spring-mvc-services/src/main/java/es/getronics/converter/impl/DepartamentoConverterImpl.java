/**
 * @file DepartamentoConverterImpl.java
 * @date 19 nov. 2020
 * @time 13:02:58
 * 
 */
package es.getronics.converter.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.KeyValueItem;

/**
 * @author alatorre
 *
 * 
 */
public class DepartamentoConverterImpl implements Converter<Departamento, DepartamentoDto> {

	@Autowired
	private TecnologiaDao tecnologiaDao;

	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		// departamento
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setDescripcion(source.getDesc());
		// Tecnologia-departamento
		List<Long> selectedTecnologias = new ArrayList<Long>();
		List<String> tecnologias = new ArrayList<String>();
		for (Tecnologia tecnologia : source.getTecnologias()) {
			selectedTecnologias.add(tecnologia.getId());
			tecnologias.add(tecnologia.getNombre());
		}
		result.setTecnologias(tecnologias);
		result.setSelectedTecnologias(selectedTecnologias);
		// Empleado-Departamento
		List<String> empleados = new ArrayList<String>();
		if (source.getEmpleados() != null) {
			for (Empleado empleado : source.getEmpleados()) {
				empleados.add(empleado.getNombre() + " " + empleado.getApellido1() + " " + empleado.getApellido2());
			}
		}
		result.setEmpleados(empleados);
		// devolvemos
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto source) {
		Departamento result = new Departamento();
		// departamento
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setDesc(source.getDescripcion());
		// tecnologia-Departmento
		Set<Tecnologia> tecnologias = new HashSet<Tecnologia>();
		if (source.getSelectedTecnologias() != null) {

			for (Long tecnologiaId : source.getSelectedTecnologias()) {
				tecnologias.add(tecnologiaDao.findById(tecnologiaId));
			}
		}
		//devolvemos
		return result;
	}

	@Override
	public KeyValueItem mapToKeyValue(Departamento source) {
		// TODO Auto-generated method stub
		return null;
	}

}
