package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.TecnologiaDTO;
import es.getronics.services.TecnologiaService;

@Service("tecnologiaService")
public class TecnologiaServiceImpl implements TecnologiaService {

	@Autowired
	private TecnologiaDao tecnologiaDao;

	@Autowired
	private Converter<Tecnologia, TecnologiaDTO> tecnologiaConverter;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<TecnologiaDTO> findAllTechnologies() {
		// TODO Auto-generated method stub
		List<Tecnologia> found = tecnologiaDao.findAll();
		List<TecnologiaDTO> retorno = new ArrayList<TecnologiaDTO>();
		for (Tecnologia tecnologia : found) {
			retorno.add(tecnologiaConverter.convert(tecnologia));
		}
		return retorno;
	}

	
	@Override
	public TecnologiaDTO insert(TecnologiaDTO dto) {
		Tecnologia entity = modelMapper.map(dto, Tecnologia.class);
		dto= modelMapper.map(tecnologiaDao.insert(entity), TecnologiaDTO.class);
		return dto;
	}


	

	

}
