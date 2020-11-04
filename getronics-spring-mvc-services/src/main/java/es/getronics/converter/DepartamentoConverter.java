package es.getronics.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dto.DepartamentoDto;

@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto>{
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setDesc(source.getDesc());
		result.setJefe(source.getJefe().getId());
		
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento res= new Departamento();
		res.setId(dto.getId());
		res.setNombre(dto.getNombre());
		res.setAlta(dto.getAlta());
		res.setDesc(dto.getDesc());
		res.setJefe(empleadoDao.findById(dto.getJefe()));
	
		return res;
	}

	

}
