package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Tecnologias;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiasDao;
import es.getronics.dto.ItemTecnologia;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiasDto;
import es.getronics.services.TecnologiasService;

@Service
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
		tecnologiasDao.insert(tecnologia);
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
	
	public List<KeyValueItem> obtenerItemsTecnologia(){
		List<Tecnologias> tecnologias = tecnologiasDao.findAll();
		List<KeyValueItem> items = new ArrayList<KeyValueItem>();
		for(Tecnologias tecnologia : tecnologias) {
			items.add(tecnologiasConverter.mapItems(tecnologia));
		}
		return items;
	}

}
