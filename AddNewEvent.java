import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewEvent {

	private JFrame frame;
	private JTextField eventPlace;
	private JTextField eventStartTime;
	private JTextField eventDescription;
	private JTextField eventEndTime;
	private JTextField eventTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewEvent window = new AddNewEvent();
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
	public AddNewEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setBounds(100, 100, 519, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add new event");
		lblNewLabel.setToolTipText("Hello");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 11, 503, 40);
		frame.getContentPane().add(lblNewLabel);
		

		
		// Save to database!
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			private Object JOptionPane;

			public void actionPerformed(ActionEvent e) {
			 
		String sql = "INSERT INTO `events`(`e_title`, `e_place`, `e_enddate`, `e_startdate`, `e_description`) VALUES (?,?,?,?,?)";
		
		try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_mis", "root", "");
	    PreparedStatement statement = con.prepareStatement(sql);
	    
		statement.setString(1, eventTitle.getText());
	    statement.setString(2, eventPlace.getText());
	    statement.setString(3, eventStartTime.getText());
	    statement.setString(4, eventEndTime.getText());
	    statement.setString(5, eventDescription.getText());
	    
	    // verifying if row is added...
	    int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0){
	        	((javax.swing.JOptionPane) JOptionPane).showMessageDialog(null, "Row is inserted successfully!");
	        }    
			
		} catch (SQLException ex) {
			((javax.swing.JOptionPane) JOptionPane).showMessageDialog(null, ex);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}} // end
	     
			
		});
		
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 0, 128));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(100, 253, 110, 35);
		frame.getContentPane().add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventTitle.setText("");
			    eventPlace.setText("");
			    eventStartTime.setText("");
			    eventEndTime.setText("");
			    eventDescription.setText("");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBackground(new Color(199, 21, 133));
		btnReset.setBounds(250, 253, 110, 35);
		frame.getContentPane().add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("Event Title");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(44, 62, 147, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Event Place");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(44, 102, 147, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Start Time");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(44, 138, 129, 29);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("End Time");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(299, 138, 129, 29);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		eventPlace = new JTextField();
		eventPlace.setColumns(10);
		eventPlace.setBounds(223, 102, 205, 29);
		frame.getContentPane().add(eventPlace);
		
		eventStartTime = new JTextField();
		eventStartTime.setColumns(10);
		eventStartTime.setBounds(44, 160, 129, 29);
		frame.getContentPane().add(eventStartTime);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Description");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(44, 200, 147, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		eventDescription = new JTextField();
		eventDescription.setColumns(10);
		eventDescription.setBounds(223, 200, 205, 29);
		frame.getContentPane().add(eventDescription);
		
		eventEndTime = new JTextField();
		eventEndTime.setColumns(10);
		eventEndTime.setBounds(299, 160, 129, 29);
		frame.getContentPane().add(eventEndTime);
		
		eventTitle = new JTextField();
		eventTitle.setColumns(10);
		eventTitle.setBounds(223, 62, 205, 29);
		frame.getContentPane().add(eventTitle);
	}
}
