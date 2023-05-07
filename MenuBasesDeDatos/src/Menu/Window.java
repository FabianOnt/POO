package Menu;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Window extends JFrame implements ActionListener, MouseListener, ChangeListener{

	private static final long serialVersionUID = 1L;
	static int height, width;
	static JPanel panel;
	static JButton querry1, querry2, querry3, connect, disconnect, menu, saveQ1, saveQ2, saveQ3;
	static SolidRectangle rect1, rect2;
	static JLabel headline, description, label1, label2;
	static JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9;
	static Notification notification;
	static JComboBox<String> box1, box2, box3, box2A, box2B, box3A;
	static boolean online = false;
	static int selected1, selected2, selected3;
	static int querryCounter = 1;
	
	String[] options1 = {"Select", "Check All Rooms", "Check Rooms by Capacity", "Check Rooms by Type", "Check Rooms by ID"};
	String[] options2 = {"Select", "Check All Reservations", "See available rooms", "Create reservation", "Cancel reservation"};
	String[] options3 = {"Select", "Check the Full Schedule", "Check the Schedule by criteria", "Add an entry to the Schedule", "Modify the Programming of a Course in Schedule", "Delete a Course from the Schedule"};
	String[] options2A = {"Select", "One Time", "Recurrent"};
	String[] options2B = {"Select", "Particular", "All"};
	String[] options3A = {"Select", "Weekday", "Period", "Semester", "RoomID"};
	
	public Window(int width, int height) {
		Window.height = height;
		Window.width = width;
		
		components();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(width,height);							
		setLocationRelativeTo(null);					
		setLayout(null);								
		setResizable(false);							
		setVisible(true);
		
	}
	
	public void components() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 35, 38));
		panel.setBounds(0, 0, width, height);
		
		// Panel Buttons
		connect = Components.addPanelButton(0, 100, 300, 50, "Connect to DB");
		connect.addMouseListener(new Connect());
		
		disconnect = Components.addPanelButton(0, 150, 300, 50, "Disconnect from DB");
		disconnect.addMouseListener(new Disconnect());
		
		querry1 = Components.addPanelButton((int)(0), (int)(height*.35),300,50, "Querry 1");
		querry1.addMouseListener(new Querry1());
		
		querry2 = Components.addPanelButton((int)(0), (int)(height*.45),300,50, "Querry 2");
		querry2.addMouseListener(new Querry2());
		
		querry3 = Components.addPanelButton(0, (int)(height*.55),300,50,"Querry 3");
		querry3.addMouseListener(new Querry3());
		
		menu = Components.addPanelButton(0, 600, 300, 50, "Main Menu");
		menu.addMouseListener(new Menu());
		
		// Save buttons
		saveQ1 = Components.addContentButton((int)(width*0.8), (int)(height*0.8), 200, 30, "Execute");
		saveQ1.addMouseListener(new SaveQ1());
		saveQ1.setVisible(false);
		
		saveQ2 = Components.addContentButton((int)(width*0.8), (int)(height*0.8), 200, 30, "Execute");
		saveQ2.addMouseListener(new SaveQ2());
		saveQ2.setVisible(false);
		
		saveQ3 = Components.addContentButton((int)(width*0.8), (int)(height*0.8), 200, 30, "Execute");
		saveQ3.addMouseListener(new SaveQ3());
		saveQ3.setVisible(false);
		
		// Window Design
		rect1 = Components.addRectangle(0,0,300,800, Color.black);
		rect2 = Components.addRectangle(300,0,width-300,50, Color.darkGray);
		
		// Text Content
		headline = Components.addTitle(400,50,700,200, "");
		description = Components.addText(400,140,1000,200,"");
		notification = new Notification(300, 0, 500, 50);
		
		setMenuDefault();
		
		// Labels
		label1 = Components.addText(0,0,1000,30,"");
		label1.setVisible(false);
		
		label2 = Components.addText(0,0,1000,30,"");
		label2.setVisible(false);
		
		// Box elements
		box1 = Components.addBox(400,400,200,30,options1);
		box1.addItemListener(new BoxQ1());
		box1.setVisible(false);
		
		box2 = Components.addBox(400,400,200,30,options2);
		box2.addItemListener(new BoxQ2());
		box2.setVisible(false);
			
		box2A = Components.addBox(620,400,180,30,options2A);
		box2A.addItemListener(new BoxQ2A());
		box2A.setVisible(false);
		
		box2B = Components.addBox(620,400,180,30,options2B);
		box2B.addItemListener(new BoxQ2B());
		box2B.setVisible(false);
	
		box3 = Components.addBox(400,400,300,30,options3);
		box3.addItemListener(new BoxQ3());
		box3.setVisible(false);
		
		box3A = Components.addBox(710,400,180,30,options3A);
		box3A.addItemListener(new BoxQ3A());
		box3A.setVisible(false);
		
		// Textfields
		text1 = Components.addTextField(0,0,0,0);
		text1.addActionListener(this);
		text1.setVisible(false);
		
		text2 = Components.addTextField(0,0,0,0);
		text2.addActionListener(this);
		text2.setVisible(false);
		
		text3 = Components.addTextField(0,0,0,0);
		text3.addActionListener(this);
		text3.setVisible(false);
		
		text4 = Components.addTextField(0,0,0,0);
		text4.addActionListener(this);
		text4.setVisible(false);

		text5 = Components.addTextField(0,0,0,0);
		text5.addActionListener(this);
		text5.setVisible(false);
		
		text6 = Components.addTextField(0,0,0,0);
		text6.addActionListener(this);
		text6.setVisible(false);

		text7 = Components.addTextField(0,0,0,0);
		text7.addActionListener(this);
		text7.setVisible(false);
		
		text8 = Components.addTextField(0,0,0,0);
		text8.addActionListener(this);
		text8.setVisible(false);
		
		text9 = Components.addTextField(0,0,0,0);
		text9.addActionListener(this);
		text9.setVisible(false);
		
		// Implementation in main panel
		panel.add(label1);
		panel.add(label2);
		panel.add(saveQ1);
		panel.add(saveQ2);
		panel.add(saveQ3);
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		panel.add(text4);
		panel.add(text5);
		panel.add(text6);
		panel.add(text7);
		panel.add(text8);
		panel.add(text9);
		panel.add(box1);
		panel.add(box2);
		panel.add(box2A);
		panel.add(box2B);
		panel.add(box3);
		panel.add(box3A);
		panel.add(notification);
		panel.add(disconnect);
		panel.add(menu);
		panel.add(connect);
		panel.add(description);
		panel.add(headline);
		panel.add(querry1);
		panel.add(querry2);
		panel.add(querry3);
		panel.add(rect2);
		panel.add(rect1);
		
		add(panel);
		
	}
	
	public static void setMenuDefault() {
		headline.setText("Data Manager");
		description.setText("Add a description for the data base interactive window.");
	}
	
	public static void hideContent() {
		label1.setVisible(false);
		label2.setVisible(false);
		saveQ1.setVisible(false);
		saveQ2.setVisible(false);
		saveQ3.setVisible(false);
		text1.setVisible(false);
		text2.setVisible(false);
		text3.setVisible(false);
		text4.setVisible(false);
		text5.setVisible(false);
		text6.setVisible(false);
		text7.setVisible(false);
		text8.setVisible(false);
		box1.setVisible(false);
		box2.setVisible(false);
		box2A.setVisible(false);
		box2B.setVisible(false);
		box3.setVisible(false);
		description.setVisible(false);
		headline.setVisible(false);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {}
	
}
