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

public class CountryDAOTest extends Assert {
	private CountryDAO tD = Factory.getInstance().getCountryDAO();
	private ManufacturerDAO mD = Factory.getInstance().getManufacturerDAO();
	private CityDAO cD = Factory.getInstance().getCityDAO();
	
	@DataProvider
	public Object[][] CountryData() {
		return new Object[][] {
				{ "x", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="CountryData")
	public void DataTest(String str, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Country obj = new Country(count.intValue() + 1, str);

			tD.insert(obj);
			Country temp = tD.getCountryById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getCountry(), obj.getCountry());
			
			obj.setCountry(obj.getCountry() + "eye");
			tD.update(obj);
			temp = tD.getCountryById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getCountry(), obj.getCountry());
			
			tD.delete(obj);
			temp = tD.getCountryById(obj.getId());
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
	public Object[][] CountryName() {
		return new Object[][] {
				{ "string", true },
				{ null, false }
		};
	}
	
	@Test(dataProvider="CountryName")
	public void getByName(String str, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			Country obj = new Country(count.intValue() + 1, str);
			tD.insert(obj);
			
			Country temp = tD.getCountryByName(str);
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getCountry(), obj.getCountry());
			
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
					Country temp = tD.getCountryByManufacturer(i);
					assertNotNull(temp);
					Collection<Manufacturer> ms = temp.getManufacturers();
					assertNotNull(ms);
					assertTrue(ms.size() != 0);
					
					boolean f = false;
					for (Manufacturer ii : ms) {
						if (ii.getId() == i.getId()) {
							f = true;
							break;
						}
					}
					
					assertTrue(f);
				}
			} else {
				Collection<Country> cs = tD.getAll();
				assertNotNull(cs);
				for (Country i : cs) {
					assertFalse(i.getManufacturers().size() != 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByCity() {
		try {
			Collection<City> cits = cD.getAll();
			assertNotNull(cits);
			if (cits.size() != 0) {
				for (City i : cits) {
					Country temp = tD.getCountryByCity(i);
					assertNotNull(temp);
					Collection<City> cs = temp.getCities();
					assertNotNull(temp);
					assertTrue(cs.size() != 0);
					
					boolean f = false;
					for (City ii : cs) {
						if (ii.getId() == i.getId()) {
							f = true;
							break;
						}
					}
					
					assertTrue(f);
				}
			} else {
				Collection<Country> cs = tD.getAll();
				assertNotNull(cs);
				for (Country i : cs) {
					assertFalse(i.getCities().size() != 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}