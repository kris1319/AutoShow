package logic;

import java.util.Set;
import java.util.HashSet;

public class Colour {
	private Integer id;
	private String colour;
	private Set cars = new HashSet();
	
	public Colour() {}
	
	public Colour(Integer new_id, String col) {
		this.id = new_id;
		this.colour = col;
	}
	
	public void setId(Integer new_id) {
		this.id = new_id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setColour(String new_col) {
		this.colour = new_col;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setCars(Set new_car) {
		this.cars = new_car;
	}
	
	public Set getCars() {
		return cars;
	}
}

