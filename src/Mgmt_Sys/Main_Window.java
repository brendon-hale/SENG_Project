package Mgmt_Sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Main_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Main_Window(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Header = new JLabel("Hospital Management System");
		lbl_Header.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Header.setBounds(254, 11, 242, 37);
		contentPane.add(lbl_Header);
		
		JLabel lbl_UserRole = new JLabel("Accessing System as: " + user.getRole());
		lbl_UserRole.setBounds(567, 19, 186, 24);
		contentPane.add(lbl_UserRole);
	}
}
