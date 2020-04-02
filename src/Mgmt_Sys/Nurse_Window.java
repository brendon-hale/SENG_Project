package Mgmt_Sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Login_Sys.Login_System;

import javax.swing.JButton;

public class Nurse_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Nurse_Window(Nurse user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Hospital Management System");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(281, 11, 242, 37);
		contentPane.add(label);
		
		JLabel lbl_Access = new JLabel("Accessing System as: " + user.getRole(), SwingConstants.CENTER);
		lbl_Access.setBounds(281, 71, 188, 14);
		contentPane.add(lbl_Access);
		
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
		btn_Logout.setBounds(727, 351, 89, 23);
		contentPane.add(btn_Logout);
		
		JLabel lbl_Welcome = new JLabel("Welcome " + user.getName(), SwingConstants.CENTER);
		lbl_Welcome.setBounds(281, 46, 242, 14);
		contentPane.add(lbl_Welcome);
	}

}
