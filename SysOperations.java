
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SysOperations implements ActionListener{
JFrame frame, frame1;
JLabel lblSearchForEvent;
JButton btnSearch;
JButton btnDelete;
JButton btnViewAll;
JPanel panel;

JTextField searchBox;
JTextField searchArea;
JTextField deleteArea;

static JTable table;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/event_mis";
String userName = "root";
String password = "";
String[] columnNames = {"Event Title", "Place", "Start time", "End time", "Description" };

public void createUI()
{
frame = new JFrame("Event Operations");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
lblSearchForEvent = new JLabel("Admin Operations");
lblSearchForEvent.setHorizontalAlignment(SwingConstants.CENTER);
lblSearchForEvent.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSearchForEvent.setForeground(new Color(0, 0, 139));
lblSearchForEvent.setBounds(22, 22, 527, 40);
btnSearch = new JButton("Search");
btnSearch.setForeground(Color.WHITE);
btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
btnSearch.setBackground(new Color(128, 0, 128));
btnSearch.setBounds(242,128,109,40);
btnSearch.addActionListener(this);
frame.getContentPane().add(lblSearchForEvent);
frame.getContentPane().add(btnSearch);
btnDelete = new JButton("Delete");
btnDelete.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		btnDelete = (JButton)e.getSource();
		String delValue = deleteArea.getText();
					try
					{ 
					Class.forName(driverName); 
					Connection con = DriverManager.getConnection(url, userName, password);
					String sqldel = "DELETE FROM `events` WHERE e_id='"+delValue+"'";
					PreparedStatement ps = con.prepareStatement(sqldel);
					ps.setString(0, delValue);		

			        int rowsDeleted = ps.executeUpdate();
			        if (rowsDeleted > 0)
			        {
			        	JOptionPane.showMessageDialog(null, "The row "+delValue+"  is deleted!", "Deletion", JOptionPane.WARNING_MESSAGE);
			        }}catch(Exception ex) {
			        	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
			        }}
});
btnDelete.setForeground(Color.WHITE);
btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
btnDelete.setBackground(new Color(0, 0, 139));
btnDelete.setBounds(440, 128, 109, 40);
frame.getContentPane().add(btnDelete);
btnViewAll = new JButton("View All");

btnViewAll.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		showAllData();
	}
});
btnViewAll.setForeground(Color.WHITE);
btnViewAll.setFont(new Font("Tahoma", Font.BOLD, 14));
btnViewAll.setBackground(new Color(0, 0, 139));
btnViewAll.setBounds(49, 97, 109, 40);
frame.getContentPane().add(btnViewAll);
searchArea = new JTextField();
searchArea.setBounds(211, 83, 175, 34);
frame.getContentPane().add(searchArea);
searchArea.setColumns(10);
deleteArea = new JTextField();
deleteArea.setColumns(10);
deleteArea.setBounds(440, 83, 109, 34);
frame.getContentPane().add(deleteArea);
frame.setVisible(true);
frame.setSize(620, 350); 
} 

public void actionPerformed(ActionEvent ae)
{
btnSearch = (JButton)ae.getSource();
System.out.println("Showing Table Data.......");
showTableData(); 
} 

public void showTableData()
{

frame1 = new JFrame("Database Search Result");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.getContentPane().setLayout(new BorderLayout()); 

//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);

table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

String searchValue = searchArea.getText();

String eventTitle= "";
String eventPlace= "";
String eventDescr= "";
String eventStart= "";
String eventEnd  = "";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "SELECT * FROM `events` WHERE e_title LIKE '%"+searchValue+"%'";

PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

int i =0;
while(rs.next()) {
	
	eventTitle = rs.getString("e_title");
	eventPlace = rs.getString("e_place");
	eventDescr = rs.getString("e_enddate");
	eventStart = rs.getString("e_startdate");
	eventEnd = rs.getString("e_description");
	model.addRow(new Object[]{eventTitle, eventPlace, eventDescr, eventStart, eventEnd});
	
	i++;

} if(i <1) {
	JOptionPane.showMessageDialog(null, "No Record Found","Error", JOptionPane.ERROR_MESSAGE);

} if(i ==1) {
	System.out.println(i+" Record Found");
} else {
	System.out.println(i+" Records Found");
	}
} catch(Exception ex) {
	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
}

frame1.getContentPane().add(scroll);
frame1.setVisible(true);
frame1.setSize(500,300);
}


public void showAllData()
{

frame1 = new JFrame("All Data Results");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.getContentPane().setLayout(new BorderLayout()); 

//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);

table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

String eventTitle= "";
String eventPlace= "";
String eventDescr= "";
String eventStart= "";
String eventEnd  = "";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "SELECT * FROM `events` ";

PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

int i =0;
while(rs.next()) {
	
	eventTitle = rs.getString("e_title");
	eventPlace = rs.getString("e_place");
	eventDescr = rs.getString("e_enddate");
	eventStart = rs.getString("e_startdate");
	eventEnd = rs.getString("e_description");
	model.addRow(new Object[]{eventTitle, eventPlace, eventDescr, eventStart, eventEnd});
	
	i++;

} if(i <1) {
	JOptionPane.showMessageDialog(null, "No Record Found","Error", JOptionPane.ERROR_MESSAGE);

} if(i ==1) {
	System.out.println(i+" Record Found");
} else {
	System.out.println(i+" Records Found");
	}
} catch(Exception ex) {
	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
}

frame1.getContentPane().add(scroll);
frame1.setVisible(true);
frame1.setSize(500,300);
}



public static void main(String args[]) {

	SysOperations sr = new SysOperations();
	sr.createUI(); 
	}
}