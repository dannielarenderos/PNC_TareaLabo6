package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

	@Autowired
	private ContribuyenteDAO contribuyenteDAO;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}


	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		return contribuyenteDAO.findOne(code);
	}


	@Override
	public void save(Contribuyente contribuyente) throws DataAccessException {
		contribuyente.setF_fecha_ingreso(new Date());
		contribuyenteDAO.save(contribuyente);		
	}


	@Override
	public void delete(Integer codigoContribuyente) throws DataAccessException {
		contribuyenteDAO.delete(codigoContribuyente);		
	}
}
