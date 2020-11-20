package es.getronics.services;

import es.getronics.bom.Tecnologias;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiasDto;

public interface TecnologiasService extends GenericService<TecnologiasDto, Tecnologias, Long> {

	List<KeyValueItem> obtenerItemsTecnologia();
}
