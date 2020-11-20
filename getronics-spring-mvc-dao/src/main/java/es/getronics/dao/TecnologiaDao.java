/**
 * 
 */
package es.getronics.dao;

import java.util.List;

import es.getronics.base.dao.GenericDao;
import es.getronics.bom.Tecnologia;

/**
 * Define los metodos propios de acceso a datos a la tabla empleado
 * 
 * @author jgarcia
 *
 */

public interface TecnologiaDao extends GenericDao<Tecnologia, Long> {

	List<Tecnologia> findByName(String name);
}
