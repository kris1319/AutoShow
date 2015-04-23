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
	private Specifications specifications;
	private Set clients_orders = new HashSet();
	private Set clients_testdrives = new HashSet();
	
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
	
	public void setSpecifications(Specifications new_sp) {
		this.specifications = new_sp;
	}
	
	public Specifications getSpecifications() {
		return specifications;
	}
	
	public void setClientsOrders(Set new_ord) {
		this.clients_orders = new_ord;
	}
	
	public Set getClientsOrders() {
		return clients_orders;
	}
	
	public void setClientsTestDrives(Set new_td) {
		this.clients_testdrives = new_td;
	}
	
	public Set getClientsTestDrives() {
		return clients_testdrives;
	}
}

