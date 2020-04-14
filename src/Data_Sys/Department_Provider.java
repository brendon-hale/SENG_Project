package Data_Sys;

import java.util.ArrayList;
import java.util.Arrays;

import Mgmt_Sys.Department;

public class Department_Provider {
	
	public ArrayList<Department> getDepartmentData(){
		
		Department obj1 = new Department(Constants.radio);
		Department obj2 = new Department(Constants.cardio);
		Department obj3 = new Department(Constants.mat);
		Department obj4 = new Department(Constants.er);
		Department obj5 = new Department(Constants.burn);
		
		ArrayList<Department> list = new ArrayList<Department>(Arrays.asList(obj1, obj2, obj3, obj4, obj5));
		
		return list;
	}

}


