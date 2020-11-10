package es.getronics.services;

import es.getronics.base.exceptions.TecnologiaExisteException;
import es.getronics.base.services.GenericService;
import es.getronics.bom.Tecnologia;
import es.getronics.dto.TecnologiaDto;

public interface TecnologiaService extends GenericService<TecnologiaDto, Tecnologia, Long> {

	
	public TecnologiaDto insertarTecnologia(TecnologiaDto dto) throws TecnologiaExisteException;
}
