package es.getronics.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.impl.DepartamentoDaoImpl;
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

	

}
