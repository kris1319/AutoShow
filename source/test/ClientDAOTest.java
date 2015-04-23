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

public class ClientDAOTest extends Assert {
	private ClientDAO tD = Factory.getInstance().getClientDAO();
	private CityDAO cD = Factory.getInstance().getCityDAO();
	private OrderDAO oD = Factory.getInstance().getOrderDAO();
	private TestDriveDAO dD = Factory.getInstance().getTestDriveDAO();
	
	@DataProvider
	public Object[][] ClientData() {
		return new Object[][] {
				{ "x", "y", 1, "blabla street", "email", "phone", true },
				{ "x", "y", 11000, "blabla street", "email", "phone", false },
				{ null, "y", 1, "blabla street", "email", "phone", false },
				{ "x", null, 1, "blabla street", "email", "phone", false },
				{ "x", "y", null, "blabla street", "email", "phone", false },
				{ "x", "y", 1, null, "email", "phone", false },
				{ "x", "y", 1, "blabla street", null, "phone", true },
				{ "x", "y", 1, "blabla street", "email", null, true },
				{ null, null, null, null, null, null, false }
		};
	}
	
	@Test(dataProvider="ClientData")
	public void DataTest(String fn, String ln, Integer loc, String add, String em, String ph, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			logic.Client obj = new logic.Client(count.longValue() + 1, fn, ln, loc, add, em, ph);

			tD.insert(obj);
			logic.Client temp = tD.getClientById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getFirstName(), obj.getFirstName());
			assertEquals(temp.getLastName(), obj.getLastName());
			assertEquals(temp.getLocation(), obj.getLocation());
			assertEquals(temp.getAddress(), obj.getAddress());
			assertEquals(temp.getEmail(), obj.getEmail());
			assertEquals(temp.getPhone(), obj.getPhone());
			
			obj.setFirstName(obj.getFirstName() + "eye");
			obj.setLastName(obj.getLastName() + "eye");
			obj.setLocation(2);
			obj.setAddress(obj.getAddress() + "eye");
			obj.setEmail(obj.getEmail() + "eye");
			obj.setPhone("phone000");
			tD.update(obj);
			temp = tD.getClientById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getFirstName(), obj.getFirstName());
			assertEquals(temp.getLastName(), obj.getLastName());
			assertEquals(temp.getLocation(), obj.getLocation());
			assertEquals(temp.getAddress(), obj.getAddress());
			assertEquals(temp.getEmail(), obj.getEmail());
			assertEquals(temp.getPhone(), obj.getPhone());
			
			tD.delete(obj);
			temp = tD.getClientById(obj.getId());
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
	public Object[][] ClientFName() {
		return new Object[][] {
				{ "string", "y", 1, "blabla street", "email", "phone", true },
				{ null, "y", 1, "blabla street", "email", "phone", false }
		};
	}
	
	@Test(dataProvider="ClientFName")
	public void getByFName(String fn, String ln, Integer loc, String add, String em, String ph, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			logic.Client obj = new logic.Client(count.longValue() + 1, fn, ln, loc, add, em, ph);
			logic.Client obj1 = new logic.Client(count.longValue() + 2, fn, ln + "111", loc, add + "111", em, ph);
			tD.insert(obj);
			tD.insert(obj1);
			
			Collection<logic.Client> temp = tD.getClientsByFName(fn);
			assertNotNull(temp);
			assertTrue(temp.size() != 0);
			
			boolean f = false, f1 = false;
			for (logic.Client i : temp) {
				if (i.getId() == obj.getId()) 
					f = true;
				else if (i.getId() == obj1.getId())
					f1 = true;
			}
			assertTrue(f);
			assertTrue(f1);
			
			tD.delete(obj);
			tD.delete(obj1);
			assertEquals(tD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}

	@DataProvider
	public Object[][] ClientLName() {
		return new Object[][] {
				{ "x", "string", 1, "blabla street", "email", "phone", true },
				{ "x", null, 1, "blabla street", "email", "phone", false }
		};
	}
	
	@Test(dataProvider="ClientLName")
	public void getByLName(String fn, String ln, Integer loc, String add, String em, String ph, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			logic.Client obj = new logic.Client(count.longValue() + 1, fn, ln, loc, add, em, ph);
			logic.Client obj1 = new logic.Client(count.longValue() + 2, fn + "111", ln, loc, add + "111", em, ph);
			tD.insert(obj);
			tD.insert(obj1);
			
			Collection<logic.Client> temp = tD.getClientsByLName(ln);
			assertNotNull(temp);
			assertTrue(temp.size() != 0);
			
			boolean f = false, f1 = false;
			for (logic.Client i : temp) {
				if (i.getId() == obj.getId()) 
					f = true;
				else if (i.getId() == obj1.getId())
					f1 = true;
			}
			assertTrue(f);
			assertTrue(f1);
			
			tD.delete(obj);
			tD.delete(obj1);
			assertEquals(tD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}
	
	@DataProvider
	public Object[][] ClientEmail() {
		return new Object[][] {
				{ "xx", "y", 1, "blabla street", "email", "phone", true },
				{ "xx", "y", 1, "blabla street", null, "phone", true }
		};
	}
	
	@Test(dataProvider="ClientEmail")
	public void getByEmail(String fn, String ln, Integer loc, String add, String em, String ph, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			logic.Client obj = new logic.Client(count.longValue() + 1, fn, ln, loc, add, em, ph);
			tD.insert(obj);
			
			logic.Client temp = tD.getClientByMail(em);
			if (em == null)
				assertNull(temp);
			else {
				assertNotNull(temp);
				assertEquals(temp.getId(), obj.getId());
				assertEquals(temp.getFirstName(), obj.getFirstName());
				assertEquals(temp.getLastName(), obj.getLastName());
				assertEquals(temp.getLocation(), obj.getLocation());
				assertEquals(temp.getAddress(), obj.getAddress());
				assertEquals(temp.getEmail(), obj.getEmail());
				assertEquals(temp.getPhone(), obj.getPhone());
			}
			
			tD.delete(obj);
			assertEquals(tD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}

	@DataProvider
	public Object[][] ClientPhone() {
		return new Object[][] {
				{ "x", "yy", 1, "blabla street", "email", "phone", true },
				{ "x", "yy", 1, "blabla street", "email", null, true }
		};
	}
	
	@Test(dataProvider="ClientPhone")
	public void getByPhone(String fn, String ln, Integer loc, String add, String em, String ph, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			logic.Client obj = new logic.Client(count.longValue() + 1, fn, ln, loc, add, em, ph);
			tD.insert(obj);
			
			logic.Client temp = tD.getClientByPhone(ph);
			if (em == null)
				assertNull(temp);
			else {
				assertNotNull(temp);
				assertEquals(temp.getId(), obj.getId());
				assertEquals(temp.getFirstName(), obj.getFirstName());
				assertEquals(temp.getLastName(), obj.getLastName());
				assertEquals(temp.getLocation(), obj.getLocation());
				assertEquals(temp.getAddress(), obj.getAddress());
				assertEquals(temp.getEmail(), obj.getEmail());
				assertEquals(temp.getPhone(), obj.getPhone());
			}
			
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
	public void getByCity() {
		try {
			Collection<City> cs = cD.getAll();
			assertNotNull(cs);
			if (cs.size() != 0) {
				for (City i : cs) {
					Collection<logic.Client> temp = tD.getClientsByLocation(i);
					assertNotNull(temp);
					for (logic.Client ii : temp) {
						assertEquals(i.getId(), ii.getLocation());
					}
				}
			} else {
				Collection<logic.Client> cls = tD.getAll();
				assertNotNull(cls);
				assertFalse(cls.size() != 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByOrder() {
		try {
			Collection<Order> ords = oD.getAll();
			assertNotNull(ords);
			if (ords.size() != 0) {
				for (Order i : ords) {
					logic.Client temp = tD.getClientByOrder(i);
					assertNotNull(temp);
					Collection<Order> os = temp.getCarsOrders();
					assertNotNull(os);
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
				Collection<logic.Client> cs = tD.getAll();
				assertNotNull(cs);
				for (logic.Client i : cs) {
					assertFalse(i.getCarsOrders().size() != 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByTestDrive() {
		try {
			Collection<TestDrive> tds = dD.getAll();
			assertNotNull(tds);
			if (tds.size() != 0) {
				for (TestDrive i : tds) {
					logic.Client temp = tD.getClientByTestDrive(i);
					assertNotNull(temp);
					Collection<TestDrive> os = temp.getCarsTestDrives();
					assertNotNull(os);
					assertTrue(os.size() != 0);
					
					boolean f = false;
					for (TestDrive ii : os) {
						if (ii.getNumber() == i.getNumber()) {
							f = true;
							break;
						}
					}
					
					assertTrue(f);
				}
			} else {
				Collection<logic.Client> cs = tD.getAll();
				assertNotNull(cs);
				for (logic.Client i : cs) {
					assertFalse(i.getCarsTestDrives().size() != 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}