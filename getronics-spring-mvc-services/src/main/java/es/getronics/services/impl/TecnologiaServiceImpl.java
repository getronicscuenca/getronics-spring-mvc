/**
 * 
 */
package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.base.dao.exception.GetronicsDaoException;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;
import es.getronics.services.TecnologiaService;

/**
 * Implementa la logica del servicio de empleados
 *
 * @author jgarcia
 *
 */
@Service("tecnologiaService")
public class TecnologiaServiceImpl implements TecnologiaService {

	@Autowired
	TecnologiaDao tecnologiaDao;
	
	@Autowired
	private Converter<Tecnologia, TecnologiaDto> tecnologiaConverter;
		
	public TecnologiaServiceImpl() {
		super();
	}

	@Override
	public TecnologiaDto findById(Long id) {
		Tecnologia entity = tecnologiaDao.findById(id);
		return entity != null ? tecnologiaConverter.convert(entity) : null;
	}

	@Override
	public List<TecnologiaDto> findAll() {
		List<TecnologiaDto> result = new ArrayList<>();
		List<Tecnologia> found = tecnologiaDao.findAll();
		for(Tecnologia empleado: found) {
			result.add(tecnologiaConverter.convert(empleado));
		}
		return result;
	}

	@Override
	public List<TecnologiaDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(TecnologiaDto dto) {
		Tecnologia entity = tecnologiaConverter.map(dto);
		tecnologiaDao.update(entity);
	}

	@Override
	public void saveOrUpdate(TecnologiaDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public TecnologiaDto insert(TecnologiaDto dto) {
		if(!tecnologiaDao.findByName(dto.getNombre()).isEmpty()) {
			throw new GetronicsDaoException("tecnologia.already.exists");
		}
		Tecnologia entity = tecnologiaConverter.map(dto);
		dto = tecnologiaConverter.convert(tecnologiaDao.insert(entity));
		
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		tecnologiaDao.remove(id);
	}

	@Override
	public void remove(TecnologiaDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<TecnologiaDto> findByExample(TecnologiaDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<KeyValueItem> findAllAsItems() {
		List<Tecnologia> tecnologias = tecnologiaDao.findAll();
		List<KeyValueItem> items = new ArrayList<KeyValueItem>();
		for (Tecnologia tecnologia : tecnologias) {
			items.add(tecnologiaConverter.mapToKeyValue(tecnologia));
		}
		return items;
	}

	@Override
	public List<DepartamentoDto> T3findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateT3(DepartamentoDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoDto insertT3(DepartamentoDto entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Long> convertToListId(Set<TecnologiaDto> source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TecnologiaDto> mapToListId(Set<Long> dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TecnologiaDto nuevoEmpleDepartamento(DepartamentoDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TecnologiaDto eliminarEmpleDepartamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TecnologiaDto nuevaTecnoDepartamento(EmpleadoDto entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
