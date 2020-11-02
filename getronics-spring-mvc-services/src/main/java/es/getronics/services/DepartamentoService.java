package es.getronics.services;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.exceptions.DepartamentoExistenteException;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, Long> {

	boolean findByName(DepartamentoDto example);
	boolean primerDepartamento(DepartamentoDto example);
	boolean empleadoAsignado(DepartamentoDto dto);
	void validarDepartamento(DepartamentoDto dto) throws DepartamentoExistenteException;
	
}
