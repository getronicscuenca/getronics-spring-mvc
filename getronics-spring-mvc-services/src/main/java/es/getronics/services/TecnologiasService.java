package es.getronics.services;

import es.getronics.bom.Tecnologias;
import es.getronics.base.services.GenericService;
import es.getronics.dto.TecnologiasDto;
import es.getronics.exceptions.TecnologiasException;

public interface TecnologiasService extends GenericService<TecnologiasDto, Tecnologias, Long> {

	void validarTecnologias(TecnologiasDto tecnologias) throws TecnologiasException;
}
