package test;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

import logic.*;
import DAO.*;

public class CarDAOTest extends Assert {
	private CarDAO tD = Factory.getInstance().getCarDAO();
	private ColourDAO cD = Factory.getInstance().getColourDAO();
	private MaterialDAO mD = Factory.getInstance().getMaterialDAO();
	private LabelDAO lD = Factory.getInstance().getLabelDAO();
	private OrderDAO oD = Factory.getInstance().getOrderDAO();
	private TestDriveDAO dD = Factory.getInstance().getTestDriveDAO();
	
	@DataProvider
	public Object[][] CarData() {
		return new Object[][] {
				{ 1, "x", 100, 1, 1, true },
				{ null, "x", 100, 1, 1, false },
				{ 1, null, 100, 1, 1, false },
				{ 1, "x", 100, null, 1, false },
				{ 1, "x", 100, 1, null, false },
				{ 1000, "x", 100, 1, 1, false },
				{ 1, 1000, 100, 1, 1, false },
				{ 1, "x", 100, 1000, 1, false },
				{ 1, "x", 100, 1, 1000, false },
				{ 1, "x", null, 1, 1, true },
				{ null, null, null, null, null, false }
		};
	}
	
	@Test(dataProvider="CarData")
	public void DataTest(Integer l, String m, BigDecimal c, Integer col, Integer u, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Car obj = new Car(count.longValue() + 1, l, m, c, col, u);

			tD.insert(obj);
			Car temp = tD.getCarByRegNumber(obj.getRegNumber());
			assertNotNull(temp);
			assertEquals(temp.getRegNumber(), obj.getRegNumber());
			assertEquals(temp.getModel(), obj.getModel());
			assertEquals(temp.getCost(), obj.getCost());
			assertEquals(temp.getColourId(), obj.getColourId());
			assertEquals(temp.getUpholstery(), obj.getUpholstery());
			assertEquals(temp.getLabelId(), obj.getLabelId());

			obj.setLabelId(2);
			obj.setCost(BigDecimal.valueOf(2));
			obj.setModel("xxx");
			obj.setColourId(2);
			obj.setUpholstery(2);
			tD.update(obj);
			temp = tD.getCarByRegNumber(obj.getRegNumber());
			assertNotNull(temp);
			assertEquals(temp.getRegNumber(), obj.getRegNumber());
			assertEquals(temp.getModel(), obj.getModel());
			assertEquals(temp.getCost(), obj.getCost());
			assertEquals(temp.getColourId(), obj.getColourId());
			assertEquals(temp.getUpholstery(), obj.getUpholstery());
			assertEquals(temp.getLabelId(), obj.getLabelId());
			
			tD.delete(obj);
			temp = tD.getCarByRegNumber(obj.getRegNumber());
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
	public void getByColour() {
		try {
			Collection<Colour> cs = cD.getAll();
			assertNotNull(cs);
			if (cs.size() != 0) {
				for (Colour i : cs) {
					Collection<Car> temp = tD.getCarsByColour(i);
					assertNotNull(temp);
					for (Car ii : temp) {
						assertEquals(i.getId(), ii.getColourId());
					}
				}
			} else {
				Collection<Car> ccs = tD.getAll();
				assertNotNull(ccs);
				assertFalse(ccs.size() != 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByUpholstery() {
		try {
			Collection<Material> ms = mD.getAll();
			assertNotNull(ms);
			if (ms.size() != 0) {
				for (Material i : ms) {
					Collection<Car> temp = tD.getCarsByUpholstery(i);
					assertNotNull(temp);
					for (Car ii : temp) {
						assertEquals(i.getId(), ii.getUpholstery());
					}
				}
			} else {
				Collection<Car> ccs = tD.getAll();
				assertNotNull(ccs);
				assertFalse(ccs.size() != 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByLabel() {
		try {
			Collection<Label> ls = lD.getAll();
			assertNotNull(ls);
			if (ls.size() != 0) {
				for (Label i : ls) {
					Collection<Car> temp = tD.getCarsByLabel(i);
					assertNotNull(temp);
					for (Car ii : temp) {
						assertEquals(i.getId(), ii.getLabelId());
					}
				}
			} else {
				Collection<Car> ccs = tD.getAll();
				assertNotNull(ccs);
				assertFalse(ccs.size() != 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@DataProvider
	public Object[][] CarCost() {
		return new Object[][] {
				{ 1, 100000000, true },
				{ null, 100000000, true },
				{ 1, null, true },
				{ null, null, true }
		};
	}
	
	@Test(dataProvider="CarCost")
	public void getByCost(BigDecimal l, BigDecimal r) {
		try {
			Collection<Car> cs = tD.getCarsByCost(l, r);
			assertNotNull(cs);
			assertTrue(cs.size() != 0 && tD.getAll().size() != 0);
			
			for (Car i : cs) {
				if (l != null)
					assertTrue(i.getCost().compareTo(l) == 1);
				if (r != null)
					assertTrue(i.getCost().compareTo(r) != -1);
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
					Car temp = tD.getCarByOrder(i);
					assertNotNull(temp);
					Collection<Order> os = temp.getClientsOrders();
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
				Collection<Car> cs = tD.getAll();
				assertNotNull(cs);
				for (Car i : cs) {
					assertFalse(i.getClientsOrders().size() != 0);
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
					Car temp = tD.getCarByTestDrive(i);
					assertNotNull(temp);
					Collection<TestDrive> os = temp.getClientsTestDrives();
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
				Collection<Car> cs = tD.getAll();
				assertNotNull(cs);
				for (Car i : cs) {
					assertFalse(i.getClientsTestDrives().size() != 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}