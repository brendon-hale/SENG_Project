package Data_Sys;

import java.util.ArrayList;

import Mgmt_Sys.Department;
import Mgmt_Sys.Doctor;
import Mgmt_Sys.Patient;
import Mgmt_Sys.User;

public class Data_Model {

	public static ArrayList<User> UserData;
	
	public static ArrayList<Department> DepartmentData;
	
	public static ArrayList<Patient> getPatients(){
		ArrayList<Patient> patient = new ArrayList<Patient>();
		for (int i = 0; i < UserData.size(); i++) {
			if (UserData.get(i) instanceof Patient) {
				patient.add((Patient) UserData.get(i));
			}
		}
	return patient;
	}
	
	public static ArrayList<Doctor> getDoctor(){
		ArrayList<Doctor> doctor = new ArrayList<Doctor>();
		for (int i = 0; i < UserData.size(); i++) {
			if (UserData.get(i) instanceof Doctor) {
				doctor.add((Doctor) UserData.get(i));
			}
		}
	return doctor;
	}
}