package logic;

import java.util.Set;
import java.util.HashSet;

public class Label {
	private Integer id;
	private String name;
	private Integer facture_id;
	private Set cars = new HashSet();
	
	public Label() {}
	
	public Label(Integer i, String str, Integer f) {
		this.id = i;
		this.name = str;
		this.facture_id = f;
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
	
	public void setFactureId(Integer new_facture_id) {
		this.facture_id = new_facture_id;
	}
	
	public Integer getFactureId() {
		return facture_id;
	}
	
	public void setCars(Set new_car) {
		this.cars = new_car;
	}
	
	public Set getCars() {
		return cars;
	}
}

