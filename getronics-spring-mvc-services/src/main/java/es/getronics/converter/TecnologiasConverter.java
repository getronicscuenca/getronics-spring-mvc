package es.getronics.converter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologias;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dto.TecnologiasDto;

@Component
public class TecnologiasConverter implements Converter <Tecnologias, TecnologiasDto> {
	
	@Autowired
	private DepartamentoDao departamentoDao;

	@Override
	public TecnologiasDto convert(Tecnologias source) {
		TecnologiasDto result= new TecnologiasDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDescripcion(source.getDescripcion());
		return result;
	}

	@Override
	public Tecnologias map(TecnologiasDto dto) {
		Tecnologias tecnologia = new Tecnologias();
		tecnologia.setId(dto.getId());
		tecnologia.setNombre(dto.getNombre());
		tecnologia.setDescripcion(dto.getDescripcion());
		Departamento departamento = departamentoDao.findById(dto.getIdDepartamento());
		if (departamento!=null) {
			List<Departamento> departamentos = new ArrayList<Departamento>();
			tecnologia.setDepartamentos(departamentos);
			tecnologia.anadirDepartamento(departamento);
		}
		return tecnologia;
	}

}
