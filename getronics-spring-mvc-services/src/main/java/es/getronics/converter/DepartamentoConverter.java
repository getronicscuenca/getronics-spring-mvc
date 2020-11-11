package es.getronics.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologias;
import es.getronics.dao.TecnologiasDao;
import es.getronics.dto.DepartamentoDto;

@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto> {

	@Autowired
	private TecnologiasDao tecnologiasDao;

	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setDesc(source.getDesc());
		result.setIdEmpleado(source.getIdEmpleado());
		result.setNombreEmpleado(source.getNombreEmpleado());
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento entity = new Departamento();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setAlta(dto.getAlta());
		entity.setDesc(dto.getDesc());
		entity.setIdEmpleado(dto.getIdEmpleado());
		entity.setNombreEmpleado(dto.getNombreEmpleado());
		entity.setTecnologia(dto.getTecnologiaList());
		return entity;
	}

}
