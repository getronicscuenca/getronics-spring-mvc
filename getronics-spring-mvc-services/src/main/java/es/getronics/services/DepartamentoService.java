package es.getronics.services;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologias;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiasDto;
import es.getronics.exceptions.DepartamentoExistenteException;
import es.getronics.exceptions.EmpleadosExistentes;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, Long> {

	boolean findByName(DepartamentoDto example);
	
	void comprobarEmpleados(Long idDepart) throws EmpleadosExistentes;
	
	void comprobarNombreDepartamento(String nombre) throws DepartamentoExistenteException;

	List<Tecnologias> obtenerTecnologiasDepartamento(Long id);
	
	void eliminarTecnologia(Long idTecnologia, Long idDepartamento);
	
	List<TecnologiasDto> obtenerTecnologiasCheckbox(Long idDepartamento);
	
}
