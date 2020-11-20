package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.base.dao.exception.GetronicsDaoException;
import es.getronics.bom.Departamento;
import es.getronics.converter.Converter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.services.DepartamentoService;


@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {

	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private Converter<Departamento, DepartamentoDto> departamentoConverter;
	
	public DepartamentoServiceImpl()
	{
		super();
	}
	
	@Override
	public DepartamentoDto findById(Long id){
		Departamento entity = departamentoDao.findById(id);
		return departamentoConverter.convert(entity);
		
	}

	@Override
	public List<DepartamentoDto> findAll() {
		List<DepartamentoDto> result = new ArrayList<>();
		List<Departamento> found= departamentoDao.findAll();
		for(Departamento departamento: found)
		{
			result.add(departamentoConverter.convert(departamento));
		}
		return result;
	}

	@Override
	public List<DepartamentoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void update(DepartamentoDto dto) {
		Departamento entity = departamentoConverter.map(dto);
		departamentoDao.update(entity);
		
	}

	@Override
	public void saveOrUpdate(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
		
	}

	@Override
	public DepartamentoDto insert(DepartamentoDto dto) {
		if(!departamentoDao.findByName(dto.getNombre()).isEmpty()) {
			throw new GetronicsDaoException("departamento.already.exists");
		}
		Departamento entity = departamentoConverter.map(dto);
		dto= departamentoConverter.convert(departamentoDao.insert(entity));
		return dto;
	}

	@Override
	public void remove(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void remove(Long id) {
		departamentoDao.remove(id);
	}

	@Override
	public List<DepartamentoDto> findByExample(DepartamentoDto example) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public List<EmpleadoDto> T3findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateT3(EmpleadoDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpleadoDto insertT3(EmpleadoDto entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Long> convertToListId(Set<DepartamentoDto> source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DepartamentoDto> mapToListId(Set<Long> dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoDto nuevoEmpleDepartamento(EmpleadoDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoDto eliminarEmpleDepartamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoDto nuevaTecnoDepartamento(TecnologiaDto entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
