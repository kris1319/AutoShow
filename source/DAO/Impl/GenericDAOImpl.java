package DAO.Impl;

import java.sql.SQLException;
import java.util.List;

import DAO.*;

import org.hibernate.Session;

import logic.HibernateUtil;
import org.hibernate.SessionFactory;
import java.util.Collection;

public class GenericDAOImpl <T> implements GenericDAO <T> {
	private Class<T> type;
	
	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public void insert(T obj) {
		Session session = null;
	    try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.save(obj);
	    	session.getTransaction().commit();
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
	}
	
	@Override
	public void update(T obj) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.update(obj);
	    	session.getTransaction().commit();
		} finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
	}
	
	@Override
	public void delete(T obj) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.delete(obj);
	    	session.getTransaction().commit();
		} finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
	}
	
	@Override
	public Collection<T> getAll() {
		Session session = null;
		Collection<T> result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			result =  (Collection<T>) session.createCriteria(type).list();
			session.getTransaction().commit();
			return result;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}
	
	