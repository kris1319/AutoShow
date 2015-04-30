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

public class ManufacturerDAOTest extends Assert {
	private ManufacturerDAO tD = Factory.getInstance().getManufacturerDAO();
	private LabelDAO lD = Factory.getInstance().getLabelDAO();
	private CountryDAO cD = Factory.getInstance().getCountryDAO();
	
	@DataProvider
	public Object[][] ManufacturerData() {
		return new Object[][] {
				{ "x", 1, true },
				{ "x", 1000, false },
				{ null, 1, false },
				{ null, null, false }
		};
	}
	
	@Test(dataProvider="ManufacturerData")
	public void DataTest(String str, Integer c, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Manufacturer obj = new Manufacturer(count.intValue() + 1, str, c);

			tD.insert(obj);
			Manufacturer temp = tD.getManufactById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getName(), obj.getName());
			assertEquals(temp.getCountryId(), obj.getCountryId());
			
			obj.setName(obj.getName() + "eye");
			tD.update(obj);
			temp = tD.getManufactById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getName(), obj.getName());
			assertEquals(temp.getCountryId(), obj.getCountryId());
			
			tD.delete(obj);
			temp = tD.getManufactById(obj.getId());
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
	public Object[][] ManufacturerName() {
		return new Object[][] {
				{ "string", 1, true },
				{ null, 1, false }
		};
	}
	
	@Test(dataProvider="ManufacturerName")
	public void getByName(String str, Integer c, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Manufacturer obj = new Manufacturer(count.intValue() + 1, str, c);
			tD.insert(obj);
			
			Manufacturer temp = tD.getManufactByName(str);
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getName(), obj.getName());
			assertEquals(temp.getCountryId(), obj.getCountryId());
			
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
	public void getByLabel() {
		try {
			Collection<Label> labs = lD.getAll();
			assertNotNull(labs);
			if (labs.size() != 0) {
				for (Label i : labs) {
					Manufacturer temp = tD.getManufactByLabel(i);
					assertNotNull(temp);
					Collection<Label> ls = temp.getLabels();
					assertNotNull(ls);
					assertTrue(ls.size() != 0);
					
					boolean f = false;
					for (Label ii : ls) {
						if (ii.getId() == i.getId()) {
							f = true;
							break;
						}
					}
					assertTrue(f);
				}
			} else {
				Collection<Manufacturer> ms = tD.getAll();
				assertNotNull(ms);
				for (Manufacturer i : ms) {
					assertTrue(i.getLabels().size() == 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByCountry() {
		try {
			Collection<Country> ctrs = cD.getAll();
			assertNotNull(ctrs);
			if (ctrs.size() != 0) {
				for (Country i : ctrs) {
					Collection<Manufacturer> temp = tD.getManufactsByCountry(i);
					assertNotNull(temp);
					for (Manufacturer ii : temp) {
						assertEquals(i.getId(), ii.getCountryId());
					}
				}
			} else {
				Collection<Manufacturer> cs = tD.getAll();
				assertNotNull(cs);
				assertFalse(cs.size() != 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}