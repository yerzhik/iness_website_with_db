package com.iness.dao;

import java.lang.reflect.Constructor;

import javax.naming.Context;
import javax.naming.InitialContext;


public abstract class DAOEntityManagerFactory {
	public static String FACTORY_TYPE ="com.magnifi.baseball.dao.hibernate.HibernateDAOEntityManagerFactory";
//	final Logger logger = LoggerFactory.getLogger(DAOEntityManagerFactory.class);
	public abstract DAOEntityManager getEntityManager();
	
	public static DAOEntityManagerFactory getInstance() {
		DAOEntityManagerFactory factory = null;
        try {
      
			factory = (DAOEntityManagerFactory) Class.forName(FACTORY_TYPE).newInstance();
        }
        catch ( Exception e ) {
        	e.printStackTrace();
        }
		return factory;
    }
	
	public static DAOEntityManagerFactory getInstance(String name){
		DAOEntityManagerFactory factory = null;
        try {
            Class factoryImplClass = Class.forName(FACTORY_TYPE);
            Class[] args = {Context.class, String.class};
            Constructor constructor = factoryImplClass.getConstructor(args);
            Object[] argValues = new Object[2];
            argValues[0]= new InitialContext();
            argValues[1]= name;
			factory = (DAOEntityManagerFactory) constructor.newInstance(argValues);
        }
        catch ( Exception e ) {
        	e.printStackTrace();
        }
		return factory;
    }

}
