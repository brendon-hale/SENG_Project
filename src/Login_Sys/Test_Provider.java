package Login_Sys;

import java.util.ArrayList;
import java.util.Arrays;
import Mgmt_Sys.User;

public class Test_Provider {

	public ArrayList<User> getUserData(){
		
		User obj1 = new User("Brendon Hale", "1234", "Administrator");
		User obj2 = new User("Frank Guo", "1234", "Administrator");
		User obj3 = new User("Minh Hang Chu", "1234", "Administrator");
		User obj4 = new User("Max Powers", "guest", "Doctor");
		User obj5 = new User("Scuba Steve", "guest", "Nurse");
		User obj6 = new User("Bob", "guest", "Patient");
		
		ArrayList<User> list = new ArrayList<>(Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6));
		
		return list;
	}
	
}
