package Mgmt_Sys;

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
	
	public void addTestResults(Tests test) {
		testResults.add(test);
	}
	
	public String toString() {
		return getName();
	}
	
	public String printTestResults() {
		String test = "No Test Results Pending";
		
		if (testResults != null) {
			test = "";
			for (int i = 0; i < testResults.size(); i++) {
				test = test + testResults.get(i).toString() + "\n";
			}
		}
		
		return test;
	}
}