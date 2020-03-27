package Mgmt_Sys;

import java.awt.Container;
import java.util.ArrayList;

public class Patient extends User {
	
	private ArrayList<Tests> testResults = new ArrayList<Tests>();
	
	public Patient(String name, String password, String role) {
		super(name, password, role);
	}
	
	public String returnTestResults() {
		return testResults.toString();
	}

	public ArrayList<Tests> getTestResults() {
		return testResults;
	}
	
	public void	addTestResults(Tests test){
		testResults.add(test);
	}
	
	public String toString() {
		return getName();
	}
	
	

	

	
	
	// To Implement
	
	// private Appointment appointment;
	// private TestResult results;
	
}
