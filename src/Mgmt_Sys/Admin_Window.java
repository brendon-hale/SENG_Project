package Mgmt_Sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbl_Header = new JLabel("Hospital Management System");
		lbl_Header.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Header.setBounds(254, 11, 242, 37);
		contentPane.add(lbl_Header);
		
		JLabel lbl_UserRole = new JLabel("Accessing System as: " + user.getRole());
		lbl_UserRole.setBounds(567, 19, 186, 24);
		contentPane.add(lbl_UserRole);
	}

}
