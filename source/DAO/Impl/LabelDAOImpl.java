package DAO.Impl;

import DAO.LabelDAO;
import logic.Car;
import logic.City;
import logic.Client;
import logic.Colour;
import logic.Country;
import logic.Label;
import logic.Manufacturer;
import logic.Material;

import logic.Order;
import logic.Specifications;
import logic.Status;
import logic.TestDrive;

import java.util.Collection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.HibernateUtil;

import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.Query;

public class LabelDAOImpl extends GenericDAOImpl<Label> implements LabelDAO {
	public LabelDAOImpl(Class<Label> type) {
		super(type);
	}
	
	public Label getLabelById(Integer id) throws SQLException {
		Session session = null;
		Label label = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			label = (Label)session.load(Label.class, id);
		} catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getLabelById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return label;
	}
	
	public Label getLabelByName(String nl) throws SQLException {
		Session session = null;
		Label label = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Label where name = :nl").setString("nl", nl);
			label = (Label)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getLabelByName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return label;
	}
	
	public Collection getLabelsByManufacturer(Manufacturer man) throws SQLException {
		Session session = null;
		Integer mid = man.getId();
		List labels = new ArrayList<Label>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Label where facture_id = :man").setInteger("man", mid);
			labels = (List<Label>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getLabelByManufacturer'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return labels;
	}
	
	public Label getLabelByCar(Car c) throws SQLException {
		Session session = null;
		Integer num = c.getLabelId();
		Label label = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Label where label_id = :num").setInteger("num", num);
			label = (Label)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getLabelByCar'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return label;
	}
}