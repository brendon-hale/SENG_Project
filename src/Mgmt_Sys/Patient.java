package Mgmt_Sys;

import java.util.ArrayList;

public class Patient extends User {
	
	private ArrayList<Tests> testResults;
	
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
	
	public String printTestResults() {
		String test = null;
		if (testResults == null)
			test = "No Current Test Pending";
		else
			for (int i = 0; i < testResults.size(); i++)
				test = testResults.get(i).getTest() + "\t" + testResults.get(i).getResult() + "\n";
		return test;
	}
	

	
	
	// To Implement
	
	// private Appointment appointment;
	
}
