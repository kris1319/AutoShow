package DAO.Impl;

import DAO.*;
import logic.*;

import java.util.Collection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.HibernateUtil;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.Query;

public class StatusDAOImpl extends GenericDAOImpl<Status> implements StatusDAO {
	public StatusDAOImpl(Class<Status> type) {
		super(type);
	}
	
	public Status getStatusById(Integer id) throws SQLException {
		Session session = null;
		Status st = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			st = (Status)session.load(Status.class, id);
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getStatusById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return st;
	}
	
	public Status getStatusByName(String str) throws SQLException {
		Session session = null;
		Status st = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Status st where st.status = :str").setString("str", str);
			st = (Status)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getStatusByName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return st;
	}
		
	public Status getStatusByOrder(Order ord) throws SQLException {
		Session session = null;
		Long num = ord.getNumber();
		Status st = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Status.*" 
						+ " from Status INNER JOIN Order on Order.status = Status.id" 
						+ " where Order.number = :num").setLong("num", num);
			st = (Status)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getStatusByCar'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return st;
	}
}