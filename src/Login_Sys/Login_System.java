package Login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login_System {

	private JFrame frame;
	private JTextField txt_Username;
	private JPasswordField txt_Password;
	protected JFrame frmLoginSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_LoginSystem = new JLabel("Login System");
		lbl_LoginSystem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_LoginSystem.setBounds(267, 11, 118, 28);
		frame.getContentPane().add(lbl_LoginSystem);
		
		JLabel lbl_Username = new JLabel("Username");
		lbl_Username.setBounds(113, 113, 59, 14);
		frame.getContentPane().add(lbl_Username);
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setBounds(113, 203, 46, 14);
		frame.getContentPane().add(lbl_Password);
		
		txt_Username = new JTextField();
		txt_Username.setBounds(241, 110, 180, 20);
		frame.getContentPane().add(txt_Username);
		txt_Username.setColumns(10);
		
		JButton btn_Login = new JButton("Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txt_Password.getText();
				String username = txt_Username.getText();
				
				if (password.contains("password") && username.contains("admin")) {
					txt_Password.setText(null);
					txt_Username.setText(null);
				}
				
				else {
					JOptionPane.showMessageDialog(null,  "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_Login.setBounds(113, 327, 89, 23);
		frame.getContentPane().add(btn_Login);
		
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
		frame.getContentPane().add(txt_Password);
		
		JButton btn_Reset = new JButton("Reset");
		btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_Username.setText(null);
				txt_Password.setText(null);
			}
		});
		btn_Reset.setBounds(285, 327, 89, 23);
		frame.getContentPane().add(btn_Reset);
		
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
		frame.getContentPane().add(btn_Exit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(113, 314, 433, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(113, 50, 433, 2);
		frame.getContentPane().add(separator_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Patient", "Nurse", "Doctor"}));
		comboBox.setBounds(457, 109, 89, 22);
		frame.getContentPane().add(comboBox);
	}
}
