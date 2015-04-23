package DAO.Impl;

import DAO.ClientDAO;
import logic.Client;
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
import org.hibernate.*;

public class ClientDAOImpl extends GenericDAOImpl<Client> implements ClientDAO {
	public ClientDAOImpl(Class<Client> type) {
		super(type);
	}
	
	public Client getClientById(Long id) throws SQLException {
		Session session = null;
		Client client = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			client = (Client)session.load(Client.class, id);
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientById'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return client;
	}
	
	public Collection getClientsByFName(String fn) throws SQLException {
		Session session = null;
		List clients = new ArrayList<Client>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query q = null;
			if (fn != null)
				q = session.createQuery("from Client cl where cl.first_name = :fname").setString("fname", fn);
			else
				q = session.createQuery("from Client");
			
			clients = (List<Client>)q.list();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientByFName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return clients;
	}
	
	public Collection getClientsByLName(String ln) throws SQLException {
		Session session = null;
		List clients = new ArrayList<Client>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query q = null;
			if (ln != null)
				q = session.createQuery("from Client cl where cl.last_name = :lname").setString("lname", ln);
			else
				q = session.createQuery("from Client");
			
			clients = (List<Client>)q.list();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientByLName'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return clients;
	}
	
	public Collection getClientsByLocation(City c) throws SQLException {
		Session session = null;
		Integer cid = c.getId();
		List clients = new ArrayList<Client>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Client cl where cl.location = :city").setInteger("city", cid);
			clients = (List<Client>)q.list();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientByLocation'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return clients;
	}
	
	public Client getClientByPhone(String ph) throws SQLException {
		Session session = null;
		Client client = null;
		if (ph == null)
			return null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Client cl where cl.phone = :ph").setString("ph", ph);
			client = (Client)q.uniqueResult();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientByPhone'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return client;
	}
	
	public Client getClientByMail(String em) throws SQLException {
		Session session = null;
		Client client = null;
		if (em == null)
			return null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Client cl where cl.email = :email").setString("email", em);
			client = (Client)q.uniqueResult();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientByMail'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return client;
	}
	
	public Client getClientByOrder(Order ord) throws SQLException {
		Session session = null;
		Long num = ord.getNumber();
		Client client = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Client.*"
						+ " from Client INNER JOIN Order on Client.id = Order.client_id"
						+ " where Order.number = :num").setLong("num", num);
			client = (Client)q.uniqueResult();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientByOrder'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return client;
	}
	
	public Client getClientByTestDrive(TestDrive td) throws SQLException {
		Session session = null;
		Long num = td.getNumber();
		Client client = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Client.*"
						+ " from Client INNER JOIN TestDrive on Client.id = TestDrive.client_id"
						+ " where TestDrive.number = :num").setLong("num", num);
			client = (Client)q.uniqueResult();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getClientByOrder'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return client;
	}
}