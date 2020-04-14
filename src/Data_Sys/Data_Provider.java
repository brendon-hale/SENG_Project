package Data_Sys;

import java.util.ArrayList;

import Mgmt_Sys.Department;
import Mgmt_Sys.User;

public interface Data_Provider {

	public ArrayList<User> getUserData();
	
	public ArrayList<Department> getDepartmentData();
	
}
