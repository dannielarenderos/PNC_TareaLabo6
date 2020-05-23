package com.uca.capas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query =  entityManager.createNativeQuery(sb.toString(),Contribuyente.class);
		List<Contribuyente> resultset = query.getResultList();		
	
		return resultset;

	}
	
	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
	
		Contribuyente contribuyente = entityManager.find(Contribuyente.class, code);
		return contribuyente;
	}
	
	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException{
		try {

			if(contribuyente.getC_contribuyente() == null) {
				entityManager.persist(contribuyente); 
			}
			else {
				entityManager.merge(contribuyente);
				entityManager.flush();
			}
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	@Transactional
	public void delete(Integer codigoContribuyente) throws DataAccessException{
	
	Contribuyente contribuyente = entityManager.find(Contribuyente.class, codigoContribuyente);
	entityManager.remove(contribuyente);
	}
	
}
