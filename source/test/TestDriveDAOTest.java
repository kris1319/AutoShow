package test;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

import logic.*;
import DAO.*;

public class TestDriveDAOTest extends Assert {
	private TestDriveDAO tD = Factory.getInstance().getTestDriveDAO();
	private ClientDAO lD = Factory.getInstance().getClientDAO();
	private CarDAO cD = Factory.getInstance().getCarDAO();
	private StatusDAO sD = Factory.getInstance().getStatusDAO();
	
	@DataProvider
	public Object[][] TestDriveData() {
		return new Object[][] {
				{ 1, 1, "21/12/2014 12:30:00.350", "x", true },
				{ null, 1, "21/12/2014 12:30:00.350", "x", false },
				{ 1, null, "21/12/2014 12:30:00.350", "x", false },
				{ 1, 1, null, "x", false },
				{ 1, 1, "21/12/2014 12:30:00.350", null, true },
				{ null, null, null, null, null, false }
		};
	}
	
	@Test(dataProvider="TestDriveData")
	public void DataTest(Long c, Long l, SimpleDateFormat d, String s, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			TestDrive obj = new TestDrive(count.longValue() + 1, c, l, d, s);

			tD.insert(obj);
			TestDrive temp = tD.getTestDriveByNumber(obj.getNumber());
			assertNotNull(temp);
			assertEquals(temp.getNumber(), obj.getNumber());
			assertEquals(temp.getCarId(), obj.getCarId());
			assertEquals(temp.getClientId(), obj.getClientId());
			assertEquals(temp.getDate(), obj.getDate());
			assertEquals(temp.getFeedback(), obj.getFeedback());
			
			obj.setCarId(Long.valueOf(2));
			obj.setClientId(Long.valueOf(2));
			obj.setFeedback("y");
			tD.update(obj);
			temp = tD.getTestDriveByNumber(obj.getNumber());
			assertNotNull(temp);
			assertEquals(temp.getNumber(), obj.getNumber());
			assertEquals(temp.getCarId(), obj.getCarId());
			assertEquals(temp.getClientId(), obj.getClientId());
			assertEquals(temp.getDate(), obj.getDate());
			assertEquals(temp.getFeedback(), obj.getFeedback());
			
			tD.delete(obj);
			temp = tD.getTestDriveByNumber(obj.getNumber());
			assertNull(temp);
			
			assertEquals(tD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}

	@Test
	public void getByCar() {
		try {
			Collection<Car> cs = cD.getAll();
			assertNotNull(cs);
			if (cs.size() != 0) {
				for (Car i : cs) {
					Collection<TestDrive> temp = tD.getTestDrivesByCar(i);
					assertNotNull(temp);
					for (TestDrive ii: temp) {
						assertEquals(ii.getCarId(), i.getRegNumber());
					}
				}
			} else {
				Collection<TestDrive> os = tD.getAll();
				assertNotNull(os);
				assertFalse(os.size() != 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
	
	@Test
	public void getByClient() {
		try {
			Collection<Client> cs = lD.getAll();
			assertNotNull(cs);
			if (cs.size() != 0) {
				for (Client i : cs) {
					Collection<TestDrive> temp = tD.getTestDrivesByClient(i);
					assertNotNull(temp);
					for (TestDrive ii: temp) {
						assertEquals(ii.getClientId(), i.getId());
					}
				}
			} else {
				Collection<TestDrive> os = tD.getAll();
				assertNotNull(os);
				assertFalse(os.size() != 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}