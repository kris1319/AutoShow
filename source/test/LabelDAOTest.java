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

public class LabelDAOTest extends Assert {
	private LabelDAO tD = Factory.getInstance().getLabelDAO();
	private ManufacturerDAO mD = Factory.getInstance().getManufacturerDAO();
	private CarDAO cD = Factory.getInstance().getCarDAO();
	
	@DataProvider
	public Object[][] LabelData() {
		return new Object[][] {
				{ "x", 1, true },
				{ "x", 1000, false },
				{ null, 1, false },
				{ "x", null, false },
				{ null, null, false }
		};
	}
	
	@Test(dataProvider="LabelData")
	public void DataTest(String str, Integer m, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Label obj = new Label(count.intValue() + 1, str, m);

			tD.insert(obj);
			Label temp = tD.getLabelById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getName(), obj.getName());
			assertEquals(temp.getFactureId(), obj.getFactureId());
			
			obj.setName(obj.getName() + "eye");
			tD.update(obj);
			temp = tD.getLabelById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getName(), obj.getName());
			assertEquals(temp.getFactureId(), obj.getFactureId());
			
			tD.delete(obj);
			temp = tD.getLabelById(obj.getId());
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
	public Object[][] LabelName() {
		return new Object[][] {
				{ "string", 1, true },
				{ null, 1, false }
		};
	}
	
	@Test(dataProvider="LabelName")
	public void getByName(String str, Integer m, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Label obj = new Label(count.intValue() + 1, str, m);
			tD.insert(obj);
			
			Label temp = tD.getLabelByName(str);
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getName(), obj.getName());
			assertEquals(temp.getFactureId(), obj.getFactureId());
			
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
	public void getByManufacturer() {
		try {
			Collection<Manufacturer> mans = mD.getAll();
			assertNotNull(mans);
			if (mans.size() != 0) {
				for (Manufacturer i : mans) {
					Collection<Label> labs = tD.getLabelsByManufacturer(i);
					assertNotNull(labs);
					
					for (Label ii : labs) {
						assertEquals(i.getId(), ii.getFactureId());
					}
				}
			} else {
				Collection<Label> cs = tD.getAll();
				assertNotNull(cs);
				assertTrue(cs.size() == 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByCar() {
		try {
			Collection<Car> cars = cD.getAll();
			assertNotNull(cars);
			if (cars.size() != 0) {
				for (Car i : cars) {					
					Label temp = tD.getLabelByCar(i);
					assertNotNull(temp);
					Collection<Car> cs = temp.getCars();
					assertNotNull(cs);
					assertTrue(cs.size() != 0);
					
					boolean f = false;
					for (Car ii : cs) {
						if (ii.getRegNumber() == i.getRegNumber()) {
							f = true;
							break;
						}
					}
					
					assertTrue(f);
				}
			} else {
				Collection<Label> cs = tD.getAll();
				assertNotNull(cs);
				for (Label i : cs) {
					assertTrue(i.getCars().size() == 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}