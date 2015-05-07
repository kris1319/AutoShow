package logic;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.HashSet;

public class TestDrive {
	private Long number;
	private Long car_id;
	private Long client_id;
	private Date date;
	private String feedback;
	
	public TestDrive() {}
	
	public TestDrive(Long n, Long c, Long l, Date d, String f) {
		this.number = n;
		this.car_id = c;
		this.client_id = l;
		this.date = d;
		this.feedback = f;
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
	
	public void setDate(Date new_date) {
		this.date = new_date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setFeedback(String new_msg) {
		this.feedback = new_msg;
	}
	
	public String getFeedback() {
		return feedback;
	}
}

