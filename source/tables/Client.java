package logic;

import java.util.Set;
import java.util.HashSet;

public class Client {
	private Long id;
	private String first_name;
	private String last_name;
	private Integer location;
	private String address;
	private String email;
	private String phone;
	private Set<Order> orders = new HashSet<Order>();
	private Set<TestDrive> testdrives = new HashSet<TestDrive>(); 
	
	public Client() {}
	
	public Client(Long i, String fn, String ln, Integer l, String a, String e, String p) {
		this.id = i;
		this.first_name = fn;
		this.last_name = ln;
		this.location = l;
		this.address = a;
		this.email = e;
		this.phone = p;
	}
	
	public void setId(Long new_id) {
		this.id = new_id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setLocation(Integer new_loc) {
		this.location = new_loc;
	}
	
	public Integer getLocation() {
		return location;
	}
	
	public void setFirstName(String new_name) {
		this.first_name = new_name;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setLastName(String new_name) {
		this.last_name = new_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setAddress(String new_addr) {
		this.address = new_addr;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setEmail(String new_email) {
		this.email = new_email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPhone(String new_phone) {
		this.phone = new_phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setOrders(Set new_ord) {
		this.orders = new_ord;
	}
	
	public Set getOrders() {
		return orders;
	}
	
	public void setTestdrives(Set new_td) {
		this.testdrives = new_td;
	}
	
	public Set getTestdrives() {
		return testdrives;
	}
}

