package DAO.Impl;

import DAO.CountryDAO;
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

public class CountryDAOImpl extends GenericDAOImpl<Country> implements CountryDAO {
	public CountryDAOImpl(Class<Country> type) {
		super(type);
	}
		
	public Country getCountryById(Integer id) throws SQLException {
		Session session = null;
		Country country = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			country = (Country)session.load(Country.class, id);
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCountryById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return country;
	}
	
	public Country getCountryByName(String c) throws SQLException {
		Session session = null;
		Country country = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Country c where c.country = :str").setString("str", c);
			country = (Country)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCityByName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return country;
	}
	
	public Country getCountryByCity(City c) throws SQLException {
		Session session = null;
		Integer cid = c.getId();
		Country country = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Country.*" 
							+ " from Country INNER JOIN City on City.country_id = Country.id" 
							+ " where City.id = :cid").setInteger("cid", cid);
			country = (Country)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCountryByCity'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return country;
	}
	
	public Country getCountryByManufacturer(Manufacturer man) throws SQLException {
		Session session = null;
		Integer mid = man.getCountryId();
		Country country = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Country.*" 
							+ " from Country INNER JOIN Manufacturer on Manufacturer.country_id = Country.id" 
							+ " where Manufacturer.id = :man_id").setInteger("man_id", mid);
			country = (Country)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCityByClient'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return country;
	}
} 