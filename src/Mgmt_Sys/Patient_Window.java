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
import javax.swing.border.EmptyBorder;

import Login_Sys.Login_System;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Patient_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Patient_Window(Patient user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Hospital Management System");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(287, 0, 242, 37);
		contentPane.add(label);
		
		JLabel lbl_Access = new JLabel("Accessing System as: " + user.getRole(), SwingConstants.CENTER);
		lbl_Access.setBounds(287, 58, 242, 14);
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
		btn_Logout.setBounds(714, 353, 89, 23);
		contentPane.add(btn_Logout);
		
		JLabel lbl_Welcome = new JLabel("Welcome " + user.getName(), SwingConstants.CENTER);
		lbl_Welcome.setBounds(287, 33, 242, 14);
		contentPane.add(lbl_Welcome);
		
		JLabel lbl_TestResults = new JLabel("Test Results");
		lbl_TestResults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_TestResults.setBounds(25, 84, 97, 23);
		contentPane.add(lbl_TestResults);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(35, 117, 407, 128);
		textArea.append(user.printTestResults());
		contentPane.add(textArea);
		
	}
}
