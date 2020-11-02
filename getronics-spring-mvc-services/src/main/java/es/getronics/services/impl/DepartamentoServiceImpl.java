package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Departamento;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.services.DepartamentoService;

@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoDao departamentoDao;

	@Autowired
	private ModelMapper modelMapper;

	public DepartamentoServiceImpl() {
		super();
	}

	@Override
	public DepartamentoDto findById(Long id) {
		Departamento entity = departamentoDao.findById(id);
		return modelMapper.map(entity, DepartamentoDto.class);

	}

	@Override
	public List<DepartamentoDto> findAll() {
		List<DepartamentoDto> result = new ArrayList<>();
		List<Departamento> found = departamentoDao.findAll();
		for (Departamento departamento : found) {
			result.add(modelMapper.map(departamento, DepartamentoDto.class));
		}
		return result;
	}

	@Override
	public List<DepartamentoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void update(DepartamentoDto dto) {
		Departamento entity = modelMapper.map(dto, Departamento.class);
		departamentoDao.update(entity);

	}

	@Override
	public void saveOrUpdate(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");

	}

	@Override
	public DepartamentoDto insert(DepartamentoDto dto) {
		Departamento entity = modelMapper.map(dto, Departamento.class);
		dto = modelMapper.map(departamentoDao.insert(entity), DepartamentoDto.class);
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
	public boolean findByName(DepartamentoDto departamentoDto) {
		Departamento example = new Departamento();
		example.setNombre(departamentoDto.getNombre());
		List<Departamento> entity = departamentoDao.findByExample(example);
		return entity != null;
	}

}
