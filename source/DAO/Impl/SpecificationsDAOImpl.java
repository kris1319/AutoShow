package DAO.Impl;

import DAO.SpecificationsDAO;
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

public class SpecificationsDAOImpl extends GenericDAOImpl<Specifications> implements SpecificationsDAO {
	public SpecificationsDAOImpl(Class<Specifications> type) {
		super(type);
	}
	
	public Specifications getSpecificByCar(Car c) throws SQLException {
		Session session = null;
		Long num = c.getRegNumber();
		Specifications spec = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			spec = (Specifications)session.load(Specifications.class, num);
			session.getTransaction().commit();
		} catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getSpecificByCar'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return spec;
	}
}