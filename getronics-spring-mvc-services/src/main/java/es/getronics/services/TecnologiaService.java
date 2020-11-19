package es.getronics.services;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologia;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionTecnologia;


public interface TecnologiaService extends GenericService<TecnologiaDto, Tecnologia, Departamento, TecnologiaDto, Long> {
	//String findByName(EmpleadoDto empleado);
	TecnologiaDto insert(TecnologiaDto dto) throws ExcepcionTecnologia;
	void remove(Long id) throws ExcepcionTecnologia;
	//NUEVO
	List<KeyValueItem> findAllAsItems();
}
