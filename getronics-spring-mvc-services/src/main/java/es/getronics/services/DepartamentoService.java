package es.getronics.services;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, EmpleadoDto, TecnologiaDto, Long> {
}
