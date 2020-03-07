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
	
	@Override
		public boolean equals(Object obj) {
			User_Data user = (User_Data) obj;
			
			System.out.println("Here");
			
			if (this.name != user.name) {
				System.out.println("username is false");
				return false;
			}
			if (this.password != user.password)
				return false;
			if (this.userRole != user.getRole())
				return false;
			
			return true;
		}
}

public class Test {
	
	User_Data obj1 = new User_Data("Brendon Hale", "Derp", "Doctor");
	User_Data obj2 = new User_Data("Scuba Steve", "1234", "Patient");
	User_Data obj3 = new User_Data("Max Powers", "password", "Nurse");
	User_Data obj4 = new User_Data("Admin", "guest", "Administrator");
	
	ArrayList<User_Data> list = new ArrayList<>(Arrays.asList(obj1,obj2,obj3,obj4));
	
	public ArrayList<User_Data> getList() {
		return list;
	}
}
