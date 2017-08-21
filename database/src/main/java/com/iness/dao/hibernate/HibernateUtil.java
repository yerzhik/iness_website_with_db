package com.iness.dao.hibernate;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.engine.spi.SessionImplementor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;


public class HibernateUtil {
	public static String PERSISTENT_UNIT = "pennantrace";
	public static final int ALLOCATION_SIZE=1;
    public static final int RETRY_COUNT = 10;
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
	
	public static final ThreadLocal<EntityManager> entityManager = new ThreadLocal<EntityManager>();

    public static long sleepIntervalWhenDeadlockDetected(int retryCount) {
        Random random = new Random();
        return (HibernateUtil.RETRY_COUNT - retryCount) * 1000 + random.nextInt(1000);
    }

    public static boolean isDeadlockException(Throwable e) {
        if (e instanceof SQLException) {
            return ((SQLException) e).getSQLState().equals("40P01");
        } else {
            return e != null && isDeadlockException(e.getCause());
        }
    }

	public static EntityManagerFactory getEntityManagerFactory(){
		try {
			if(entityManagerFactory==null){
	    		entityManagerFactory =Persistence.createEntityManagerFactory(PERSISTENT_UNIT); 
	    	}
			return entityManagerFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
	}

    public static void setupHibernateOnAutoFlushManual() {
        Session session = currentEntityManager().unwrap(Session.class);
        session.setDefaultReadOnly(true);
        session.setFlushMode(FlushMode.MANUAL);
    }
	
	public static EntityManager currentEntityManager()
			throws HibernateException {
		EntityManager em = (EntityManager) entityManager.get();
		if (em == null||!em.isOpen()) {
			em = getEntityManagerFactory().createEntityManager();
			entityManager.set(em);
		}
		return em;
	}

	public static EntityManager currentEntityManager(EntityManagerFactory emf)
			throws HibernateException {
		EntityManager em = (EntityManager) entityManager.get();
		if (em == null||!em.isOpen()) {

			em = emf.createEntityManager();

			entityManager.set(em);
		}
		return em;
	}
	
	public static void closeCurrentEntityManager() {
        EntityManager s = (EntityManager) entityManager.get();
        try {
            if (s != null) {
                if (s.getTransaction().isActive()) {
                    if (s.getTransaction().getRollbackOnly()) {
                        s.getTransaction().rollback();
                    } else {
                        s.getTransaction().commit();
                    }
                }
                s.close();
            }
        } finally {
            entityManager.remove();
        }
	}
	
	public static Connection getConnection() {
    	HibernateEntityManager em = (HibernateEntityManager)HibernateUtil.currentEntityManager();
    	SessionImplementor si = (SessionImplementor)em.getSession();
    	return si.connection();
    }

}
