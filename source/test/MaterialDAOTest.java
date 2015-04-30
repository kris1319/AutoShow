package test;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

import logic.*;
import DAO.*;

public class MaterialDAOTest extends Assert {
	private MaterialDAO tD = Factory.getInstance().getMaterialDAO();
	private CarDAO cD = Factory.getInstance().getCarDAO();
	
	@DataProvider
	public Object[][] MaterialData() {
		return new Object[][] {
				{ "x", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="MaterialData")
	public void DataTest(String str, boolean expect) {
		try {
			Material obj = new Material(1, str);
			Integer count = tD.getAll().size();

			tD.insert(obj);
			Material temp = tD.getMaterialById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getMaterial(), obj.getMaterial());
			
			obj.setMaterial(obj.getMaterial() + "eye");
			tD.update(obj);
			temp = tD.getMaterialById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getMaterial(), obj.getMaterial());
			
			tD.delete(obj);
			temp = tD.getMaterialById(obj.getId());
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
	public Object[][] MaterialName() {
		return new Object[][] {
				{ "string234", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="MaterialName")
	public void getByName(String str, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Material m = new Material(count.intValue() + 1, str);
			
			tD.insert(m);
			Material temp = tD.getMaterialByName(str);
			assertEquals(temp.getMaterial(), m.getMaterial());
			assertEquals(temp.getId(), m.getId());
			
			tD.delete(temp);
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
			Collection<Car> cars = cD.getAll();
			assertNotNull(cars);
			if (cars.size() != 0) {
				for (Car i : cars) {
					Material temp = tD.getMaterialByCar(i);
					assertNotNull(temp);
					Collection<Car> cs = temp.getCars();
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
				boolean f = false;
				Collection<Material> ms = tD.getAll();
				for (Material i : ms) {
					if (i.getCars().size() != 0) {
						f = true;
						break;
					}
				}
				assertFalse(f);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}