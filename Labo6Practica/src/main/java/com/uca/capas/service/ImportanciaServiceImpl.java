package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService {

	@Autowired
	private ImportanciaDAO importanciaDAO;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		return importanciaDAO.findAll();
	}


	@Override
	public Importancia findOne(Integer code) throws DataAccessException {
		return importanciaDAO.findOne(code);
	}


	@Override
	public void save(Importancia importancia) throws DataAccessException {
		importanciaDAO.save(importancia);		
	}


	@Override
	public void delete(Integer codigoImportancia) throws DataAccessException {
		importanciaDAO.delete(codigoImportancia);		
	}
}
