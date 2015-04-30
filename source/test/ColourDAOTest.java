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

public class ColourDAOTest extends Assert {
	private ColourDAO cD = Factory.getInstance().getColourDAO();
	private CarDAO carD = Factory.getInstance().getCarDAO();
	
	@DataProvider
	public Object[][] ColourData() {
		return new Object[][] {
				{ "x", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="ColourData")
	public void DataTest(String str, boolean expect) {
		try {
			Integer count = cD.getAll().size();
			Colour col = new Colour(count.intValue() + 1, str);
			
			cD.insert(col);
			Colour temp = cD.getColourById(col.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), col.getId());
			assertEquals(temp.getColour(), col.getColour());
			
			col.setColour(col.getColour() + "eye");
			cD.update(col);
			temp = cD.getColourById(col.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), col.getId());
			assertEquals(temp.getColour(), col.getColour());
			
			cD.delete(col);
			temp = cD.getColourById(col.getId());
			assertNull(temp);
			
			assertEquals(cD.getAll().size(), count.intValue());
			assertTrue(expect);
		} catch (HibernateException ex) {
			//System.out.println(ex.toString());
			assertFalse(expect);
		} catch (SQLException ex) {
			assertFalse(expect);
		}
	}

	@DataProvider
	public Object[][] ColourName() {
		return new Object[][] {
				{ "string", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="ColourName")
	public void getByName(String str, boolean expect) {
		try {
			Integer count = cD.getAll().size();
			Colour obj = new Colour(count.intValue() + 1, str);
			cD.insert(obj);
			
			Colour temp = cD.getColourByName(str);
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getColour(), obj.getColour());
			
			cD.delete(obj);
			assertEquals(cD.getAll().size(), count.intValue());
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
			//Integer count = carD.getAll().size();
			//System.out.print(count);
			Collection<Car> cars = carD.getAll();
			assertNotNull(cars);
			if (cars.size() != 0) {
				for (Car ic : cars) {
					Colour temp = cD.getColourByCar(ic);
					assertNotNull(temp);
						
					Set<Car> ccs = temp.getCars();
					assertTrue(ccs.size() != 0);
					boolean f = false;
					for (Car iic : ccs) {
						if (iic.getRegNumber() == ic.getRegNumber()) {
							f = true;
							break;
						}
					}
						
					assertTrue(f);
				}
			} else {
				boolean f = false;
				Collection<Colour> cols = cD.getAll();
				for (Colour ic : cols) {
					if (ic.getCars().size() != 0) {
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