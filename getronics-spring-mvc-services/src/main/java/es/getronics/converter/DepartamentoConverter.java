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
		List<Tecnologias> tecnologias = new ArrayList<Tecnologias>();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setAlta(dto.getAlta());
		entity.setDesc(dto.getDesc());
		entity.setIdEmpleado(dto.getIdEmpleado());
		entity.setNombreEmpleado(dto.getNombreEmpleado());
		if (dto.getTecnologiaId().length > 0) {
			for (int i = 0; i < dto.getTecnologiaId().length; i++) {
				Tecnologias tecnologia = tecnologiasDao.findById(dto.getTecnologiaId()[i]);
				tecnologias.add(tecnologia);
			}						
		}
		entity.setTecnologia(tecnologias);
		return entity;
	}

}
