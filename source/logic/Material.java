package logic;

import java.util.Set;
import java.util.HashSet;

public class Material {
	private Integer id;
	private String material;
	private Set<Car> cars = new HashSet<Car>();
	
	public Material() {}
	
	public Material(Integer new_id, String str) {
		id = new_id;
		material = str;
	}
	
	public void setId(Integer new_id) {
		this.id = new_id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setMaterial(String new_m) {
		this.material = new_m;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setCars(Set<Car> new_car) {
		this.cars = new_car;
	}
	
	public Set<Car> getCars() {
		return cars;
	}
}

