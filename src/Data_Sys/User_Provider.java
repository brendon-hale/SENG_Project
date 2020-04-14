package Data_Sys;

import java.util.ArrayList;
import java.util.Arrays;

import Mgmt_Sys.Admin;
import Mgmt_Sys.Doctor;
import Mgmt_Sys.Nurse;
import Mgmt_Sys.Patient;
import Mgmt_Sys.User;

public class User_Provider {

	public ArrayList<User> getUserData(){
		
		Admin obj1 = new Admin("Brendon Hale", "1234", Constants.admin);
		Admin obj2 = new Admin("Frank Guo", "1234", Constants.admin);
		Admin obj3 = new Admin("Minh Hang Chu", "1234", Constants.admin);
		Doctor obj4 = new Doctor("Max Powers", "guest", Constants.doctor);
		Nurse obj5 = new Nurse("Scuba Steve", "guest", Constants.nurse);
		Patient obj6 = new Patient("Bob", "guest", Constants.patient);
		Patient obj7 = new Patient("Calvin", "hobbes", Constants.patient);
		Doctor obj8 = new Doctor("Greg House", "guest", Constants.doctor);
		
		ArrayList<User> list = new ArrayList<>(Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8));
		
		return list;
	}
}
