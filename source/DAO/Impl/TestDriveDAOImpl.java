package DAO.Impl;

import DAO.TestDriveDAO;
import logic.*;

import java.util.Collection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.Query;

public class TestDriveDAOImpl extends GenericDAOImpl<TestDrive> implements TestDriveDAO {
	public TestDriveDAOImpl(Class<TestDrive> type) {
		super(type);
	}
	
	public TestDrive getTestDriveByNumber(Long num) throws SQLException {
		Session session = null;
		TestDrive td = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			td = (TestDrive)session.load(TestDrive.class, num);
		}  catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getTestDriveByNumber'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return td;
	}
	
	public Collection getTestDrivesByCar(Car c) throws SQLException {
		Session session = null;
		Long num = c.getRegNumber();
		List tds = new ArrayList<TestDrive>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from TestDrive where car_id = :car").setLong("car", num);
			tds = (List<TestDrive>)q.list();
			session.getTransaction().commit();
		}  catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getTestDriveByCar'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return tds;
	}
	
	public Collection getTestDrivesByClient(Client c) throws SQLException {
		Session session = null;
		Long id = c.getId();
		List tds = new ArrayList<TestDrive>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from TestDrive where client_id = :client").setLong("client", id);
			tds = (List<TestDrive>)q.list();
			session.getTransaction().commit();
		}  catch (Exception e) {
	    	//JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getTestDriveByClient'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return tds;
	}
	
	/*public Collection getTestDrivesByDate(SimpleDateFormat d) throws SQLException {
		
	}*/
}