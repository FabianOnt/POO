package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ2B implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.description.setText("Choose between cancelling a particular reservation or all the reservations between two dates. ");		
				
		Window.hideLabels();
		Window.hideTextFields();
		Window.clearTextFields();
		
		switch(Window.box2B.getSelectedIndex()) {
			case 0 ->{}
			case 1 ->{
				Window.description.setText("<html>Add the RoomID and Name for the reservation.<br/>"
						+ "Enter the date in the format (YYYY-MM-DD HH:MM) and execute.<html>");
				
				Window.label1.setText("RoomID");
				Window.label2.setText("Name");
				Window.label3.setText("Date");
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.label3.setVisible(true);
				
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				
				Querry2.querrymode = 5;
			}
			case 2 ->{
				Window.description.setText("<html>Add the RoomID and Name for the reservation.<br/>"
						+ "Enter the INITIAL and FINAL date in the format (YYYY-MM-DD HH:MM) and execute.<html>");
				
				Window.label1.setText("RoomID");
				Window.label2.setText("Name");
				Window.label3.setText("Initial Date");
				Window.label4.setText("Final Date");
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.label3.setVisible(true);
				Window.label4.setVisible(true);
				
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				
				Querry2.querrymode = 6;
			}
		
		}
	}
}
