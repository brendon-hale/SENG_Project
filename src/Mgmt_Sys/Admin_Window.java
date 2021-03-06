package Mgmt_Sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Login_Sys.Login_System;

public class Admin_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Admin_Window(Admin user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Header = new JLabel("Hospital Management System");
		lbl_Header.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Header.setBounds(254, 11, 242, 37);
		contentPane.add(lbl_Header);
		
		JButton btn_Logout = new JButton("Logout");
		btn_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null,"Do you wish to logout?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (confirm == 0) {
					Login_System window = new Login_System();
					window.getFrame().setVisible(true);
					dispose();
				}
			}
		});
		
		btn_Logout.setBounds(656, 343, 89, 23);
		contentPane.add(btn_Logout);
		
		JLabel lbl_Access = new JLabel("Accessing System as: " + user.getRole(), SwingConstants.CENTER);
		lbl_Access.setBounds(254, 72, 242, 14);
		contentPane.add(lbl_Access);
		
		JButton btn_AddUser = new JButton("Add User");
		btn_AddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.addUser();
			}
		});
		btn_AddUser.setBounds(40, 317, 118, 49);
		contentPane.add(btn_AddUser);
		
		JLabel lbl_Welcome = new JLabel("Welcome " + user.getName(), SwingConstants.CENTER);
		lbl_Welcome.setBounds(254, 47, 242, 14);
		contentPane.add(lbl_Welcome);
		
		JButton btn_viewDepart = new JButton("Departments");
		btn_viewDepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.viewDepartments();
			}
		});
		btn_viewDepart.setBounds(193, 317, 118, 49);
		contentPane.add(btn_viewDepart);
		
		JButton btn_assignDoctor = new JButton("Assign Doctor");
		btn_assignDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.assignDoctor();
			}
		});
		btn_assignDoctor.setBounds(347, 317, 118, 49);
		contentPane.add(btn_assignDoctor);
		
	}
}
