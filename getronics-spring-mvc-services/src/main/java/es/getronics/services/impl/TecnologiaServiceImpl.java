package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionDepartamento;
import es.getronics.exceptions.ExcepcionEmpleado;
import es.getronics.exceptions.ExcepcionTecnologia;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;
import es.getronics.services.TecnologiaService;

@Service("tecnologiaService")
public class TecnologiaServiceImpl implements TecnologiaService{
	
	@Autowired
	DepartamentoDao departamentoDao;
	
	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	TecnologiaDao tecnologiaDao;
		
	@Autowired
	private ModelMapper modelMapper;
	
	/*@Autowired
	private Converter<Empleado, EmpleadoDto> empleadoConverter;*/
	
	/*@Autowired
	private Converter<Departamento, DepartamentoDto> departamentoConverter;*/
	
	public TecnologiaServiceImpl()
	{
		super();
	}
	
	@Override
	public List<Departamento> findAllT3(TecnologiaDto tipo1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public TecnologiaDto findById(Long id) {
		Tecnologia entity = tecnologiaDao.findById(id);
		return modelMapper.map(entity, TecnologiaDto.class);
		
	}

	@Override
	public List<TecnologiaDto> findAll() {
		List<TecnologiaDto> result = new ArrayList<>();
		List<Tecnologia> found= tecnologiaDao.findAll();
		for(Tecnologia tecnologia: found)
		{
			result.add(modelMapper.map(tecnologia, TecnologiaDto.class));
		}
		return result;
	}
	
	
	/*@Override
	public List<TecnologiaDto> findAllT3(TecnologiaDto tecnologiaDto) {
		List<TecnologiaDto> result = new ArrayList<>();
		Tecnologia Tecnologia=modelMapper.map(TecnologiaDto, Tecnologia.class);
		//List<Departamento> found= departamentoDao.findAll();
		for(Empleado empleado: departamento.getEmpleados())
		{
			result.add(modelMapper.map(empleado, EmpleadoDto.class));
		}
		return result;
	}*/

	@Override
	public List<TecnologiaDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void update(TecnologiaDto dto) {
		Tecnologia entity = modelMapper.map(dto, Tecnologia.class);
		tecnologiaDao.update(entity);
		
	}

	@Override
	public void saveOrUpdate(TecnologiaDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
		
	}
	
	@Override
	public TecnologiaDto insert(TecnologiaDto dto) throws ExcepcionTecnologia {
		Tecnologia entity = modelMapper.map(dto, Tecnologia.class);
						
		Boolean tecnologiaExiste=false;
				
		for(Tecnologia tecnologia:tecnologiaDao.findAll()) {
			if(tecnologia.getNombre().equals(dto.getNombre())) {
				tecnologiaExiste=true;
			}
		}
		if(tecnologiaExiste) {
			throw new ExcepcionTecnologia("La tecnologia ya existe");
		}
		else { 
				
					dto= modelMapper.map(tecnologiaDao.insert(entity), TecnologiaDto.class);
					//dto = departamentoConverter.convert(departamentoDao.insert(entity));
					
				}
		return dto;
	}
	
		
	//INSERTAR UN NUEVO DEPARTAMENTO EN UNA TECNOLOGIA
	public TecnologiaDto nuevoDeparTecnologia(DepartamentoDto dto) {
		throw new NotYetImplementedException("metodo no implementado todavia");
		
	}
	//QUITAR UN DEPARTAMENTO DE UNA TECNOLOGIA
	public DepartamentoDto eliminarDeparTecnologia(Long id) {
		throw new NotYetImplementedException("metodo no implementado todavia");
		
	}
	
	@Override
	public TecnologiaDto nuevoEmpleDepartamento(Departamento entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TecnologiaDto eliminarEmpleDepartamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(TecnologiaDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void remove(Long id) throws ExcepcionTecnologia {
		TecnologiaDto dto = modelMapper.map(tecnologiaDao.findById(id), TecnologiaDto.class);
		if (!dto.getDepartamentos().isEmpty()){
			throw new ExcepcionTecnologia("No se puede eliminar la tecnología porque tiene departamentos");
		}
		else {
			tecnologiaDao.remove(id);
		}
		
	}

	@Override
	public List<TecnologiaDto> findByExample(TecnologiaDto example) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}
	
	/*@Override
	public String findByName(TecnologiaDto tecnologia){
		List<Tecnologia> lista =tecnologiaDao.findAll();
		for(Tecnologia tec:lista) {
			if(tec.getNombre().equals(tecnologia.getNombre())) {
				return tec.getNombre();
			}
		}
		return "";
		
	}*/
	
}
