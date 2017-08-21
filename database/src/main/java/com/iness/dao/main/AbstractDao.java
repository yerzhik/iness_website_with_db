package com.iness.dao.main;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.iness.dao.BaseDAO;
import com.iness.dao.hibernate.HibernateUtil;
import com.iness.model.main.Abstract;

import java.util.List;

public class AbstractDao extends BaseDAO<Abstract, Integer> implements IAbstractDao {

	public AbstractDao() {
		super(Abstract.class);
	}
	
	@Override
	public List<Abstract> getAllAbstracts(){
		EntityManager em = HibernateUtil.currentEntityManager();
		Query query = em.createNamedQuery(Abstract.GET_ALL_ABSTRACTS);
		return query.getResultList();
	}

	@Override
	public List<Abstract> getAbstractsByType(boolean isOral) {
		EntityManager em = HibernateUtil.currentEntityManager();
		Query query = em.createNamedQuery(Abstract.GET_ALL_ABSTRACTS_BY_TYPE);
		query.setParameter("value", isOral);
		return query.getResultList();
	}
}
