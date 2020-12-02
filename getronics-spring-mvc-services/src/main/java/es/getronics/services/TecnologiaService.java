package es.getronics.services;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Tecnologia;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionTecnologia;

/**
 * Define las operaciones de negocio de alumnos
 * 
 * @author jgarcia
 */
public interface TecnologiaService extends GenericService<TecnologiaDto, Tecnologia, DepartamentoDto, EmpleadoDto, Long> {
	TecnologiaDto insert(TecnologiaDto dto) throws ExcepcionTecnologia;
	void remove(Long id) throws ExcepcionTecnologia;
	List<KeyValueItem> findAllAsItems();
}
