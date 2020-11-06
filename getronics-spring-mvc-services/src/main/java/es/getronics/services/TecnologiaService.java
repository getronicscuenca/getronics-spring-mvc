/**
 * 
 */
package es.getronics.services;

import java.util.List;

import es.getronics.dto.TecnologiaDTO;

/**
 * @author jgarcia7
 *
 */
public interface TecnologiaService {
	
	List<TecnologiaDTO> findAllTechnologies();

}
