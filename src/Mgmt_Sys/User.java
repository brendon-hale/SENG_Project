package Mgmt_Sys;

import Login_Sys.Data_Model;

public class User {
	
	private String name;
	private String role;
	private String password;
//	public Data_Model dataModel;


	
	public User (String name, String password, String role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRole() {
		return this.role;
	}

	public String getPass() {
		return this.password;
	}

}
