package es.getronics.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.bom.Tecnologias;
import es.getronics.dao.TecnologiasDao;

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
		List<Long> selectedTecnologiasId = new ArrayList<Long>();
		for (Tecnologias tecnologia : source.getTecnologia()) {
			selectedTecnologiasId.add(tecnologia.getId());
		}
		result.setTecnologiaId(selectedTecnologiasId);
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
		List<Tecnologias> tecnologias= new ArrayList<Tecnologias>();
		if(dto.getTecnologiaId()!=null) {
			for(Long id: dto.getTecnologiaId()) {
				tecnologias.add(tecnologiasDao.findById(id));
			}
		}
		entity.setTecnologia(tecnologias);
		
		return entity;
	}

}
