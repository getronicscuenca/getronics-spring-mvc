/**
 * 
 */
package es.getronics.converter.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.list.SetUniqueList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Empleado;
import es.getronics.converter.Converter;
import es.getronics.converter.EmpleadoConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dto.EmpleadoDto;

/**
 * Convierte de Entidad empleado a Dto
 * 
 * @author jgarcia
 *
 */
@Component
public class EmpleadoConverterImpl implements Converter<Empleado, EmpleadoDto>, EmpleadoConverter<Empleado, EmpleadoDto> {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private EmpleadoDao empleadoDao;
		
	@Override
	public EmpleadoDto convert(Empleado source) {
		EmpleadoDto result = new EmpleadoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		if(source.getDepartamento() != null) {
			result.setIdDepartamento(source.getDepartamento().getId());
			result.setDepartamento(source.getDepartamento().getNombre());
		}
		//result.setJefe(source.getJefe().getId());
		
		return result;
	}

	@Override
	public Empleado map(EmpleadoDto dto) {
		Empleado result = new Empleado();
		result.setId(dto.getId());
		result.setNombre(dto.getNombre());
		result.setApellido1(dto.getApellido1());
		result.setApellido2(dto.getApellido2());
		if(dto.getIdDepartamento() != null) {
			result.setDepartamento(departamentoDao.findById(dto.getIdDepartamento()));
		}
		//NUEVO
		//if(dto.getJefe() != null) {
		//	result.setJefe(empleadoDao.findById(dto.getJefe()));
		//}
		
		return result;
	}

	@Override
	public Set<EmpleadoDto> convertToListSet(Set<Empleado> source) {
		Set<EmpleadoDto> listaEmpleados = new HashSet<EmpleadoDto>();
		for(Empleado empleado:source) {
			listaEmpleados.add(this.convert(empleado));
		}
		return listaEmpleados;
	}

	@Override
	public Set<Empleado> mapToListSet(Set<EmpleadoDto> dto) {
		Set<Empleado> listaEmpleados = new HashSet<Empleado>();
		for(EmpleadoDto empleado:dto) {
			listaEmpleados.add(this.map(empleado));
		}
		return listaEmpleados;
	}

	@Override
	public EmpleadoDto convertToList(Empleado source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado mapToList(EmpleadoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

