package logic;

import java.util.Set;
import java.util.HashSet;

public class City {
	private Integer id;
	private String city;
	private Integer country_id;
	private Set clients = new HashSet();
	
	public City() {}
	
	public City(Integer i, String n, Integer c) {
		this.id = i;
		this.city = n;
		this.country_id = c;
	}
	
	public void setId(Integer new_id) {
		this.id = new_id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setCity(String new_city) {
		this.city = new_city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCountryId(Integer new_country_id) {
		this.country_id = new_country_id;
	}
	
	public Integer getCountryId() {
		return country_id;
	}
	
	public void setClients(Set new_client) {
		this.clients = new_client;
	}
	
	public Set getClients() {
		return clients;
	}
}

