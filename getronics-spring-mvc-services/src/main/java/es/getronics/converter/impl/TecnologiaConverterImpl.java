package es.getronics.converter.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.converter.EmpleadoConverter;
import es.getronics.converter.TecnologiaConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;
import es.getronics.dto.TecnologiaItem;

@Component ("tecnologiaConverter")
public class TecnologiaConverterImpl implements Converter<Tecnologia, TecnologiaDto> {

	/*@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private TecnologiaDao tecnologiaDao;
		
	@Autowired
	private DepartamentoConverter<Departamento, DepartamentoDto> departamentoConverter;
	
	@Autowired
	private EmpleadoConverter<Empleado, EmpleadoDto> empleadoConverter;*/
	
	@Override
	public TecnologiaDto convert(Tecnologia source) {
		TecnologiaDto result = new TecnologiaDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDescripcion(source.getDescripcion());
		
		return result;
	}

	@Override
	public Tecnologia map(TecnologiaDto dto) {
		Tecnologia result = new Tecnologia();
		result.setId(dto.getId());
		result.setNombre(dto.getNombre());
		result.setDescripcion(dto.getDescripcion());
		
		return result;
	}

	@Override
	public KeyValueItem mapToKeyValue(Tecnologia source) {
		TecnologiaItem item = new TecnologiaItem();
		item.setKey(source.getId());
		item.setValue(source.getNombre());
		return item;
	}

	/*@Override
	public TecnologiaDto convertToList(Tecnologia source) { 
		TecnologiaDto result = new TecnologiaDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDesc(source.getDesc());
				
		if(source.getDepartamentos() != null) {
			result.setDepartamentos(departamentoConverter.convertToListSet(source.getDepartamentos()));
			result.setIdDepartamentos(departamentoConverter.convertToListId(source.getDepartamentos()));
			
		}
		
		return result;
	}

	@Override
	public Tecnologia mapToList(TecnologiaDto dto) {
		Tecnologia result = new Tecnologia();
		//result.setId(dto.getId());
		result.setId(1L);
		result.setNombre(dto.getNombre());
		result.setDesc(dto.getDesc());
				
		Set<Departamento> departamentos = new HashSet<Departamento>();
		if(dto.getIdDepartamentos() != null) {
			for(Long departamentoId : dto.getIdDepartamentos()) {
				departamentos.add(departamentoDao.findById(departamentoId));
			}
		}
		result.setDepartamentos(departamentos);
		return result;
	
	}
	@Override
	public Set<TecnologiaDto> convertToListSet(Set<Tecnologia> source) {
		Set<TecnologiaDto> listaTecnologias = new HashSet<TecnologiaDto>();
		for(Tecnologia tecnologia:source) {
			listaTecnologias.add(this.convert(tecnologia));
		}
		return listaTecnologias;
	}

	@Override
	public Set<Tecnologia> mapToListSet(Set<TecnologiaDto> dto) {
		Set<Tecnologia> listaTecnologias = new HashSet<Tecnologia>();
		for(TecnologiaDto tecnologia:dto) {
			listaTecnologias.add(this.map(tecnologia));
		}
		return listaTecnologias;
	}

	@Override
	public Set<Long> convertToListId(Set<Tecnologia> source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tecnologia> mapToListId(Set<Long> dto) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
}
