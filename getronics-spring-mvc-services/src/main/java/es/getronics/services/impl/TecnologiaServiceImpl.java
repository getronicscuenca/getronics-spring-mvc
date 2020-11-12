package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.criterion.DetachedCriteria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.base.exceptions.TecnologiaExisteException;
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
			result.add(tecnologiaConverter.convert(tecnologia));
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
	
	public TecnologiaDto insertarTecnologia(TecnologiaDto dto) throws TecnologiaExisteException
	{
		List<TecnologiaDto> tecnologias=findAll();
		if(tecnologias.contains(dto))
		{
			throw  new TecnologiaExisteException("ya existe una tecnologia con ese nombre");
		}
		
		return insert(dto);
		
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


	@Override
	public List<TecnologiaDto> findByCriteria(DetachedCriteria criteria) {
		throw new NotYetImplementedException("Metodo no implementado todavia");
	}

	
	
	
}
