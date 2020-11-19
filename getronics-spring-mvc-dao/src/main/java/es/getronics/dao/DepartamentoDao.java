package es.getronics.dao;

import java.util.List;

import es.getronics.base.dao.GenericDao;
import es.getronics.bom.Departamento;

public interface DepartamentoDao extends GenericDao<Departamento, Long>{
	List<Departamento> findByName(String name);
}
