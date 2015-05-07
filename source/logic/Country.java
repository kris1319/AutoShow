package logic;

import java.util.Set;
import java.util.HashSet;

public class Country {
	private Integer id;
	private String country;
	private Set<City> cities = new HashSet<City>();
	private Set<Manufacturer> manufacturers = new HashSet<Manufacturer>();
	
	public Country() {}
	
	public Country(Integer i, String c) {
		this.id = i;
		this.country = c;
	}
	
	public void setId(Integer new_id) {
		this.id = new_id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setCountry(String new_country) {
		this.country = new_country;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCities(Set new_ct) {
		this.cities = new_ct;
	}
	
	public Set getCities() {
		return cities;
	}
	
	public void setManufacturers(Set new_man) {
		this.manufacturers = new_man;
	}
	
	public Set<Manufacturer> getManufacturers() {
		return manufacturers;
	}
}

