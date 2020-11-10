package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.base.exceptions.DepartamentoExisteException;
import es.getronics.base.exceptions.FechaPasadaException;
import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
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
	private Converter<Tecnologia, TecnologiaDto> tecnologiaConverter;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DepartamentoServiceImpl()
	{
		super();
	}
	
	@Override
	public DepartamentoDto findById(Long id){
		Departamento entity = departamentoDao.findById(id);
		DepartamentoDto dto=modelMapper.map(entity, DepartamentoDto.class);
		Set<Tecnologia> tecnologias =entity.getTecnologias();
		List<TecnologiaDto> result = new ArrayList();
		
		for (Tecnologia tecnologia : tecnologias) {
			result.add(tecnologiaConverter.convert(tecnologia));
		}
		dto.setTecnologias(result);
		
		return dto;
		
		
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
	public void updateDepartamento(DepartamentoDto dto) throws FechaPasadaException {
		Date alta=dto.getAlta();
		Date ayer=new Date();
		ayer.setDate(ayer.getDate()-1);
		ayer.setHours(23);
		ayer.setMinutes(59);
		if(alta!=null)
		{
			if(alta.before(ayer))
			{
				throw new FechaPasadaException("La fecha no puede Ser de ayer");
			}
		}
		this.update(dto);
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
	
	@Override
	public DepartamentoDto insertDepartamento(DepartamentoDto dto) throws DepartamentoExisteException {
		List<DepartamentoDto> departamentos=this.findAll();
		if(departamentos.contains(dto))
		{
			throw new DepartamentoExisteException("ya existe un departamento con ese nombre");
		}
			return insert(dto);
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

	@Override
	public void update(DepartamentoDto dto) {
		Departamento entity = departamentoConverter.map(dto);
		departamentoDao.update(entity);
		
	}

	
	
	
	
}
