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

public class CityDAOTest extends Assert {
	private CityDAO tD = Factory.getInstance().getCityDAO();
	private ClientDAO clD = Factory.getInstance().getClientDAO();
	private CountryDAO cD = Factory.getInstance().getCountryDAO();
	
	@DataProvider
	public Object[][] CityData() {
		return new Object[][] {
				{ "x", 1, true },
				{ "x", 10000, false },
				{ "x", null, false },
				{ null, 1, false },
				{ null, null, false }
		};
	}
	
	@Test(dataProvider="CityData")
	public void DataTest(String str, Integer c, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			City obj = new City(count.intValue() + 1, str, c);

			tD.insert(obj);
			City temp = tD.getCityById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getCity(), obj.getCity());
			assertEquals(temp.getCountryId(), obj.getCountryId());
			
			obj.setCity(obj.getCity() + "eye");
			tD.update(obj);
			temp = tD.getCityById(obj.getId());
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getCity(), obj.getCity());
			assertEquals(temp.getCountryId(), obj.getCountryId());
			
			tD.delete(obj);
			temp = tD.getCityById(obj.getId());
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
	public Object[][] CityName() {
		return new Object[][] {
				{ "string", 1, true },
				{ null, 1, false }
		};
	}
	
	@Test(dataProvider="CityName")
	public void getByName(String str, Integer c, boolean expect) {
		try {
			Integer count = tD.getAll().size();
			City obj = new City(count.intValue() + 1, str, c);
			tD.insert(obj);
			
			City temp = tD.getCityByName(str);
			assertNotNull(temp);
			assertEquals(temp.getId(), obj.getId());
			assertEquals(temp.getCity(), obj.getCity());
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
	public void getByClient() {
		try {
			Collection<Client> cls = clD.getAll();
			assertNotNull(cls);
			if (cls.size() != 0) {
				for (Client i : cls) {
					City temp = tD.getCityByClient(i);
					assertNotNull(temp);
					Collection<Client> cs = temp.getClients();
					assertNotNull(temp);
					assertTrue(cs.size() != 0);
					
					boolean f = false;
					for (Client ii : cs) {
						if (ii.getId() == i.getId()) {
							f = true;
							break;
						}
					}
					
					assertTrue(f);
				}
			} else {
				Collection<City> cs = tD.getAll();
				assertNotNull(cs);
				for (City i : cs) {
					assertFalse(i.getClients().size() != 0);
				}
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}

	@Test
	public void getByCountry() {
		try {
			Collection<Country> cts = cD.getAll();
			assertNotNull(cts);
			if (cts.size() != 0) {
				for (Country i : cts) {
					Collection<City> temps = tD.getCitiesByCountry(i);
					assertNotNull(temps);
					
					for (City ii : temps) {
						assertEquals(i.getId(), ii.getCountryId());						
					}
				}
			} else {
				Collection<City> cs = tD.getAll();
				assertNotNull(cs);
				assertTrue(cs.size() == 0);
			}
		} catch (SQLException ex) {
			assertFalse(true);
		}
	}
}