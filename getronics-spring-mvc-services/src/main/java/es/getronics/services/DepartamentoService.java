package es.getronics.services;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologias;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.TecnologiasDto;
import es.getronics.exceptions.DepartamentoExistenteException;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, Long> {

	boolean primerDepartamento(DepartamentoDto departamentoDto);

	boolean empleadoAsignado(DepartamentoDto dto);

	List<DepartamentoDto> findByName(DepartamentoDto dto);

	void validarDepartamento(DepartamentoDto departamento) throws DepartamentoExistenteException;

	List<TecnologiasDto> recogerTecnologiasRelacionadas(Long id);
	
	 List<Departamento> buscarName(DepartamentoDto dto);

	void borrarTecnologia(Long idTecnologia, Long idDepartamento);
}
