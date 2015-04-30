package DAO.Impl;

import DAO.OrderDAO;
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

public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {
	public OrderDAOImpl(Class<Order> type) {
		super(type);
	}
	
	public Order getOrderByNumber(Long num) throws SQLException {
		Session session = null;
		Order ord = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ord = (Order)session.load(Order.class, num);
		}  catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getOrderByNumber'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return ord;
	}
	
	public Collection getOrdersByCar(Car c) throws SQLException {
		Session session = null;
		Long num = c.getRegNumber();
		List ords = new ArrayList<Order>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Order where car_id = :car").setLong("car", num);
			ords = (List<Order>)q.list();
			session.getTransaction().commit();
		}  catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getOrderByCar'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return ords;
	}
	
	public Collection getOrdersByClient(Client c) throws SQLException {
		Session session = null;
		Long id = c.getId();
		List ords = new ArrayList<Order>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Order where client_id = :client").setLong("client", id);
			ords = (List<Order>)q.list();
			session.getTransaction().commit();
		}  catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getOrderByClient'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return ords;
	}
	
	/*public Collection getOrdersByDate(SimpleDateFormat d) throws SQLException {
		
	}*/
	
	public Collection getOrdersByStatus(Status st) throws SQLException {
		Session session = null;
		Integer id = st.getId();
		List ords = new ArrayList<Order>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Order where status = :st").setInteger("st", id);
			ords = (List<Order>)q.list();
			session.getTransaction().commit();
		}  catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getOrderByStatus'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return ords;
	}
}
	