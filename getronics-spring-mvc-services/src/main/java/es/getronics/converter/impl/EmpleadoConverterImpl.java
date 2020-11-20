/**
 * 
 */
package es.getronics.converter.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Empleado;
import es.getronics.converter.Converter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.KeyValueItem;

/**
 * Convierte de Entidad empleado a Dto
 * 
 * @author jgarcia
 *
 */
@Component("empleadoConverter")
public class EmpleadoConverterImpl implements Converter<Empleado, EmpleadoDto> {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Override
	public EmpleadoDto convert(Empleado source) {
		EmpleadoDto result = new EmpleadoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		
		if(source.getFechaAlta() != null) {
			result.setFechaAlta(Date.from(source.getFechaAlta().atStartOfDay().toInstant(ZoneOffset.UTC)));
		}
		if(source.getFechaModificacion() != null) {
			result.setFechaModificacion(Date.from(source.getFechaModificacion().atStartOfDay().toInstant(ZoneOffset.UTC)));
		}
		if(source.getFechaBaja() != null) {
			result.setFechaBaja(Date.from(source.getFechaBaja().atStartOfDay().toInstant(ZoneOffset.UTC)));
		}
		
		boolean activo = source.getFechaBaja() == null || LocalDate.now().isAfter(source.getFechaBaja());
		result.setActivo(activo);
		
		if(source.getDepartamento() != null) {
			result.setIdDepartamento(source.getDepartamento().getId());
			result.setDepartamento(source.getDepartamento().getNombre());
		}
		
		return result;
	}

	@Override
	public Empleado map(EmpleadoDto dto) {
		Empleado result = new Empleado();
		result.setId(dto.getId());
		result.setNombre(dto.getNombre());
		result.setApellido1(dto.getApellido1());
		result.setApellido2(dto.getApellido2());
		if(dto.getFechaAlta() != null) {
			result.setFechaAlta(Instant.ofEpochMilli(dto.getFechaAlta().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		}
		if(dto.getFechaModificacion() != null) {
			result.setFechaModificacion(Instant.ofEpochMilli(dto.getFechaModificacion().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		}
		if(dto.getFechaBaja() != null) {
			result.setFechaBaja(Instant.ofEpochMilli(dto.getFechaBaja().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		}
		if(dto.getIdDepartamento() != null) {
			result.setDepartamento(departamentoDao.findById(dto.getIdDepartamento()));
		}
		return result;
	}

	@Override
	public KeyValueItem mapToKeyValue(Empleado source) {
		// TODO Auto-generated method stub
		return null;
	}
}
