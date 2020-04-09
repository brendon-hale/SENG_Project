package Mgmt_Sys;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Login_Sys.Data_Model;
import Login_Sys.Login_System;
import Login_Sys.User_Provider;

public class Admin extends User {

	public Data_Model dataModel;
	
	public Admin(String name, String password, String role) {
		super(name, password, role);
	}

	public void addUser() {
		JTextField enterName = new JTextField();
		JTextField enterPass = new JTextField();
		
		JComboBox userRole = new JComboBox();
		userRole.setModel(new DefaultComboBoxModel(new String[] {Constants.patient, Constants.nurse, Constants.doctor, Constants.admin}));
		
		Object[] fields = {
				"Enter Username:", enterName,
				"Enter Password:", enterPass,
				"Select Role:", userRole
		};
		
		int option = JOptionPane.showConfirmDialog(null, fields, "Adding New User", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION) {
			String name = enterName.getText();
			String password = enterPass.getText();
			String role = userRole.getSelectedItem().toString();
			
			User newUser = null;
			
			// Should be made into a switch
			if (role == Constants.admin)
				newUser = new Admin(name, password, role);
			
			if (role == Constants.doctor)
				newUser = new Doctor(name, password, role);
			
			if (role == Constants.nurse)
				newUser = new Nurse(name, password, role);
			
			if (role == Constants.patient)
				newUser = new Patient(name, password, role);
			
			dataModel.UserData.add(newUser);
			Login_System.dataModel = this.dataModel;
		}
	}
}
