package es.getronics.services;

import java.util.List;

import es.getronics.base.exceptions.TecnologiaExisteException;
import es.getronics.base.services.GenericService;
import es.getronics.bom.Tecnologia;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;

public interface TecnologiaService extends GenericService<TecnologiaDto, Tecnologia, Long> {

	
	public TecnologiaDto insertarTecnologia(TecnologiaDto dto) throws TecnologiaExisteException;
	List<KeyValueItem> findAllAsItems();
}
