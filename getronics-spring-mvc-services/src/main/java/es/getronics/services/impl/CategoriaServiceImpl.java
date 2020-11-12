/**
 * @file CategoriaServiceImpl.java
 * @date 11 nov. 2020
 * @time 13:16:13
 * 
 */
package es.getronics.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import es.getronics.base.exceptions.TecnologiaExisteException;
import es.getronics.bom.Categoria;
import es.getronics.dao.CategoriaDao;
import es.getronics.dto.CategoriaDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.services.CategoriaService;


/**
 * @author alatorre
 *
 * 
 */
public class CategoriaServiceImpl implements CategoriaService {
	
	
	@Autowired
	private CategoriaDao categoriaDao;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CategoriaDto findById(Long id) {
		Categoria entity = categoriaDao.findById(id);
		return modelMapper.map(entity, CategoriaDto.class);
	}
	@Override
	public List<CategoriaDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CategoriaDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(CategoriaDto entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saveOrUpdate(CategoriaDto entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public CategoriaDto insert(CategoriaDto entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void remove(CategoriaDto entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<CategoriaDto> findByExample(CategoriaDto example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CategoriaDto> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
