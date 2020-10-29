package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.base.exceptions.FechaPasadaException;
import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.services.DepartamentoService;


@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService{

	
	@Autowired
	private DepartamentoDao departamentoDao;
	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Autowired
	private Converter<Departamento, DepartamentoDto> departamentoConverter;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DepartamentoServiceImpl()
	{
		super();
	}
	
	@Override
	public DepartamentoDto findById(Long id){
		Departamento entity = departamentoDao.findById(id);
		return modelMapper.map(entity, DepartamentoDto.class);
		
	}
	

	@Override
	public List<DepartamentoDto> findAll() {
		List<DepartamentoDto> result = new ArrayList<>();
		List<Departamento> found= departamentoDao.findAll();
		for(Departamento departamento: found)
		{
			result.add(modelMapper.map(departamento, DepartamentoDto.class));
		}
		return result;
	}

	@Override
	public List<DepartamentoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void update(DepartamentoDto dto) throws FechaPasadaException {
		Date alta=dto.getAlta();
		Date ayer=new Date();
		ayer.setDate(ayer.getDate()-1);
		ayer.setHours(23);
		if(alta!=null)
		{
			if(alta.before(ayer))
			{
				throw new FechaPasadaException("La fecha no puede Ser de ayer");
			}
		}
		Departamento entity = departamentoConverter.map(dto);
		departamentoDao.update(entity);
	}

	@Override
	public void saveOrUpdate(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
		
	}

	@Override
	public DepartamentoDto insert(DepartamentoDto dto) {
		Departamento entity = departamentoConverter.map(dto);
		dto= modelMapper.map(departamentoDao.insert(entity), DepartamentoDto.class);
		return dto;
	}
	public DepartamentoDto link(Long did,Long eid)
	{
		 
		
		Departamento departamentoEntity= departamentoDao.findById(did);
		Empleado empleadoEntity =empleadoDao.findById(eid);
		departamentoEntity.setJefe(empleadoEntity);
		departamentoDao.update(departamentoEntity);
		return modelMapper.map(empleadoEntity,DepartamentoDto.class);
		
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
	
	
	
}
