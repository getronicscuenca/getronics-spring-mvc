package es.getronics.dao;

import java.util.List;

import es.getronics.bom.Tecnologia;

public interface TecnologiaDao {

	List<Tecnologia> findAll();
	Tecnologia insert(Tecnologia entity);
}
