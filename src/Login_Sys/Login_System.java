package Login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Mgmt_Sys.Admin;
import Mgmt_Sys.Admin_Window;
import Mgmt_Sys.Constants;
import Mgmt_Sys.Doctor;
import Mgmt_Sys.Doctor_Window;
import Mgmt_Sys.Nurse;
import Mgmt_Sys.Nurse_Window;
import Mgmt_Sys.Patient;
import Mgmt_Sys.Patient_Window;
import Mgmt_Sys.User;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login_System {

	private JFrame frame;
	private JTextField txt_Username;
	private JPasswordField txt_Password;
	protected JFrame frmLoginSystem;
	
//	public static Data_Model dataModel = new Data_Model();
	public static Data_Model dataModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		if (dataModel == null) {
			dataModel = new Data_Model();
			Test_Provider provider = new Test_Provider();
			dataModel.UserData = provider.getUserData();
		}
		
		frame = new JFrame();
		getFrame().setBounds(100, 100, 675, 421);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lbl_LoginSystem = new JLabel("Login System");
		lbl_LoginSystem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_LoginSystem.setBounds(267, 11, 118, 28);
		getFrame().getContentPane().add(lbl_LoginSystem);
		
		JLabel lbl_Username = new JLabel("Username");
		lbl_Username.setBounds(113, 113, 72, 14);
		getFrame().getContentPane().add(lbl_Username);
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setBounds(113, 203, 72, 14);
		getFrame().getContentPane().add(lbl_Password);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {Constants.patient, Constants.nurse, Constants.doctor, Constants.admin}));
		comboBox.setBounds(457, 109, 89, 22);
		getFrame().getContentPane().add(comboBox);
		
		txt_Username = new JTextField();
		txt_Username.setBounds(241, 110, 180, 20);
		getFrame().getContentPane().add(txt_Username);
		txt_Username.setColumns(10);
		
		JButton btn_Login = new JButton("Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Should make this a function
				
				String username = txt_Username.getText();
				String password = txt_Password.getText();
				String role = comboBox.getSelectedItem().toString();
				
				User user = new User(username, password, role);
				
				boolean found = false;

//				User us = null;
					
				for (int i = 0; i < dataModel.UserData.size(); i++) {
					if ((dataModel.UserData.get(i).getName().equals(user.getName())) && (dataModel.UserData.get(i).getPass().equals(user.getPass())) && (dataModel.UserData.get(i).getRole().contentEquals(user.getRole()))) {
						getFrame().dispose();
						
						if (user.getRole() == Constants.admin) {
							
							Admin us = new Admin(user.getName(), user.getRole(), Constants.admin);
							us.dataModel = dataModel;
							
							System.out.println("Login_System dataModel: " + dataModel);
							System.out.println("us dataModel: " + us.dataModel);
							
							
							Admin_Window adminSys = new Admin_Window((Admin) us);
							adminSys.setVisible(true);
						}
						
						if (user.getRole() == Constants.doctor) {
							
//							us = new Doctor(user.getName(), user.getRole(), Constants.doctor);
							Doctor us = new Doctor(user.getName(), user.getRole(), Constants.doctor);
							
							Doctor_Window doctorSys = new Doctor_Window((Doctor) us);
							doctorSys.setVisible(true);
						}
						
						if (user.getRole() == Constants.nurse) {
							
//							us = new Nurse(user.getName(), user.getRole(), Constants.nurse);
							Nurse us = new Nurse(user.getName(), user.getRole(), Constants.nurse);
							
							Nurse_Window nurseSys = new Nurse_Window((Nurse) us);
							nurseSys.setVisible(true);
						}
						
						if (user.getRole() == Constants.patient) {
							
//							us = new Patient(user.getName(), user.getRole(), Constants.patient);
							Patient us = new Patient(user.getName(), user.getRole(), Constants.patient);
							
							Patient_Window patientSys = new Patient_Window((Patient) us);
							patientSys.setVisible(true);
						}

						if (user != null)
							found = true;
					}
				}
				
				if (!found) {
					JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
				}
					
			}
		});
		
		btn_Login.setBounds(113, 327, 89, 23);
		getFrame().getContentPane().add(btn_Login);
		
		txt_Password = new JPasswordField();
		txt_Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					btn_Login.doClick();
				}
			}
		});
		txt_Password.setBounds(241, 200, 180, 20);
		getFrame().getContentPane().add(txt_Password);
		
		JButton btn_Reset = new JButton("Reset");
		btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_Username.setText(null);
				txt_Password.setText(null);
			}
		});
		btn_Reset.setBounds(285, 327, 89, 23);
		getFrame().getContentPane().add(btn_Reset);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem,  "Confirm if you want to exit", "Login Systems", 
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btn_Exit.setBounds(457, 327, 89, 23);
		getFrame().getContentPane().add(btn_Exit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(113, 314, 433, 2);
		getFrame().getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(113, 50, 433, 2);
		getFrame().getContentPane().add(separator_1);
		
	}

	public JFrame getFrame() {
		return frame;
	}
}
