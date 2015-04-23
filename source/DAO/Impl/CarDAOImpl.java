package DAO.Impl;

import DAO.CarDAO;
import logic.*;

import java.util.Collection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.Query;

public class CarDAOImpl extends GenericDAOImpl<Car> implements CarDAO {
	public CarDAOImpl(Class<Car> type) {
		super(type);
	}
	
	public Car getCarByRegNumber(Long num) throws SQLException {
		Session session = null;
		Car car = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			car = (Car)session.load(Car.class, num);
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with getting car by reg num", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return car;
	}
	
	public Collection getCarsByCost(BigDecimal lc, BigDecimal rc) throws SQLException {
		Session session = null;
		List cars = new ArrayList<Car>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query q;
			if (lc == null && rc == null)
				q = session.createQuery("select c" + " from Car c");
			else if (lc == null)
				q = session.createQuery("select c" + " from Car c" + " where c.cost <= :rcost").setBigDecimal("rcost", rc);
			else if (rc == null)
				q = session.createQuery("select c" + " from Car c" + " where c.cost >= :lcost").setBigDecimal("lcost", lc);
			else 
				q = session.createQuery("select c" + " from Car c"
						+ " where c.cost <= :rcost and c.cost >= :lcost").setBigDecimal("lcost", lc).setBigDecimal("rcost", rc);
			
			cars = (List<Car>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByCost'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return cars;
	}
	
	public Collection getCarsByMileage(Double rm) throws SQLException {
		Session session = null;
		List cars = new ArrayList<Car>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("select c" + " from Car c"
						+ " where c.mileage <= :rmil").setDouble("rmil", rm);
			cars = (List<Car>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByMileage'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return cars;
	}
	
	/*public Collection getCarsByMaintenance(SimpleDateFormat d) throws SQLException {
		Session session = null;
		List cars = new ArrayList<Car>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("select c" + "from Car c"
						+ "where c.maintenance = :date").setSimpleDateFormat("date", d);
			cars = (List<Car>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByCost'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
	}*/
	
	public Collection getCarsByColour(Colour c) throws SQLException {
		Session session = null;
		Integer cid = c.getId();
		List cars = new ArrayList<Car>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("select c" + " from Car c"
						+ " where c.colour_id = :col").setInteger("col", cid);
			cars = (List<Car>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByColour'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return cars;
	}
	
	public Collection getCarsByUpholstery(Material m) throws SQLException {
		Session session = null;
		List cars = new ArrayList<Car>();
		Integer mid = m.getId();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("select c" + " from Car c"
						+ " where c.upholstery = :uph").setInteger("uph", mid);
			cars = (List<Car>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByUpholstery'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return cars;
	}
	
	public Collection getCarsByLabel(Label l) throws SQLException {
		Session session = null;
		List cars = new ArrayList<Car>();
		Integer lid = l.getId();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("select c" + " from Car c"
						+ " where c.label_id = :l").setInteger("l", lid);
			cars = (List<Car>)q.list();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByLabel'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return cars;
	}
	
	public Car getCarByOrder(Order ord) throws SQLException {
		Session session = null;
		Car car = null;
		Long num = ord.getNumber();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Car.*" + " from Car INNER JOIN Order on Car.reg_number = Order.car_id"
						+ " where Order.number = :ord").setLong("ord", num);
			car = (Car)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByOrder'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return car;
	}
	
	public Car getCarByTestDrive(TestDrive td) throws SQLException {
		Session session = null;
		Car car = null;
		Long num = td.getNumber();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q = session.createSQLQuery("SELECT Car.*" + " from Car INNER JOIN TestDrive on Car.reg_number = TestDrive.car_id"
						+ " where TestDrive.number = :td").setLong("td", num);
			car = (Car)q.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, e.getMessage(), "Error with 'getCarsByTestDrive'", JOptionPane.OK_OPTION);
	    } finally {
	    	if (session != null && session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return car;
	}
}