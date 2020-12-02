/**
 * 
 */
package es.getronics.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * Define metodos genericos de los daos
 * 
 * @author smartinez
 *
 */
public interface GenericDao<T, ID extends Serializable> {

	/**
     * Buscar un instancia de T en el BBDD por su ID.
     *  
     * @param id el identificador del objeto en el BBDD. 
     * @return el objeto o null si no existe. 
     */
    T findById(ID id);

    /**
     * Devolver una lista de todos los objetos de tipo T
     * en el BBDD. 
     * 
     * @return una lista de objetos de tipo T.  
     */
    List<T> findAll();
    
    /**
     * Devolver una lista de todos los objetos de tipo T
     * en el BBDD. 
     * 
     * @return una lista de objetos de tipo T.  
     */
    List<T> findByCriteria(DetachedCriteria criteria);
    
    /**
     * Devolver una lista ordenada de todos los objetos de tipo T
     * en el BBDD. 
     * 
     * @param orderBy campos por los que ordenaremos
     * @return una lista de objetos de tipo T.  
     */
    List<T> findAllOrderBy(String[] orderBy, boolean asc);

    /**
     * Hacer un merge (sincronización) entre el entity T y la version de T en el contexto de la sesión actual,
     * realizando los cambios necesarios (update, save) 
     * 
     * @param entity el entity a sincronizar. No se modifica en ningún caso.
     * @return un entity manejado por Hibernate en el contexto de la sesión. 
     */
    T merge(T entity);

    /**
     * Hace un update de la entidad.
     * 
     * @param entity el entity a actualizar
     */
    void update(T entity);

    /**
     * Hace un update de la entidad si ya existe o un save si no existe.
     * 
     * @param entity el entity a actualizar
     */
    void saveOrUpdate(T entity);

    /**
     * Insertar una nueva instancia de T en el BBDD. 
     * 
     * @param entity el entity de insertar
     * @return el entity nuevo. 
     */
    T insert(T entity);

    /**
     * Borrar una instancia del BBDD.  
     * 
     * @param entity el entity de borrar. 
     */
    void remove(T entity);
    /**
     * Borrar una instancia del BBDD.  
     * 
     * @param id el id de la entidad a borrar. 
     */
    void remove(ID id);
    /**
     * Obtiene todas las entidades almacenadas en la base de datos para el ejemplo suministrado.
     *
     * @param example El objeto de ejemplo
     * @return El listado de todos los elementos
     */
	List<T> findByExample(T example);
	
	/**
	 * Refresca el estado del objeto indicado.
	 *
	 * @param entity El objeto a ser refrescado
	 */
	void refresh(T entity);
	
	/**
	 * Do rollback.
	 */
	public void doRollback();
	
	DetachedCriteria createCriteria();
}
