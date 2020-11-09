package es.getronics.services;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.exceptions.ExcepcionDepartamento;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, EmpleadoDto, Long> {
	String findByName(DepartamentoDto departamento);
	DepartamentoDto insert(DepartamentoDto dto) throws ExcepcionDepartamento;
	void remove(Long id) throws ExcepcionDepartamento;
}
