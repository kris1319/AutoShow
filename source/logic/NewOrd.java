package logic;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class NewOrd {
	private Long number;
	private Long clientId;
	private String client;
	private Long carId;
	private Date date;
	private Boolean testdrive;
	private String status;
		
	public NewOrd() {}
	
	public NewOrd(Long n, Long ca, Long cl, String cs, Date d, Boolean t, String s) {
		this.number = n;
		this.carId = ca;
		this.clientId = cl;
		this.client = cs;
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
		this.carId = new_car;
	}
	
	public Long getCarId() {
		return carId;
	}
	
	public void setClientId(Long new_client) {
		this.clientId = new_client;
	}
	
	public Long getClientId() {
		return clientId;
	}
	
	public void setDate(Date new_date) {
		this.date = new_date;
	}
	
	public Date getDate() {
		return date;
	}

	public void setTestdrive(Boolean td) {
		this.testdrive = td;
	}
	
	public Boolean getTestdrive() {
		return testdrive;
	}
	
	public void setStatus(String new_st) {
		this.status = new_st;
	}
	
	public String getStatus() {
		return status;
	}	
	
	public void setClient(String new_st) {
		this.client = new_st;
	}
	
	public String getClient() {
		return client;
	}	
}