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

public class ColourDAOImpl extends GenericDAOImpl<Colour> implements ColourDAO {
	public ColourDAOImpl(Class<Colour> type) {
		super(type);
	}
	
	public Colour getColourById(Integer id) throws SQLException {
		Session session = null;
		Colour col = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			col = (Colour)session.load(Colour.class, id);
		} catch (Exception e) {
			//System.out.print(e);
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getColourById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return col;
	}
	
	public Colour getColourByName(String c) throws SQLException {
		Session session = null;
		Colour col = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Colour where colour = :str").setString("str", c);
			col = (Colour)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getColourByName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return col;
	}
	
	public Colour getColourByCar(Car c) throws SQLException {
		Session session = null;
		Colour col = null;
		Integer cid = c.getColourId();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Colour where id = :col").setInteger("col", cid);
			col = (Colour)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getColourByCar'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return col;
	}
}
