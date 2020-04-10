package Mgmt_Sys;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Data_Sys.Constants;
import Data_Sys.Test_Results;
import Data_Sys.Test_Types;
import Login_Sys.Data_Model;
import Login_Sys.Login_System;
import Login_Sys.User_Provider;

public class Doctor extends User {

	public Doctor(String name, String password, String role) {
		super(name, password, role);
	}
	
	public void generateTest() {
		User patient;
		
		Data_Model dataModel = Login_System.dataModel;
		
		JComboBox patients = new JComboBox();
		
		// Create a list of patients
		for (int i = 0; i < dataModel.UserData.size(); i++) {
			if(dataModel.UserData.get(i).getRole() == Constants.patient)
				patients.addItem(dataModel.UserData.get(i).getName());
		}
		
		// Fill combobox w/ Test_Types
		JComboBox testSelect = new JComboBox();
		testSelect.setModel(new DefaultComboBoxModel(Test_Types.getTypes()));
		
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
			
			ArrayList<Patient> myPatients = Data_Model.getPatients();
			
			for (int i = 0; i < myPatients.size(); i++) {
				if (myPatients.get(i).getName() == patientName) {
					try {
						Patient patient1 = myPatients.get(i);
						patient1.addTestResults(tests);
						
						System.out.println("Doctor/Patient testResults: " + patient1.getTestResults());
						
						break;
					}
					catch(NullPointerException e) {
						System.out.println("NullPointerException thrown!");
					}
				}
			}
			
			// Temporary print out of ArrayList of testResults
			System.out.println(Arrays.deepToString(Test_Results.testResults.toArray()));
		
		}
	}
}
