package DAO.Impl;

import DAO.MaterialDAO;
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

public class MaterialDAOImpl extends GenericDAOImpl<Material> implements MaterialDAO {
	public MaterialDAOImpl(Class<Material> type) {
		super(type);
	}
	
	public Material getMaterialById(Integer id) throws SQLException {
		Session session = null;
		Material material = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			material = (Material)session.load(Material.class, id);
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getMaterialById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return material;
	}
	
	public Material getMaterialByName(String str) throws SQLException {
		Session session = null;
		Material material = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Material m where m.name = :str").setString("str", str);
			material = (Material)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getMaterialByName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return material;
	}
	
	public Material getMaterialByCar(Car c) throws SQLException {
		Session session = null;
		Long num = c.getRegNumber();
		Material material = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Material.*" 
						+ " from Material INNER JOIN Car on Car.upholstery = Material.id" 
						+ " where Car.reg_number = :num").setLong("num", num);
			material = (Material)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getMaterialByCar'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return material;
	}
}