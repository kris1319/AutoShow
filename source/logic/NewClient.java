package logic;

import java.util.Set;
import java.util.HashSet;

public class NewClient {
	private Long id;
	private String firstName;
	private String lastName;
	private String location;
	private String address;
	private String email;
	private String phone;
	
	public NewClient() {}
	
	public NewClient(Long i, String fn, String ln, String l, String a, String e, String p) {
		this.id = i;
		this.firstName = fn;
		this.lastName = ln;
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
	
	public void setLocation(String new_loc) {
		this.location = new_loc;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setFirstName(String new_name) {
		this.firstName = new_name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String new_name) {
		this.lastName = new_name;
	}
	
	public String getLastName() {
		return lastName;
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
}

