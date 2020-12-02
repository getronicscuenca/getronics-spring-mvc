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
import es.getronics.exceptions.ExcepcionDepartamento;
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
	public DepartamentoDto insert(DepartamentoDto dto) throws ExcepcionDepartamento{
		//if(!departamentoDao.findByName(dto.getNombre()).isEmpty()) {
		//	throw new GetronicsDaoException("departamento.already.exists");
		//}
		Departamento entity = departamentoConverter.map(dto);
		
		Boolean departamentoExiste=false;
		
		for(Departamento departamento:departamentoDao.findAll()) {
			if(departamento.getNombre().equals(dto.getNombre())) {
				departamentoExiste=true;
			}
		}
		if(departamentoExiste) {
			throw new ExcepcionDepartamento("El departamento ya existe");
		}
		else  
			/*if(dto.getJefe()==null) {
				throw new ExcepcionDepartamento("El departamento tiene que tener un jefe");
			}
			else*/
				if (dto.getSelectedTecnologias()==null){
					throw new ExcepcionDepartamento("El departamento tiene que tener al menos una tecnologia");
				}
				else {
		
				dto= departamentoConverter.convert(departamentoDao.insert(entity));
				}
		
		return dto;
	}

	@Override
	public void remove(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void remove(Long id) throws ExcepcionDepartamento {
		DepartamentoDto dto = departamentoConverter.convert(departamentoDao.findById(id));
		if (!dto.getEmpleados().isEmpty()){
		throw new ExcepcionDepartamento("No se puede eliminar el departamento porque tiene empleados");
		}
		else {
			departamentoDao.remove(id);
		}
		
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

	@Override
	public String findByName(DepartamentoDto departamento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
