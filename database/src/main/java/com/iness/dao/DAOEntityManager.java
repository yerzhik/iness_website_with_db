package com.iness.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public abstract class DAOEntityManager {
	
	public abstract Object update(Object o);
    public abstract Object refresh(Object o);
    public abstract void delete(Object o);
    public abstract Object save(Object o);
    public abstract Object saveOrUpdate(Object o);
    public abstract void close();
    public abstract Object query(String query, Map map, boolean uniqueResult);
    public abstract Object nativeQuery(String query, Map map, boolean uniqueResult);
	public abstract void flush();
    public abstract void commit();
    public abstract void rollback();
    public abstract boolean isOpen();
    public abstract List findEntities(String query, int start, int count, Map params);

    public abstract List findEntitiesByQueryName(String queryName, int start, int count, Map params) ;

    public abstract Object findUniqueEntityByQueryName(String queryName,  Map params);

    public abstract Object findUniqueEntity(String query, Map params);

    public abstract List findEntitiesByExample(Object example, Class exampleClass, int start, int count);

    public abstract Object findUniqueEntityByExample(Object example, Class exampleClass);

    public abstract Object findUniqueEntityByID(Class entityClass, Serializable id);

    public abstract Connection getConnection();

    public abstract int executeUpdate(String query, Map params);
    
    public abstract int executeNativeUpdate(String query, Map params);
}
