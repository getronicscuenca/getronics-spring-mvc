/**
 * @file CategoriaServiceImpl.java
 * @date 11 nov. 2020
 * @time 13:16:13
 * 
 */
package es.getronics.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.getronics.base.exceptions.TecnologiaExisteException;
import es.getronics.bom.Categoria;
import es.getronics.dao.CategoriaDao;
import es.getronics.dto.TecnologiaDto;
import es.getronics.services.TecnologiaService;

/**
 * @author alatorre
 *
 * 
 */
public class CategoriaServiceImpl implements TecnologiaService {
	
	
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public TecnologiaDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TecnologiaDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TecnologiaDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TecnologiaDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(TecnologiaDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TecnologiaDto insert(TecnologiaDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(TecnologiaDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TecnologiaDto> findByExample(TecnologiaDto example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TecnologiaDto insertarTecnologia(TecnologiaDto dto) throws TecnologiaExisteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
