package DAO.Impl;

import DAO.CityDAO;
import logic.*;

import java.util.Collection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.Query;

public class CityDAOImpl extends GenericDAOImpl<City> implements CityDAO {
	public CityDAOImpl(Class<City> type) {
		super(type);
	}

	public City getCityById(Integer id) throws SQLException {
		Session session = null;
		City city = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			city = (City)session.load(City.class, id);
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCityById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return city;
	}
	
	public City getCityByName(String c) throws SQLException {
		Session session = null;
		City city = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from City c where c.city = :str").setString("str", c);
			city = (City)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCityByName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return city;
	}
	
	public Collection getCitiesByCountry(Country c) throws SQLException {
		Session session = null;
		Integer cid = c.getId();
		List cities = new ArrayList<City>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from City c where c.country_id = :cid").setInteger("cid", cid);
			cities = (List<City>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCitiesByCountry'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return cities;
	}
	
	public City getCityByClient(Client cl) throws SQLException {
		Session session = null;
		Integer cid = cl.getLocation();
		City city = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from City c where c.id = :clid").setInteger("clid", cid);
			city = (City)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCityByClient'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return city;
	}
} 