package Mgmt_Sys;

import java.util.ArrayList;


public class Department {
	
	private String departmentName;
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();

	public Department (String departmentName) {
		this.departmentName = departmentName;
	}
		
	public String getName() {
		return departmentName;
	}
	
	public ArrayList<Doctor> getDoctors(){
		return doctors;
	}
	
	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
	
	public String toString() {
		String results = null;
		if (doctors.size() == 0)
			return departmentName + ": " + "No Doctors Assigned" + "\n";
		else {
			results = departmentName + ": ";
			for(Doctor doc : doctors) {
				results += doc.toString() + "\n";
			}
			return results;
		}
	}
}