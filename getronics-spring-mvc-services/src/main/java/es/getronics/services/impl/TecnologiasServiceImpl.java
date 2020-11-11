package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Tecnologias;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiasDao;
import es.getronics.dto.TecnologiasDto;
import es.getronics.services.TecnologiasService;

@Service("tecnologiasService")
public class TecnologiasServiceImpl implements TecnologiasService {

	@Autowired
	private TecnologiasDao tecnologiasDao;
	
	@Autowired
	private Converter<Tecnologias, TecnologiasDto> tecnologiasConverter;
	
	@Override
	public TecnologiasDto findById(Long id) {
		Tecnologias tecnologia=  tecnologiasDao.findById(id);
		return tecnologiasConverter.convert(tecnologia);
	}

	@Override
	public List<TecnologiasDto> findAll() {
		List<TecnologiasDto> result = new ArrayList<>();
		List<Tecnologias> found = tecnologiasDao.findAll();
		for(Tecnologias empleado: found) {
			result.add(tecnologiasConverter.convert(empleado));
		}
		return result;
	}

	@Override
	public List<TecnologiasDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TecnologiasDto entity) {
		Tecnologias tecnologia= tecnologiasConverter.map(entity);
		tecnologiasDao.update(tecnologia);
	}

	@Override
	public void saveOrUpdate(TecnologiasDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TecnologiasDto insert(TecnologiasDto entity) {
		Tecnologias tecnologia= tecnologiasConverter.map(entity);
		entity= tecnologiasConverter.convert(tecnologiasDao.insert(tecnologia));
		return entity;
		
	}

	@Override
	public void remove(TecnologiasDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		tecnologiasDao.remove(id);
		
	}

	@Override
	public List<TecnologiasDto> findByExample(TecnologiasDto example) {
		// TODO Auto-generated method stub
		return null;
	}

}
