package es.getronics.dao;

import java.util.List;

import es.getronics.base.dao.GenericDao;
import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologias;

public interface TecnologiasDao extends GenericDao<Tecnologias, Long> {

	List<Tecnologias> findByName(String name);
}
