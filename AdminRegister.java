import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminRegister {

	protected static final JOptionPane JOptionPane = null;
	private JFrame frame;
	private JTextField username;
	private JTextField email;
	private JTextField password;
	private JTextField names;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister window = new AdminRegister();
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
	public AdminRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 133, 63));
		frame.setBounds(100, 100, 519, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Admin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(255, 228, 225));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 22, 503, 29);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String sql = "INSERT INTO `admins`(`admin_id`, `admin_names`, `username`, `email`, `password`) VALUES (?,?,?,?,?)";
				
				try {
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_mis", "root", "");
			    PreparedStatement statement = con.prepareStatement(sql);
			    
			    statement.setString(1, null);
				statement.setString(2, names.getText());
			    statement.setString(3, username.getText());
			    statement.setString(4, email.getText());
			    statement.setString(5, password.getText());
			    
			    // verifying if row is added...
			    int rowsInserted = statement.executeUpdate();
			        if (rowsInserted > 0){
			        	((javax.swing.JOptionPane) JOptionPane).showMessageDialog(null, "Admin registered!");
			        }    
					
				} catch (SQLException ex) {
					((javax.swing.JOptionPane) JOptionPane).showMessageDialog(null, ex);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // end
				
			}
		});
		
		
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(154, 205, 50));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(104, 253, 110, 35);
		frame.getContentPane().add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				names.setText("");
				username.setText("");
			    email.setText("");
			    password.setText("");
				
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBackground(new Color(178, 34, 34));
		btnReset.setBounds(250, 253, 110, 35);
		frame.getContentPane().add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("Names");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(44, 78, 124, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(44, 118, 124, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(44, 158, 124, 29);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(44, 198, 137, 29);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(222, 120, 205, 29);
		frame.getContentPane().add(username);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(221, 160, 206, 29);
		frame.getContentPane().add(email);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(221, 200, 206, 29);
		frame.getContentPane().add(password);
		
		names = new JTextField();
		names.setColumns(10);
		names.setBounds(222, 80, 205, 29);
		frame.getContentPane().add(names);
	}
}
