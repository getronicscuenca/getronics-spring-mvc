package es.getronics.base.services;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionDepartamento;


/**
 * Define los metodos genericos de un servicio de negocio
 * @author jgarcia
 *
 * @param <T> DTO del servicio
 */
public interface GenericService<T1, T2, T3, T4, ID extends Serializable> {

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
    
    List<T3> T3findAll();
    
    //List<T3> findAllT3(T1 tipo1);
    
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
    
    void updateT3(T3 entity);
    
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
     * @return el entity nuevo. 
     */
    T1 insert(T1 entity) throws Exception;
    
    T3 insertT3(T3 entity) throws Exception;
    
    Set<Long> convertToListId(Set<T1> source);
    
    Set<T1> mapToListId(Set<Long> dto);

    //AÑADIR UN NUEVO EMPLEADO EN UN DEPARTAMENTO
    T1 nuevoEmpleDepartamento(T3 entity);
    
    
    //ELIMINAR UN EMPLEADO DE UN DEPARTAMENTO POR SU ID
    T1 eliminarEmpleDepartamento(Long id);
    
  //AÑADIR UNA NUEVA TECNOLOGIA EN UN DEPARTAMENTO
    T1 nuevaTecnoDepartamento(T4 entity);
    
    
    //ELIMINAR UNA TECNOLOGIA DE UN DEPARTAMENTO POR SU ID
    //T1 eliminarEmpleDepartamento(Long id);
    
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
    void remove(ID id) throws Exception;
    /**
     * Obtiene todas las entidades almacenadas en la base de datos para el ejemplo suministrado.
     *
     * @param example El objeto de ejemplo
     * @return El listado de todos los elementos
     */
	List<T1> findByExample(T1 example);


	
}
