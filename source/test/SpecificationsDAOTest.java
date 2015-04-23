package test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

import logic.*;
import DAO.*;

public class SpecificationsDAOTest extends Assert {
	private SpecificationsDAO tD = Factory.getInstance().getSpecificationsDAO();
	private CarDAO cD = Factory.getInstance().getCarDAO();
	
	@DataProvider
	public Object[][] SpecificData() {
		return new Object[][] {
				{ 1, 10, 10.5, 0, true },
				{ 1, null, 10.5, 0, true },
				{ 1, 10, null, 0, true },
				{ 1, 10, 10.5, null, true },
				{ 1000, 10, 10.5, 0, false }
		};
	}
	
	@Test(dataProvider="SpecificData")
	public void DataTest(Long c, Integer e, Double f, Boolean g, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Specifications obj = new Specifications(c, e, f, g);

			tD.insert(obj);
			Car car = cD.getCarByRegNumber(c);
			Specifications temp = tD.getSpecificByCar(car);
			assertNotNull(temp);
			assertEquals(temp.getCarId(), obj.getCarId());
			assertEquals(temp.getEnginePower(), obj.getEnginePower());
			assertEquals(temp.getFuelConsumption(), obj.getFuelConsumption());
			assertEquals(temp.getAutoTransmission(), obj.getAutoTransmission());
			
			obj.setAutoTransmission(true);
			obj.setFuelConsumption(20.5);
			obj.setEnginePower(100);
			tD.update(obj);
			temp = tD.getSpecificByCar(car);
			assertNotNull(temp);
			assertEquals(temp.getCarId(), obj.getCarId());
			assertEquals(temp.getEnginePower(), obj.getEnginePower());
			assertEquals(temp.getFuelConsumption(), obj.getFuelConsumption());
			assertEquals(temp.getAutoTransmission(), obj.getAutoTransmission());
			
			tD.delete(obj);
			temp = tD.getSpecificByCar(car);
			assertNull(temp);
			
			assertEquals(tD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}
}