package Mgmt_Sys;

import Data_Sys.Constants;

public class Department_Types {

	static String[] types = {Constants.radio, Constants.cardio, Constants.mat, Constants.er, Constants.burn};
	
	public static String[] getTypes() {
		return types;
	}
	
}