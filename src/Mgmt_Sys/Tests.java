package Mgmt_Sys;

public class Tests {
	
	private String patientName;
	private String test;
	private String result;
	
	public Tests (String patientName, String test, String result) {
		this.patientName = patientName;
		this.test = test;
		this.result = result;
	}
	
	public String getName() {
		return patientName;
	}
	
	public String getTest() {
		return test;
	}
	
	public String getResult() {
		return result;
	}
	
	public void updateResult(String result) {
		this.result = result;
	}
	
	public String toString() {
		if (test == null)
			return "No Tests Pending";
		else
			return patientName + ": " + test + "\t- " + result + "\n";
	}
	
}