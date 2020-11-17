/**
 * 
 */
package es.getronics.services;

import java.util.List;

import es.getronics.bom.Tecnologia;
import es.getronics.dto.TecnologiaDTO;

/**
 * @author jgarcia7
 *
 */
public interface TecnologiaService {
	
	List<TecnologiaDTO> findAllTechnologies();
	TecnologiaDTO insert(TecnologiaDTO dto);
	TecnologiaDTO findById(Long id);
	TecnologiaDTO update(TecnologiaDTO dto);

}
