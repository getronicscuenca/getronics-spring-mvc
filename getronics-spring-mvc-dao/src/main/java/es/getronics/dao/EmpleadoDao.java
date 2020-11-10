/**
 * 
 */
package es.getronics.dao;

import org.springframework.stereotype.Component;

import es.getronics.base.dao.GenericDao;
import es.getronics.bom.Empleado;

/**
 * Define los metodos propios de acceso a datos a la tabla empleado
 * 
 * @author jgarcia
 *
 */

public interface EmpleadoDao extends GenericDao<Empleado, Long> {

}
