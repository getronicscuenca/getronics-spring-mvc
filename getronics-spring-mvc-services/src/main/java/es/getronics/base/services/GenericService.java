package es.getronics.base.services;

import java.io.Serializable;
import java.util.List;

import es.getronics.dto.EmpleadoDto;


/**
 * Define los metodos genericos de un servicio de negocio
 * @author jgarcia
 *
 * @param <T> DTO del servicio
 */
public interface GenericService<T1, T2, ID extends Serializable> {

	/**
     * Buscar un instancia de T en el BBDD por su ID.
     *  
     * @param id el identificador del objeto en el BBDD. 
     * @return el objeto o null si no existe. 
     */
    T1 findById(ID id);

    /**
     * Devolver una lista de todos los objetos de tipo T
     * en el BBDD. 
     * 
     * @return una lista de objetos de tipo T.  
     */
    List<T1> findAll();
    
    /**
     * Devolver una lista ordenada de todos los objetos de tipo T
     * en el BBDD.
     *
     * @param orderBy campos por los que ordenaremos
     * @param asc the asc
     * @return una lista de objetos de tipo T.
     */
    List<T1> findAllOrderBy(String[] orderBy, boolean asc);

    /**
     * Hace un update de la entidad.
     * 
     * @param entity el entity a actualizar
     */
    void update(T1 entity);
    
    /**
     * Hace un update de la entidad si ya existe o un save si no existe.
     * 
     * @param entity el entity a actualizar
     */
    void saveOrUpdate(T1 entity);

    /**
     * Insertar una nueva instancia de T en el BBDD. 
     * 
     * @param entity el entity de insertar
     * @return 
     * @return el entity nuevo. 
     */
    
    T1 insert(T1 entity);

    /**
     * Borrar una instancia del BBDD.  
     * 
     * @param entity el entity de borrar. 
     */
    void remove(T1 entity);
    /**
     * Borrar una instancia del BBDD.  
     * 
     * @param id de la entidad a borrar. 
     */
    void remove(ID id);
    /**
     * Obtiene todas las entidades almacenadas en la base de datos para el ejemplo suministrado.
     *
     * @param example El objeto de ejemplo
     * @return El listado de todos los elementos
     */
	List<T1> findByExample(T1 example);


	
}
