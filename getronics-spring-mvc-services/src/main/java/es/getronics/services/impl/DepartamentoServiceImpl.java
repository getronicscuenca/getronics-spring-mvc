package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.converter.EmpleadoConverter;
import es.getronics.converter.impl.DepartamentoConverterImpl;
import es.getronics.converter.impl.EmpleadoConverterImpl;
//import es.getronics.converter.DepartamentoConverterImpl;
//import es.getronics.converter.EmpleadoConverterImpl;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.DepartamentoListItemDTO;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.services.DepartamentoService;
import es.getronics.exceptions.ExcepcionDepartamento;

@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService{

	
	@Autowired
	DepartamentoDao departamentoDao;
	
	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	TecnologiaDao tecnologiaDao;
		
	@Autowired
	private ModelMapper modelMapper;
	
	//@Autowired
	//private Converter<Empleado, EmpleadoDto> empleadoConverter;
	
	@Autowired
	private DepartamentoConverter<Departamento, DepartamentoDto> departamentoConverter;
	
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
			result.add(departamentoConverter.convertToList(departamento));
		}
		return result;
	}
	
	
		
	
	/*@Override
	public List<DepartamentoListItemDTO> findAllT3(DepartamentoDto departamentoDto) {
		/*List<DepartamentoListItemDTO> result = new ArrayList<DepartamentoListItemDTO>();
		Departamento departamento=modelMapper.map(departamentoDto, Departamento.class);
		//List<Departamento> found= departamentoDao.findAll();
		for(Empleado empleado: departamento.getEmpleados())
		{
			result.add(modelMapper.map(empleado, EmpleadoDto.class));
		}
		return null;
	}*/

	/*@Override
	public List<DepartamentoListItemDTO> T3findAll() {
		List<DepartamentoListItemDTO> result = new ArrayList<>();
		/*List<Departamento> found= departamentoDao.findAll();
		for(Departamento departamento: found)
		{
			result.add(departamentoConverter.convertToList(departamento));
		}
		return result;
	}*/

	@Override
	public List<DepartamentoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void update(DepartamentoDto dto) {
		Departamento entity = modelMapper.map(dto, Departamento.class);
		departamentoDao.update(entity);
		
	}
	

	/*@Override
	public void updateT3(DepartamentoListItemDTO dto) {
		Departamento entity = modelMapper.map(dto, Departamento.class);
		//Departamento entity = departamentoConverter.mapToList(dto);
		departamentoDao.update(entity);
	}*/

	@Override
	public void saveOrUpdate(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
		
	}
	
	@Override
	public DepartamentoDto insert(DepartamentoDto dto) throws ExcepcionDepartamento {
		//Departamento entity = modelMapper.map(dto, Departamento.class);
		//Departamento entity = departamentoConverter.map(dto);
		
		Departamento entity = departamentoConverter.mapToList(dto);
				
		Boolean departamentoExiste=false;
				
		for(Departamento departamento:departamentoDao.findAll()) {
			if(departamento.getNombre().equals(dto.getNombre())) {
				departamentoExiste=true;
			}
		}
		if(departamentoExiste) {
			throw new ExcepcionDepartamento("El departamento ya existe");
		}
		else { 
			/*if(dto.getJefe()==null) {
				throw new ExcepcionDepartamento("El departamento tiene que tener un jefe");
			}
			else
				if (entity.getEmpleados()==null){
					throw new ExcepcionDepartamento("El departamento tiene que tener al menos un empleado");
				}
				else {*/
			
					//dto= modelMapper.map(departamentoDao.insert(entity), DepartamentoDto.class);
					//dto = departamentoConverter.convert(departamentoDao.insert(entity));
					dto= departamentoConverter.convertToList(departamentoDao.insert(entity));
					
				}
		return dto;
	}
	
	
	/*@Override
	public DepartamentoListItemDTO insertT3(DepartamentoListItemDTO dto) throws ExcepcionDepartamento {
		//Departamento entity = modelMapper.map(dto, Departamento.class);
		//Departamento entity = departamentoConverter.map(dto);
		
		//Departamento entity = departamentoConverter.mapToList(dto);
				
		Boolean departamentoExiste=false;
				
		for(Departamento departamento:departamentoDao.findAll()) {
			if(departamento.getNombre().equals(dto.getNombre())) {
				departamentoExiste=true;
			}
		}
		if(departamentoExiste) {
			throw new ExcepcionDepartamento("El departamento ya existe");
		}
		else { 
			/*if(dto.getJefe()==null) {
				throw new ExcepcionDepartamento("El departamento tiene que tener un jefe");
			}
			else
				if (entity.getEmpleados()==null){
					throw new ExcepcionDepartamento("El departamento tiene que tener al menos un empleado");
				}
				else {
			
					//dto= modelMapper.map(departamentoDao.insert(entity), DepartamentoDto.class);
					//dto = departamentoConverter.convert(departamentoDao.insert(entity));
					//dto= departamentoConverter.convertToList(entity);
					
				}
		return dto;
	}*/
	

	//METODO OVERRIDE
	/*public DepartamentoDto nuevoEmpleDepartamento(EmpleadoDto dto) {
		DepartamentoDto departamento=null;
		return departamento;
	}
	//METODO OVERRIDE
	public DepartamentoDto eliminarEmpleDepartamento(Long id) {
		DepartamentoDto departamento=null;
		return departamento;
	}*/
	
	
	//INSERTAR UN NUEVO EMPLEADO EN UN DEPARTAMENTO
	public DepartamentoDto nuevoEmpleDepartamento(EmpleadoDto dto) {
		Departamento departamento= departamentoDao.findById(dto.getIdDepartamento());
		departamento.getEmpleados().add(modelMapper.map(dto, Empleado.class));
		DepartamentoDto departamentoDto = departamentoConverter.convertToList(departamento);
		return departamentoDto;
	}
	//QUITAR UN EMPLEADO DE UN DEPARTAMENTO
	public DepartamentoDto eliminarEmpleDepartamento(Long id) {
		Empleado empleado= empleadoDao.findById(id);
		Departamento departamento= departamentoDao.findById(empleado.getDepartamento().getId());
		departamento.getEmpleados().remove(empleado);
		DepartamentoDto departamentoDto = departamentoConverter.convertToList(departamento);
		return departamentoDto;
	}
	
	//INSERTAR UNA NUEVA TECNOLOGIA EN UN DEPARTAMENTO
		public DepartamentoDto nuevaTecnoDepartamento(TecnologiaDto dto) {
			DepartamentoDto departamento=null;
			for(DepartamentoDto itemDepartamento:dto.getDepartamentos()) {
				if (this.equals(itemDepartamento)) {
					itemDepartamento.getTecnologias().add(dto);
					departamento=itemDepartamento;
				}
				
			}
			return departamento;
		}
		
		//VERYYYYYYYYYYY IIIIIIIIIIIIIIIIMMMMMMMMMMMMMMPPPPPP  FALTA ESTE MÉTODO
		//QUITAR UNA TECNOLOGIA DE UN DEPARTAMENTO
		/*public DepartamentoDto eliminarTecnoDepartamento(Long id) {
			Tecnologia tecnologia= tecnologiaDao.findById(id);
			Departamento departamento= departamentoDao.findById(tecnologia.getDepartamento().getId());
			departamento.getTecnologias().remove(tecnologia);
			DepartamentoDto departamentoDto = departamentoConverter.convertToList(departamento);
			return departamentoDto;
		}*/

	@Override
	public void remove(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void remove(Long id) throws ExcepcionDepartamento {
		DepartamentoDto dto = modelMapper.map(departamentoDao.findById(id), DepartamentoDto.class);
		/*if (!dto.getEmpleados().isEmpty()){
			throw new ExcepcionDepartamento("No se puede eliminar el departamento porque tiene empleados");
		}
		else {
		departamentoDao.remove(id);
		}*/
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
	public String findByName(DepartamentoDto departamento) {
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
	
	/*@Override
	public String findByName(DepartamentoDto departamento){
		List<Departamento> lista =departamentoDao.findAll();
		for(Departamento dep:lista) {
			if(dep.getNombre().equals(departamento.getNombre())) {
				return dep.getNombre();
			}
		}
		return "";
		
	}*/
	
	
	
	
}
