package logic;

import java.util.Set;
import java.util.HashSet;

public class Status {
	private Integer id;
	private String status;
	private Set orders = new HashSet();
	
	public Status() {}
	
	public Status(Integer new_id, String str) {
		this.id = new_id;
		this.status = str;
	}
	
	public void setId(Integer new_id) {
		this.id = new_id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setStatus(String new_st) {
		this.status = new_st;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setOrders(Set new_ord) {
		this.orders = new_ord;
	}
	
	public Set getOrders() {
		return orders;
	}
}

