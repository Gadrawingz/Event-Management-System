import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AdminLogin {

	protected static final String DBUSER = "root";
	protected static final String DBPASS = "";
	protected static final String DBURL = "jdbc:mysql://localhost:3306/event_mis";

	private JFrame frame;
	private JPasswordField adminPass;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 133, 63));
		frame.setBounds(100, 100, 588, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(255, 228, 225));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 11, 572, 43);
		frame.getContentPane().add(lblNewLabel);
	
		
		// Login Button
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		          try
		          {
		               //Loading the driver
		               Class.forName("oracle.jdbc.driver.OracleDriver");
		               Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		               
					// Display the record
		               String sql1 = "SELECT * FROM `admins` WHERE username='' AND password=''";
		               Statement stmt = (Statement) con.createStatement();
		               ResultSet result = ((java.sql.Statement) stmt).executeQuery(sql1);

		               
		            	   JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);	
		          }  catch(Exception ex) {
	               ex.printStackTrace();
	          }}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(50, 205, 50));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(150, 194, 125, 38);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Back Home");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBackground(new Color(178, 34, 34));
		btnReset.setBounds(310, 194, 131, 38);
		frame.getContentPane().add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(47, 65, 228, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextField username = new JTextField();
		username.setBounds(47, 116, 228, 38);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(307, 65, 223, 38);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		adminPass = new JPasswordField();
		adminPass.setBounds(307, 116, 223, 38);
		frame.getContentPane().add(adminPass);
		
	}
	

	private void jCheckBoxPasswordActionPerformed(java.awt.event.ActionEvent evt) {
		AbstractButton chckbxShowPw;
		
	}
	
}