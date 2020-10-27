package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.TecnologiaDto;
import es.getronics.services.TecnologiaService;


@Service("tecnologiaService")
public class TecnologiaServiceImpl implements TecnologiaService {

	@Autowired
	private TecnologiaDao tecnologiaDao;
	@Autowired
	private Converter<Tecnologia,TecnologiaDto> tecnologiaConverter;
	@Autowired
	private ModelMapper modelMapper;
	
	public TecnologiaServiceImpl() {
		super();
	}
	
	
	@Override
	public TecnologiaDto findById(Long id) {
		Tecnologia entity = tecnologiaDao.findById(id);
		return modelMapper.map(entity, TecnologiaDto.class);
	}
		

	@Override
	public List<TecnologiaDto> findAll() {
		List<TecnologiaDto> result =new ArrayList<>();
		List<Tecnologia> found =tecnologiaDao.findAll();
		for(Tecnologia tecnologia: found)
		{
			result.add(modelMapper.map(tecnologia, TecnologiaDto.class));
		}
		return result;
	}

	@Override
	public List<TecnologiaDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Metodo no implementado todavia");
	}

	@Override
	public void update(TecnologiaDto dto) {
		Tecnologia entity = modelMapper.map(dto, Tecnologia.class);
		tecnologiaDao.update(entity);
		
	}

	@Override
	public void saveOrUpdate(TecnologiaDto dto) {
		throw new NotYetImplementedException("Metodo no implementado todavia");
		
	}

	@Override
	public TecnologiaDto insert(TecnologiaDto dto) {
		Tecnologia entity =  modelMapper.map(dto, Tecnologia.class);
		tecnologiaDao.insert(entity);
		return dto;
		
	}

	@Override
	public void remove(TecnologiaDto dto) {
		throw new NotYetImplementedException("Metodo no implementado todavia");
		
	}

	@Override
	public void remove(Long id) {
		tecnologiaDao.remove(id);
		
	}

	@Override
	public List<TecnologiaDto> findByExample(TecnologiaDto dto) {
		throw new NotYetImplementedException("Metodo no implementado todavia");
	}

}
