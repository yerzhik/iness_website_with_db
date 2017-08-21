package com.iness.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.iness.dao.DAOEntityManager;
import com.iness.dao.DAOEntityManagerFactory;

public class HibernateDAOEntityManagerFactory extends DAOEntityManagerFactory {

	private EntityManagerFactory entityManagerFactory;
	
	public HibernateDAOEntityManagerFactory(){
		this.entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    }	
	
	public EntityManagerFactory getEntityManagerFactory(){
		if(entityManagerFactory==null){
			entityManagerFactory = HibernateUtil.getEntityManagerFactory(); 
		}
		return entityManagerFactory;
	}
    
    @Override
	public DAOEntityManager getEntityManager() {
		// TODO Auto-generated method stub
    	EntityManager em = HibernateUtil.currentEntityManager();
    	DAOEntityManager dao = new HibernateDAOEntityManager(em);
		return dao;
	}	
}
