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
import es.getronics.dto.TecnologiaDto;



@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto>{
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private TecnologiaDao tecnologiaDao;

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
		if(dto.getTecnologias()!=null)
		{
			Set<Tecnologia> set= new HashSet<Tecnologia>();
			for (TecnologiaDto tecnologia : dto.getTecnologias()) {
				set.add(tecnologiaDao.findById(tecnologia.getId()));
			}
			result.setTecnologias(set);
		}
		
		return result;
	}

	

}
