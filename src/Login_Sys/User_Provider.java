package Login_Sys;

import java.util.ArrayList;
import java.util.Arrays;

import Data_Sys.Constants;
import Mgmt_Sys.Admin;
import Mgmt_Sys.Doctor;
import Mgmt_Sys.Nurse;
import Mgmt_Sys.Patient;
import Mgmt_Sys.User;

public class User_Provider {

	public ArrayList<User> getUserData(){
		
		Admin obj1 = new Admin("Brendon Hale", "1234", "Administrator");
		Admin obj2 = new Admin("Frank Guo", "1234", "Administrator");
		Admin obj3 = new Admin("Minh Hang Chu", "1234", "Administrator");
		Doctor obj4 = new Doctor("Max Powers", "guest", "Doctor");
		Nurse obj5 = new Nurse("Scuba Steve", "guest", "Nurse");
		Patient obj6 = new Patient("Bob", "guest", "Patient");
		
		ArrayList<User> list = new ArrayList<>(Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6));
		
		return list;
	}
}
