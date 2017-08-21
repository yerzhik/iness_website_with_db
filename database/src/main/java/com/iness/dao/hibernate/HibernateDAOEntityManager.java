package com.iness.dao.hibernate;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.iness.dao.DAOEntityManager;


public class HibernateDAOEntityManager extends DAOEntityManager {

	private EntityManager entityManager;

	public HibernateDAOEntityManager(EntityManager em) {
		// TODO Auto-generated constructor stub
		entityManager = em;
	}

	@Override
	public Object update(Object o) {
		// TODO Auto-generated method stub
		//this.getEntityManager().merge(o);
		return o;
	}

	@Override
	public Object refresh(Object o) {
		// TODO Auto-generated method stub
		//this.getEntityManager().refresh(o);
		return o;
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		this.getEntityManager().remove(o);

	}

	@Override
	public Object save(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object saveOrUpdate(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		if(this.getEntityManager().isOpen()){
			this.getEntityManager().close();
		}
		
	}

	@Override
	public Object query(String query, Map map, boolean uniqueResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object nativeQuery(String query, Map map, boolean uniqueResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		this.getEntityManager().flush();
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		this.getEntityManager().getTransaction().commit();
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		this.getEntityManager().getTransaction().rollback();
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return this.getEntityManager().isOpen();
	}

	@Override
	public List findEntities(String query, int start, int count, Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findEntitiesByQueryName(String queryName, int start, int count,
			Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findUniqueEntityByQueryName(String queryName, Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findUniqueEntity(String query, Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findEntitiesByExample(Object example, Class exampleClass,
			int start, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findUniqueEntityByExample(Object example, Class exampleClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findUniqueEntityByID(Class entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(String query, Map params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeNativeUpdate(String query, Map params) {
		// TODO Auto-generated method stub
		return 0;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
