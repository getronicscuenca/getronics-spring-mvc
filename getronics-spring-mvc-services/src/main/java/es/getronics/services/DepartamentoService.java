package es.getronics.services;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.exceptions.DepartamentoExistenteException;
import es.getronics.exceptions.EmpleadosExistentes;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, Long> {

	boolean findByName(DepartamentoDto example);
	
	void comprobarEmpleados(Long idDepart) throws EmpleadosExistentes;
	
	void comprobarNombreDepartamento(String nombre) throws DepartamentoExistenteException ;
	
}
