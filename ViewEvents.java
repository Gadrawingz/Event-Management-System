import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewEvents implements ActionListener{
JFrame frame, frame1;
JTextField textbox;
JLabel lblSearchForEvent;
JButton btnSearch;
JPanel panel;
static JTable table;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/event_mis";
String userName = "root";
String password = "";
String[] columnNames = {"Event Title", "Place", "Start time", "End time", "Description" };

public void createUI()
{
frame = new JFrame("Database Search Result");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
textbox = new JTextField();
textbox.setFont(new Font("Tahoma", Font.PLAIN, 14));
textbox.setBounds(22,99,381,40); 
lblSearchForEvent = new JLabel("Search for event:");
lblSearchForEvent.setHorizontalAlignment(SwingConstants.CENTER);
lblSearchForEvent.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSearchForEvent.setForeground(new Color(0, 0, 139));
lblSearchForEvent.setBounds(22, 22, 527, 40);
btnSearch = new JButton("Search");
btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
btnSearch.setBackground(new Color(0, 0, 139));
btnSearch.setBounds(440,98,109,40);
btnSearch.addActionListener(this);

frame.getContentPane().add(textbox);
frame.getContentPane().add(lblSearchForEvent);
frame.getContentPane().add(btnSearch);
frame.setVisible(true);
frame.setSize(620, 350); 
} 



frame1 = new JFrame("Database Search Result");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.getContentPane().setLayout(new BorderLayout()); 

//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);

table = new JTable();
table.setBackground(new Color(224, 255, 255));
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

String searchValue = textbox.getText();
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
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

if(rs.next()) {
	
	eventTitle = rs.getString("e_title");
	eventPlace = rs.getString("e_place");
	eventDescr = rs.getString("e_enddate");
	eventStart = rs.getString("e_startdate");
	eventEnd = rs.getString("e_description");
	model.addRow(new Object[]{eventTitle, eventPlace, eventDescr, eventStart, eventEnd});

} else {
	JOptionPane.showMessageDialog(null, "No Record Found","Error", JOptionPane.ERROR_MESSAGE);
}} catch(Exception ex) {
	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
}
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

frame1.getContentPane().add(scroll);
frame1.setVisible(true);
frame1.setSize(598,301);



}