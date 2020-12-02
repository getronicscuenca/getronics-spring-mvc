package es.getronics.services;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionDepartamento;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, EmpleadoDto, TecnologiaDto, Long> {
	String findByName(DepartamentoDto departamento);
	DepartamentoDto insert(DepartamentoDto dto) throws ExcepcionDepartamento;
	List<DepartamentoDto> findAll();
	void remove(Long id) throws ExcepcionDepartamento;
}
