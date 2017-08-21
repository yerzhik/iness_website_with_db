package com.iness.dao;

import javax.persistence.EntityManager;

import com.iness.dao.hibernate.HibernateUtil;


public abstract class

        BaseDAO<E, K> implements IDAO {
	private Class<E> entityClass;

	public BaseDAO(Class<E> entityClass) {
		super();
		this.entityClass = entityClass;
	}
	
	public E getSourceByID(K key){
		EntityManager entityManager = HibernateUtil.currentEntityManager();
		E entity = entityManager.find(entityClass, key);
		return entity;
	}
	
	public void save(E obj){
		EntityManager entityManager = HibernateUtil.currentEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}
	
	public void saveOrUpdate(E obj){
		EntityManager entityManager = HibernateUtil.currentEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.flush();
		entityManager.getTransaction().commit();
	}
	
	public void saveOrUpdateWithoutCommit(E obj){
		HibernateUtil.currentEntityManager().merge(obj);
	}
	
	public void saveWithoutCommit(E obj){
		HibernateUtil.currentEntityManager().persist(obj);
	}
	
}
