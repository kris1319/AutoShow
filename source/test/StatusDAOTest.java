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

public class StatusDAOTest extends Assert {
	private StatusDAO tD = Factory.getInstance().getStatusDAO();
	private OrderDAO ordD = Factory.getInstance().getOrderDAO();
	
	@DataProvider
	public Object[][] StatusData() {
		return new Object[][] {
				{ "x", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="StatusData")
	public void DataTest(String str, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Status obj = new Status(count.intValue() + 1, str);

			tD.insert(obj);
			Status temp = tD.getStatusById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getStatus(), obj.getStatus());
			
			obj.setStatus(obj.getStatus() + "eye");
			tD.update(obj);
			temp = tD.getStatusById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getStatus(), obj.getStatus());
			
			tD.delete(obj);
			temp = tD.getStatusById(obj.getId());
			assertNull(temp);
			
			assertEquals(tD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}

	@DataProvider
	public Object[][] StatusName() {
		return new Object[][] {
				{ "string", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="StatusName")
	public void getByName(String str, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Status obj = new Status(count.intValue() + 1, str);
			tD.insert(obj);
			
			Status temp = tD.getStatusByName(str);
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getStatus(), obj.getStatus());
			
			tD.delete(obj);
			assertEquals(tD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}

	@Test
	public void getByOrder() {
		try {
			Collection<Order> ords = ordD.getAll();
			assertNotNull(ords);
			if (ords.size() != 0) {
				for (Order i : ords) {
					Status temp = tD.getStatusByOrder(i);
					assertNotNull(temp);
						
					Set<Order> os = temp.getOrders();
					assertTrue(os.size() != 0);
					boolean f = false;
					for (Order ii : os) {
						if (ii.getNumber() == i.getNumber()) {
							f = true;
							break;
						}
					}
						
					assertTrue(f);
				}
			} else {
				Collection<Status> sts = tD.getAll();
				for (Status i : sts) {
					assertFalse(i.getOrders().size() != 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}