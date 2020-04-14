package Mgmt_Sys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Data_Sys.Constants;
import Data_Sys.Data_Model;
import Data_Sys.Test_Results;
import Data_Sys.Test_Types;
import Data_Sys.User_Provider;
import Login_Sys.Login_System;

public class Doctor extends User {
	
	private Department department;
	
	public Data_Model dataModel;

	public Doctor(String name, String password, String role) {
		super(name, password, role);
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String toString() {
		return getName();
	}
	
	public void generateTest() {
		JComboBox<String> patients = new JComboBox<String>();
		
		// Create a list of patients
		for (int i = 0; i < dataModel.UserData.size(); i++) {
			if(dataModel.UserData.get(i).getRole() == Constants.patient)
				patients.addItem(dataModel.UserData.get(i).getName());
		}
		
		// Fill combobox w/ Test_Types
		JComboBox<String> testSelect = new JComboBox<String>();
		testSelect.setModel(new DefaultComboBoxModel<String>(Test_Types.getTypes()));
		
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
						break;
					}
					catch(NullPointerException e) {
						System.out.println("NullPointerException thrown!");
					}
				}
			}
		}
	}
	
	@SuppressWarnings("null")
	public void updateTestResults() {
		JComboBox<Patient> patients;
		JComboBox<String> testSelect = new JComboBox<String>();
		JComboBox<String> testUpdate;
		
		// Create a list of patients
		patients = new JComboBox<Patient>();
		for (int i = 0; i < dataModel.UserData.size(); i++) {
			if(dataModel.UserData.get(i).getRole() == Constants.patient)
				patients.addItem((Patient) dataModel.UserData.get(i));
		}
		
		// Update testSelect based on patient selected
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Patient patientSelected = (Patient) patients.getSelectedItem();
				testSelect.removeAllItems();
				
				for (int i = 0; i < patientSelected.getTestResults().size(); i++) {
					testSelect.addItem(patientSelected.getTestResults().get(i).getTest());
				}
			}
		};
		
		patients.addActionListener(actionListener);
		
		// Option to update test
		testUpdate = new JComboBox<String>();
		testUpdate.setModel(new DefaultComboBoxModel<String>(Test_Types.getResults()));
		
		Object [] fields = {
				"Select Patient:", patients,
				"Select Test to Update:", testSelect,
				"Select Test Result:",testUpdate
		};
		
		int option = JOptionPane.showConfirmDialog(null, fields, "Updating Test", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION) {
			Patient patientName = (Patient) patients.getSelectedItem();
			String testSelected = testSelect.getSelectedItem().toString();
			String results = testUpdate.getSelectedItem().toString();
			
			for (int i = 0; i < patientName.getTestResults().size(); i++) {
				if (patientName.getTestResults().get(i).getTest() == testSelected) {
					Tests newTest = patientName.getTestResults().get(i);
					newTest.updateResult(results);
				}
			}
		}
	}
	
	public void viewTestResults() {
		JFrame frame = new JFrame("Patient Test Results");
		JPanel mainframe = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		mainframe.add(textArea);
		
		textArea.append(Test_Results.testResults.toString());
		
		frame.getContentPane().add(mainframe);
		frame.pack();
		frame.setVisible(true);
	}

	
}
