import java.sql.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
public class  UpdateEvent implements ActionListener{
	JTextArea textarea=new JTextArea(5,20);
	JButton b=new JButton("Get Data");
	public void createUI()
	{
		JFrame f=new JFrame();
        f.setLayout(null);
        JLabel label=new JLabel("Database data : ");        
        b.addActionListener(this);
        
        label.setBounds(10,40,100,20);
        textarea.setBounds(120,40,150,60);
        b.setBounds(120,110,100,20);
        
        f.add(label);        
        f.add(textarea);
        f.add(b);
        f.setVisible(true);
        f.setSize(350,200);
	}
    public static void main(String[] args){
    	UpdateEvent dd = new UpdateEvent();
    	dd.createUI();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		b = (JButton)e.getSource();		
		getOperation();
	}
	public void getOperation()
	{		
		try
		{

			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_mis", "root", "");
			String sql = "SELECT e_title from events";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();			
			while(rs.next())
            {           	   				
				textarea.setText(rs.getString(1));           	
            }
			
			JOptionPane.showMessageDialog(null, "Retrieved data succesfully.","Record Retrieved",
					JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}			
	}    
}