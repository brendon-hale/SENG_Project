package Mgmt_Sys;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Login_Sys.Data_Model;
import Login_Sys.Login_System;
import Login_Sys.Test_Provider;

public class Doctor extends User {

	public Doctor(String name, String password, String role) {
		super(name, password, role);
	}
	
	public void generateTest() {
		User patient;
		
		Data_Model dataModel = Login_System.dataModel;
		
		JComboBox patients = new JComboBox();
		
		for (int i = 0; i < dataModel.UserData.size(); i++) {
			if(dataModel.UserData.get(i).getRole() == Constants.patient)
				patients.addItem(dataModel.UserData.get(i).getName());
		}
		
		JComboBox testSelect = new JComboBox();
		testSelect.setModel(new DefaultComboBoxModel(new String[] {Constants.bp, Constants.cancer}));
		
		Object [] fields = {
				"Select Patient:", patients,
				"Select Test to Preform:", testSelect
		};
		
		int option = JOptionPane.showConfirmDialog(null, fields, "Performing Test", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION) {
			String patientName = patients.getSelectedItem().toString();
			String testSelected = testSelect.getSelectedItem().toString();
			String results = Constants.review;
			
			Tests tests = new Tests(patientName, testSelected, results);
			
			Test_Results.testResults.add(tests);		
			
			for (int i = 0; i < Data_Model.UserData.size(); i++) {
				if(Data_Model.UserData.get(i) instanceof Patient) {
					((Patient) Data_Model.UserData.get(i)).addTestResults(tests);
				}
			}
			
			// Temporary print out of ArrayList of testResults
			System.out.println(Arrays.deepToString(Test_Results.testResults.toArray()));
		
		}
	}
	
		
	
	// To Implement
	
	//private Schedule schedule;
	//private String department;
	
}
