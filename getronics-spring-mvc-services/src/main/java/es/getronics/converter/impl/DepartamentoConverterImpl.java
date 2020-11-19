package es.getronics.converter.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.converter.EmpleadoConverter;
import es.getronics.converter.TecnologiaConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;

@Component("departamentoConverter")
public class DepartamentoConverterImpl implements Converter<Departamento, DepartamentoDto> {
	
	/*@Autowired
	private EmpleadoDao empleadoDao;
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private EmpleadoConverter<Empleado, EmpleadoDto> empleadoConverter;
	
	@Autowired
	private TecnologiaConverter<Tecnologia, TecnologiaDto> tecnologiaConverter;
	*/
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

	/*@Override
	public DepartamentoDto convertToList(Departamento source) { 
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDesc(source.getDesc());
		if(source.getJefe() != null) {
			result.setJefe(source.getJefe().getNombre());
			result.setIdJefe(source.getJefe().getId());
		}
		if(source.getEmpleados() != null) {
			result.setEmpleados(empleadoConverter.convertToListSet(source.getEmpleados()));
		}
		
		if(source.getTecnologias() != null) {
			result.setTecnologias(tecnologiaConverter.convertToListSet(source.getTecnologias()));
		}
		return result;
	}

	@Override
	public Departamento mapToList(DepartamentoDto dto) {
		Departamento result = new Departamento();
		//result.setId(dto.getId());
		result.setId(2L);
		result.setNombre(dto.getNombre());
		result.setDesc(dto.getDesc());
		if(dto.getJefe() != null) {
			result.setJefe(empleadoDao.findById(dto.getIdJefe()));
		}
		if(dto.getEmpleados() != null) {
			result.setEmpleados(empleadoConverter.mapToListSet(dto.getEmpleados()));
		}
		if(dto.getTecnologias() != null) {
			result.setTecnologias(tecnologiaConverter.mapToListSet(dto.getTecnologias()));
		}
		
		return result;
	}
	
	@Override
	public Set<DepartamentoDto> convertToListSet(Set<Departamento> source) {
		Set<DepartamentoDto> listaDepartamentos = new HashSet<DepartamentoDto>();
		for(Departamento departamento:source) {
			listaDepartamentos.add(this.convert(departamento));
		}
		return listaDepartamentos;
	}

	@Override
	public Set<Departamento> mapToListSet(Set<DepartamentoDto> dto) {
		Set<Departamento> listaDepartamentos = new HashSet<Departamento>();
		for(DepartamentoDto departamento:dto) {
			listaDepartamentos.add(this.map(departamento));
		}
		return listaDepartamentos;
	}
	
	@Override
	public Set<Long> convertToListId(Set<Departamento> source) {
		Set<Long> listaIdDepartamentos = new HashSet<Long>();
		for(Departamento departamento:source) {
			listaIdDepartamentos.add(departamento.getId());
		}
		return listaIdDepartamentos;
	}

	@Override
	public Set<Departamento> mapToListId(Set<Long> dto) {
		Set<Departamento> listaDepartamentos = new HashSet<Departamento>();
		for(Long identificador:dto) {
			listaDepartamentos.add(departamentoDao.findById(identificador));
		}
		return listaDepartamentos;
	}*/

}
