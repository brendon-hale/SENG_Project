package Mgmt_Sys;

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

	public void viewDepartments() {
		JFrame frame = new JFrame("Department List");
		JPanel mainframe = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		mainframe.add(textArea);
		
		textArea.append(dataModel.DepartmentData.toString());
		
		frame.getContentPane().add(mainframe);
		frame.pack();
		frame.setVisible(true);	
	}

	public void assignDoctor() {
		Doctor doctor = null;
		Department department = null;
		
		String[] dept = new String[dataModel.DepartmentData.size()];
		for (int i = 0; i < dept.length; i++) {
			dept[i] = dataModel.DepartmentData.get(i).getName();
		}
		JComboBox departments = new JComboBox(dept);
		
		String[] doc = new String[dataModel.getDoctor().size()];
		for (int i = 0; i < doc.length; i++) {
			doc[i] = dataModel.getDoctor().get(i).getName();
		}
		JComboBox doctors = new JComboBox(doc);
		
		Object [] fields = {
				"Select Department:", departments,
				"Select Doctor:", doctors
		};
		
		int option = JOptionPane.showConfirmDialog(null, fields, "Assigning Doctor", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION) {
			String deptSelected = departments.getSelectedItem().toString();
			String docSelected = doctors.getSelectedItem().toString();
			
			for (int i = 0; i < dataModel.getDoctor().size(); i++) {
				if (docSelected == dataModel.getDoctor().get(i).getName()) {
					doctor = dataModel.getDoctor().get(i);
					break;
				}
			}
			
			for (int i = 0; i < dataModel.DepartmentData.size(); i++) {
				if (deptSelected == dataModel.DepartmentData.get(i).getName()) {
					department = dataModel.DepartmentData.get(i);
				}
			}
			
			doctor.setDepartment(department);
			department.addDoctor(doctor);
			
		}
		
		Login_System.dataModel = this.dataModel;
		
	}
}
