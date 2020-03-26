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
		
//		Data_Model dataModel = new Data_Model();
//		Test_Provider provider = new Test_Provider();
//		dataModel.UserData = provider.getUserData();
		
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
			
		}
	}
	
	
//	public void addUser() {
//		JTextField enterName = new JTextField();
//		JTextField enterPass = new JTextField();
//		
//		JComboBox userRole = new JComboBox();
//		userRole.setModel(new DefaultComboBoxModel(new String[] {Constants.patient, Constants.nurse, Constants.doctor, Constants.admin}));
//		
//		Object[] fields = {
//				"Enter Username:", enterName,
//				"Enter Password:", enterPass,
//				"Select Role:", userRole
//		};
//		
//		int option = JOptionPane.showConfirmDialog(null, fields, "Adding New User", JOptionPane.OK_CANCEL_OPTION);
//		
//		if (option == JOptionPane.OK_OPTION) {
//			String name = enterName.getText();
//			String password = enterPass.getText();
//			String role = userRole.getSelectedItem().toString();
//			
//			User newUser = new User(name, password, role);
//			
//			dataModel.UserData.add(newUser);
//			Login_System.dataModel = this.dataModel;
//			
//			System.out.println(Arrays.deepToString(dataModel.UserData.toArray()));
//			System.out.println(Arrays.deepToString(Login_System.dataModel.UserData.toArray()));
//		}
//	}
	
	
	// To Implement
	
	//private Schedule schedule;
	//private String department;
	
}
