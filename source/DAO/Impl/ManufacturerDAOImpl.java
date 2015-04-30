package DAO.Impl;

import DAO.ManufacturerDAO;
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

public class ManufacturerDAOImpl extends GenericDAOImpl<Manufacturer> implements ManufacturerDAO {
	public ManufacturerDAOImpl(Class<Manufacturer> type) {
		super(type);
	}
	
	public Manufacturer getManufactById(Integer id) throws SQLException {
		Session session = null;
		Manufacturer man = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			man = (Manufacturer)session.load(Manufacturer.class, id);
		} catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getManufacturerById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return man;
	}
	
	public Manufacturer getManufactByName(String nf) throws SQLException {
		Session session = null;
		Manufacturer man = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Manufacturer where name = :nf").setString("nf", nf);
			man = (Manufacturer)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getManufacturerByName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return man;
	}
	
	public Collection getManufactsByCountry(Country c) throws SQLException {
		Session session = null;
		Integer cid = c.getId();
		List mans = new ArrayList<Manufacturer>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Manufacturer where country_id = :id").setInteger("id", cid);
			mans = (List<Manufacturer>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getManufacturerByCountry'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return mans;
	}
	
	public Manufacturer getManufactByLabel(Label l) throws SQLException {
		Session session = null;
		Integer lid = l.getFactureId();
		Manufacturer man = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			man = (Manufacturer)session.load(Manufacturer.class, lid);
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getManufacturerByLabel'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return man;
	}
}