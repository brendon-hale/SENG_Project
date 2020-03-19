package Mgmt_Sys;

public class User {
	
	private String name;
	private String role;
	
	public User (String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRole() {
		return this.role;
	}

}
