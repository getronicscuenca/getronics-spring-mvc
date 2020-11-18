package es.getronics.converter.impl;

import java.util.HashSet;
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
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;

@Component
public class DepartamentoConverterImpl implements Converter<Departamento, DepartamentoDto>, 
				DepartamentoConverter<Departamento, DepartamentoDto>{
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private EmpleadoConverter<Empleado, EmpleadoDto> empleadoConverter;
	
	@Autowired
	private Converter<Tecnologia, TecnologiaDto> tecnologiaConverter;
	
	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		//result.setAlta(source.getAlta());
		result.setDesc(source.getDesc());
		if(source.getJefe() != null) {
			result.setIdJefe(source.getJefe().getId());
			result.setJefe(source.getJefe().getNombre());
		}
		
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento result= new Departamento();
		//result.setId(dto.getId());
		result.setId(1L);
		result.setNombre(dto.getNombre());
		//res.setAlta(dto.getAlta());
		result.setDesc(dto.getDesc());
		if(dto.getIdJefe() != null) {
			result.setJefe(empleadoDao.findById(dto.getIdJefe()));
		}
	
		return result;
	}

	@Override
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
		result.setId(1L);
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
	}

}
