package es.getronics.services;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.exceptions.DepartamentoExistenteException;
import es.getronics.bom.Tecnologias;

public interface DepartamentoService extends GenericService<DepartamentoDto, Departamento, Long> {

	boolean findByName(DepartamentoDto example);

	boolean primerDepartamento(DepartamentoDto departamentoDto);

	boolean empleadoAsignado(DepartamentoDto dto);

	void validarDepartamento(DepartamentoDto departamento) throws DepartamentoExistenteException;
	
	List<Tecnologias> obtenerTecnologias(Long [] ids);
	
	List<Tecnologias> recogerTecnologiasRelacionadas(Long id);

	void borrarTecnologia(Long idTecnologia, Long idDepartamento);
}
