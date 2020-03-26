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
	
	public String toString() {
		return patientName + "\t" + test + "\t" + result;
	}

}
