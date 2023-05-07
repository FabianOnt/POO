package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ2A implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.label1.setText("Add a Name, the RoomID and Duration (in munutes) for the reservation.");		
		Window.label2.setVisible(false);
		
		Window.text2.setVisible(true);
		Window.text3.setVisible(true);
		Window.text4.setVisible(true);
		
		Window.text5.setVisible(false);
		Window.text6.setVisible(false);
		Window.text7.setVisible(false);
		Window.text8.setVisible(false);
		
		switch(Window.box2A.getSelectedIndex()) {
			case 0 -> {
				Window.label2.setVisible(false);		
			}
			case 1 -> {
				Window.label2.setText("Enter the date of the reservation in the format (YYYY-MM-DD HH:MM) and execute.");	
				Window.label2.setVisible(true);
				Window.text5.setVisible(true);
				Querry2.querrymode = 3;
			}
			case 2 -> {
				Window.label2.setText("Enter the Period (e.g SPRING-22, AUTUMN-23), Weekday (integer), Hour and Minute of the reservation and execute.");
				Window.label2.setVisible(true);
				Window.text5.setVisible(true);
				Window.text6.setVisible(true);
				Window.text7.setVisible(true);
				Window.text8.setVisible(true);
				Querry2.querrymode = 4;
			}
		}
	}

}
