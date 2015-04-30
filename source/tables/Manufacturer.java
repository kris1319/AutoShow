package logic;

import java.util.Set;
import java.util.HashSet;

public class Manufacturer {
	private Integer id;
	private String name;
	private Integer country_id;
	private Set<Label> labels = new HashSet<Label>();
	
	public Manufacturer() {}
	
	public Manufacturer(Integer i, String n, Integer c) {
		this.id = i;
		this.name = n;
		this.country_id = c;
	}
	
	public void setId(Integer new_id) {
		this.id = new_id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String new_name) {
		this.name = new_name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCountryId(Integer new_country_id) {
		this.country_id = new_country_id;
	}
	
	public Integer getCountryId() {
		return country_id;
	}
	
	public void setLabels(Set<Label> new_lab) {
		this.labels = new_lab;
	}
	
	public Set<Label> getLabels() {
		return labels;
	}
}

