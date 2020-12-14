package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiaDao;
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
	public TecnologiaDTO insert(TecnologiaDTO dto) {
		Tecnologia entity = modelMapper.map(dto, Tecnologia.class);
		dto = modelMapper.map(tecnologiaDao.insert(entity), TecnologiaDTO.class);
		return dto;
	}



	@Override
	public TecnologiaDTO findById(Long id) {
		Tecnologia tec = tecnologiaDao.findById(id);
		return tecnologiaConverter.convert(tec);
	}

	@Override
	public List<TecnologiaDTO> findAll() {
		List<TecnologiaDTO> result = new ArrayList<>();
		List<Tecnologia> found= tecnologiaDao.findAll();
		for(Tecnologia tecnologia: found)
		{
			result.add(modelMapper.map(tecnologia, TecnologiaDTO.class));
		}
		return result;
	}

	@Override
	public List<TecnologiaDTO> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TecnologiaDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(TecnologiaDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(TecnologiaDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TecnologiaDTO> findByExample(TecnologiaDTO example) {
		// TODO Auto-generated method stub
		return null;
	}
}
