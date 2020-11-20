package es.getronics.converter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologias;
import es.getronics.dao.TecnologiasDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.KeyValueItem;

@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto>{

	@Autowired
	TecnologiasDao tecnologiasDao;
	
	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setDesc(source.getDesc());
		//result.setIdEmpleado(source.getEmpleadoJefe().getId());
		result.setNombreEmpleado(source.getNombreEmpleado());
		List<Long> selectedTecnologias = new ArrayList<Long>();
		List<String> tecnologias = new ArrayList<String>();
		for(Tecnologias tecnologia : source.getTecnologia()) {
			selectedTecnologias.add(tecnologia.getId());
			tecnologias.add(tecnologia.getNombre());
		}
		result.setSelectedTecnologias(selectedTecnologias);
		result.setTecnologias(tecnologias);
		System.out.println("TECNOLOGIAS Nº ------------>"+result.getSelectedTecnologias().size());
		int tamanio = result.getSelectedTecnologias().size();
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento result = new Departamento();
		result.setId(dto.getId());
		result.setAlta(dto.getAlta());
		result.setDesc(dto.getDesc());
		result.setNombre(dto.getNombre());
		List<Long> idsTecnologias = dto.getSelectedTecnologias();
		List<Tecnologias> listaTecnologias = new ArrayList<>();
		for(Long id : idsTecnologias) {
			listaTecnologias.add(tecnologiasDao.findById(id));
		}
		result.setTecnologia(listaTecnologias);
		return result;
	}

	@Override
	public KeyValueItem mapItems(Departamento source) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
