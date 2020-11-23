/**
 * @file EmpleadoConverterImpl.java
 * @date 19 nov. 2020
 * @time 13:52:34
 * 
 */
package es.getronics.converter.impl;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.stereotype.Component;

import es.getronics.bom.Empleado;
import es.getronics.converter.Converter;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.KeyValueItem;

/**
 * @author alatorre
 *
 * 
 */
@Component("empleadoConverter")
public class EmpleadoConverterImpl implements Converter<Empleado, EmpleadoDto> {

	@Override
	public EmpleadoDto convert(Empleado source) {
		EmpleadoDto result = new EmpleadoDto();
		//empleado
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		if(source.getFechaAlta() != null)
		{
			result.setFechaAlta(Date.from(source.getFechaAlta().atStartOfDay().toInstant(ZoneOffset.UTC)));
		}
		if(source.getFechaBaja() != null)
		{
			result.setFechaBaja(Date.from(source.getFechaBaja().atStartOfDay().toInstant(ZoneOffset.UTC)));
		}
		
		if(source.getFechaModificacion() != null)
		{
			result.setFechaModificacion(Date.from(source.getFechaModificacion().atStartOfDay().toInstant(ZoneOffset.UTC)));
		}
		//departamento->empleado
		if(source.getDepartamento() != null)
		{
			result.setIdDepartamento(source.getDepartamento().getId());
			result.setDepartamento(source.getDepartamento().getNombre());
		}
		//devolvemos
		return result;
	}

	@Override
	public Empleado map(EmpleadoDto source) {
		Empleado result = new Empleado();
		//empleado
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		if(source.getFechaAlta() != null)
		{
			result.setFechaAlta(Instant.ofEpochMilli(source.getFechaAlta().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		}
		if(source.getFechaBaja() != null)
		{
			result.setFechaBaja(Instant.ofEpochMilli(source.getFechaBaja().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		}
		if(source.getFechaModificacion() != null)
		{
			result.setFechaModificacion(Instant.ofEpochMilli(source.getFechaModificacion().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		}
		//devolvemos
		return result;
	}

	@Override
	public KeyValueItem mapToKeyValue(Empleado source) {
		// TODO Auto-generated method stub
		return null;
	}

}
