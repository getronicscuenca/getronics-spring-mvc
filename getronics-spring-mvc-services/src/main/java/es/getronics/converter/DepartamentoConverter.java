package es.getronics.converter;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologia;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;



@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto>{
	
	@Autowired
	ModelMapper mapper;
	@Autowired
	TecnologiaDao tecnologiaDao;

	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setEncargado(source.getJefe().getNombre());
		
		
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento result =mapper.map(dto, Departamento.class);
		if(dto.getTecnologia()!=null)
		{
			Set<Tecnologia> set= new HashSet<Tecnologia>();
			for (String id : dto.getTecnologia()) {
				set.add(tecnologiaDao.findById(Long.parseLong(id)));
			}
			result.setTecnologias(set);
		}
		
	
		
		return result;
	}

	

}
