package Login_Sys;

import java.util.ArrayList;
import java.util.Arrays;

class User_Data {

	public String name = "";
	public String password = "";
	public String userRole = "";
	
	public User_Data (String name, String password, String userRole) {
		this.name = name;
		this.password = password;
		this.userRole = userRole;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRole() {
		return this.userRole;
	}
}

public class User_List {
	
	User_Data obj1 = new User_Data("Brendon Hale", "Derp", "Doctor");
	User_Data obj2 = new User_Data("Scuba Steve", "1234", "Patient");
	User_Data obj3 = new User_Data("Max Powers", "password", "Nurse");
	User_Data obj4 = new User_Data("Admin", "guest", "Administrator");
	User_Data obj5 = new User_Data("Login", "1234", "Patient");
	
	ArrayList<User_Data> list = new ArrayList<>(Arrays.asList(obj1,obj2,obj3,obj4,obj5));
	
	public ArrayList<User_Data> getList() {
		return list;
	}
}