package es.getronics.services;

import es.getronics.base.exceptions.FechaPasadaException;
import es.getronics.base.services.GenericService;

import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, Long> {

	public DepartamentoDto link(Long did,Long eid);
	public void updateDepartamento(DepartamentoDto dto) throws FechaPasadaException;
}