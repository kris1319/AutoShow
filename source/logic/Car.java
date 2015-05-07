package logic;

import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.util.Set;
import java.util.HashSet;

public class Car {
	private Long reg_number;
	private Integer label_id;
	private String model; 
	private BigDecimal cost;
	private Integer colour_id;
	private Integer upholstery;
	private Set<Order> orders = new HashSet<Order>();
	private Set<TestDrive> testdrives = new HashSet<TestDrive>();
	
	public Car() {}
	
	public Car(Long rn, Integer l, String m, BigDecimal c, Integer col, Integer up) {
		this.reg_number = rn;
		this.label_id = l;
		this.cost = c;
		this.colour_id = col;
		this.model = m;
		this.upholstery = up;
	}
	
	public void setRegNumber(Long new_num) {
		this.reg_number = new_num;
	}
	
	public Long getRegNumber() {
		return reg_number;
	}
	
	public void setLabelId(Integer new_lab) {
		this.label_id = new_lab;
	}
	
	public Integer getLabelId() {
		return label_id;
	}
	
	public void setModel(String s) {
		this.model = s;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setCost(BigDecimal new_cost) {
		this.cost = new_cost;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setColourId(Integer new_col) {
		this.colour_id = new_col;
	}
	
	public Integer getColourId() {
		return colour_id;
	}
	
	public void setUpholstery(Integer new_uph) {
		this.upholstery = new_uph;
	}
	
	public Integer getUpholstery() {
		return upholstery;
	}
	
	public void setOrders(Set<Order> new_ord) {
		this.orders = new_ord;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setTestdrives(Set<TestDrive> new_td) {
		this.testdrives = new_td;
	}
	
	public Set<TestDrive> getTestdrives() {
		return testdrives;
	}
}

