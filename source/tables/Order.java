package logic;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.HashSet;

public class Order {
	private Long number;
	private Long car_id;
	private Long client_id;
	private SimpleDateFormat date;
	private Boolean testdrive;
	private Integer status;
	
	public Order() {}
	
	public Order(Long n, Long ca, Long cl, SimpleDateFormat d, Boolean t, Integer s) {
		this.number = n;
		this.car_id = ca;
		this.client_id = cl;
		this.date = d;
		this.testdrive = t;
		this.status = s;
	}
	
	public void setNumber(Long new_number) {
		this.number = new_number;
	}
	
	public Long getNumber() {
		return number;
	}
	
	public void setCarId(Long new_car) {
		this.car_id = new_car;
	}
	
	public Long getCarId() {
		return car_id;
	}
	
	public void setClientId(Long new_client) {
		this.client_id = new_client;
	}
	
	public Long getClientId() {
		return client_id;
	}
	
	public void setDate(SimpleDateFormat new_date) {
		this.date = new_date;
	}
	
	public SimpleDateFormat getDate() {
		return date;
	}

	public void setTestDrive(Boolean td) {
		this.testdrive = td;
	}
	
	public Boolean getTestDrive() {
		return testdrive;
	}
	
	public void setStatus(Integer new_st) {
		this.status = new_st;
	}
	
	public Integer getStatus() {
		return status;
	}
}